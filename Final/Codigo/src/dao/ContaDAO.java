/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dss.classes.Conta;
import dss.classes.Pagamento;
import java.sql.*;
import java.util.*;

/**
 *
 * @author gil
 */
public class ContaDAO implements List<Conta>{
    
    
    
    
    public static int putConta(Conta conta, Map<String,Pagamento> emails) throws SQLException {
    Connection c = Connect.connect();
    PreparedStatement preparedStmt1 = null;
    PreparedStatement preparedStmt=null;
    int resultado =0;
    
    try{
        
     c.setAutoCommit(false);
     String query = " insert into conta (nome,nrPessoasPagaram,nrPessoasApagar,dataLimite,dataPagamento,"
             + "totalConta,totalContaPago,pago,tipo)"
        + " values (?,?,?,?,?,?,?,?,?)";
     String query1 = " insert into pagamento (idConta, idUtilizador,valorPago,valorApagar)"
        + " values (?,?,?,?)";
    
    
     
     preparedStmt = c.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
     String nome = conta.getNome();
     String tipo = conta.getTipo();
     int numeroPessoasApagar = conta.getUtilizadoresPagam();
     float contaApagar = conta.getTotalFactura();
     GregorianCalendar data = conta.getDataLimite();
     java.sql.Date startDate = new java.sql.Date(data.getTime().getTime());
     
      preparedStmt.setString(1,nome);
      preparedStmt.setInt(2,0);
      preparedStmt.setInt(3, numeroPessoasApagar);
      preparedStmt.setDate(4, startDate);
      preparedStmt.setNull(5, Types.NULL);
      preparedStmt.setFloat(6, contaApagar);
      preparedStmt.setFloat(7, 0);
      preparedStmt.setBoolean(8, false);
      preparedStmt.setString(9, tipo);
      
     preparedStmt.execute();
     
     
      ResultSet tableKeys = preparedStmt.getGeneratedKeys();
      tableKeys.next();
      int autoGeneratedID = tableKeys.getInt(1); 
     
    
      ResultSet rs = c.createStatement()
                .executeQuery("select idUtilizador , email from Morador");
      String email;
      int idUlti;
      Pagamento p;
      int size = emails.size();
      preparedStmt1=c.prepareStatement(query1);

      while(rs.next() && size>0) {
          
          email = rs.getString("email");
          idUlti = rs.getInt("idUtilizador");
          
          if(emails.containsKey(email)) {
              size--;
          
              p=emails.get(email);
               preparedStmt1.setInt(1, autoGeneratedID);
               preparedStmt1.setInt(2, idUlti);
               preparedStmt1.setFloat(3, -1);
               preparedStmt1.setFloat(4,p.getValorApagar());
         
              preparedStmt1.execute();
              
          }
          
    
      }
     
    c.commit();
     
    }

    catch (SQLException e) {
        
        //System.err.println("Got an exception!");
        //System.err.println(e.getMessage());
        if (c != null) {
            try {
                //System.err.println("Transaction is being rolled back");
                c.rollback();
                
            } catch(SQLException excep) {
                //System.err.println(excep.getMessage());
            }
        }
       
    }
    finally {
    
         if (preparedStmt1 != null) {
            preparedStmt1.close();
        }
        if (preparedStmt != null) {
            preparedStmt.close();
        }
        
        
        c.setAutoCommit(true);
        
        
        c.close();
        
    }    
    return resultado;
    
    }
    
    
    public static List<Conta> contasPagas () throws SQLException {
    
        List<Conta> contasPagas = new ArrayList<>();
        Connection c = Connect.connect();
        try {
        String query = "select C.idConta,C.nome,C.nrPessoasPagaram,C.dataLimite,C.totalConta,"
                + "C.dataPagamento,C.tipo from conta AS C "
                + "where pago=true"
                + " order by C.dataPagamento DESC";
        
       ResultSet rs = c.createStatement()
                .executeQuery(query); 
        
       
       String nomeConta,tipo;
       int nrPessoasPagaram,idConta;
       GregorianCalendar dataPagamento,dataLimite;
       float totalConta;
      
      
       
       while(rs.next()) {
           dataPagamento=new GregorianCalendar();
      dataLimite = new GregorianCalendar();
         
           nomeConta = rs.getString("C.nome");
           tipo = rs.getString("C.tipo");
           nrPessoasPagaram=rs.getInt("C.nrPessoasPagaram");
           idConta=rs.getInt("C.idConta");
           totalConta=rs.getFloat("C.totalConta");
           java.sql.Date dbSqlDate = rs.getDate("C.dataLimite");
           dataLimite.setTime(dbSqlDate);
           java.sql.Date dbSqlDate1 = rs.getDate("C.dataPagamento");
           dataPagamento.setTime(dbSqlDate1);
           
           
           
       Conta conta = new Conta(nomeConta, tipo,nrPessoasPagaram,totalConta,dataPagamento, dataLimite,idConta);
       
       contasPagas.add(conta);
          
       }
       
     } catch(SQLException e)
       {     }
     finally
        { c.close();}
          
    
    c.close();
    return contasPagas;
    }
    
  public static List<Conta> contasPagasUser (String email) throws SQLException {
     List<Conta> contasPagas = new ArrayList<>();
     Connection c = Connect.connect();  
    try{ 
     String query = "select C.idConta,C.nrPessoasPagaram, C.totalConta,C.dataLimite,C.dataPagamento,C.tipo,C.nome "
             + "from conta as C inner join pagamento as P on C.idConta=P.idConta  "
             + "inner join morador as M on M.idUtilizador=P.idUtilizador"
             + " where email='"+email+"' and pago=true"
             + " order by C.dataPagamento DESC";
     ResultSet rs = c.createStatement()
                .executeQuery(query); 
      
     String nomeConta,tipo;
       int nrPessoasPagaram,idConta;
       GregorianCalendar dataPagamento,dataLimite;
       float totalConta;
       
     
     while(rs.next()) {
        dataPagamento=new GregorianCalendar();
      dataLimite = new GregorianCalendar();
         
         nomeConta = rs.getString("C.nome");
           tipo = rs.getString("C.tipo");
           nrPessoasPagaram=rs.getInt("C.nrPessoasPagaram");
           idConta=rs.getInt("C.idConta");
           totalConta=rs.getFloat("C.totalConta");
           java.sql.Date dbSqlDate = rs.getDate("C.dataLimite");
           dataLimite.setTime(dbSqlDate);
           java.sql.Date dbSqlDate1 = rs.getDate("C.dataPagamento");
           dataPagamento.setTime(dbSqlDate1);
           
           
           
       Conta conta = new Conta(nomeConta, tipo,nrPessoasPagaram,totalConta,dataPagamento, dataLimite,idConta);
       
       contasPagas.add(conta);
     }
    } catch(SQLException e)
       {     }
     finally
        { c.close();}
        
    return contasPagas;   
  }   
    
  
 public static List<Conta> contasPorPagarAdmin () throws SQLException {
 
     List<Conta> contasPagas = new ArrayList<>();
        Connection c = Connect.connect();
        
        String query = "select C.idConta,C.nome,C.nrPessoasPagaram,C.dataLimite,C.totalConta,"
                + "C.tipo,C.nrPessoasApagar,C.totalContaPago from conta AS C "
                + " where pago=false"
                + " order by C.dataLimite ASC";
        try { 
       ResultSet rs = c.createStatement()
                .executeQuery(query); 
        
       
       String nomeConta,tipo;
       int nrPessoasPagaram,idConta,nrPessoasApagar;
       GregorianCalendar dataLimite;
       float totalConta,totalContaPago;
      
     
       
       while(rs.next()) {
           
      dataLimite = new GregorianCalendar();
         
           nomeConta = rs.getString("C.nome");
           tipo = rs.getString("C.tipo");
           nrPessoasPagaram=rs.getInt("C.nrPessoasPagaram");
           idConta=rs.getInt("C.idConta");
           totalConta=rs.getFloat("C.totalConta");
           java.sql.Date dbSqlDate = rs.getDate("C.dataLimite");
           dataLimite.setTime(dbSqlDate);
           totalContaPago=rs.getFloat("C.totalContaPago");
           nrPessoasApagar=rs.getInt("C.nrPessoasApagar");
           
       Conta conta = new Conta(nomeConta, tipo,totalConta,dataLimite,nrPessoasApagar,nrPessoasPagaram,idConta,totalContaPago);
       
       contasPagas.add(conta);
       
       
       }
       
      } catch(SQLException e)
       { //System.out.println(e.getMessage());
      
      }finally
        { c.close();}
      
    return contasPagas;
     
 } 
 
public static List<Conta> contasPorPagarUser (String user) throws SQLException {
 
     List<Conta> contasPagas = new ArrayList<>();
        Connection c = Connect.connect();
        
        String query = "select C.idConta,C.nome,C.nrPessoasPagaram,C.dataLimite,C.totalConta,"
                + "C.tipo,C.nrPessoasApagar,C.totalContaPago from conta AS C "
                + "inner join Pagamento as P on P.idConta =C.idConta "
                + " inner join morador as M on M.idUtilizador = P.idUtilizador "
                + " where pago=false and M.email ='"+user+"'"
                + " order by C.dataLimite ASC";
       try {
           
       ResultSet rs = c.createStatement()
                .executeQuery(query); 
        
       
       String nomeConta,tipo;
       int nrPessoasPagaram,idConta,nrPessoasApagar;
       GregorianCalendar dataLimite;
       float totalConta,totalContaPago;
      
      
       
       while(rs.next()) {
           
      dataLimite = new GregorianCalendar();
         
           nomeConta = rs.getString("C.nome");
           tipo = rs.getString("C.tipo");
           nrPessoasPagaram=rs.getInt("C.nrPessoasPagaram");
           idConta=rs.getInt("C.idConta");
           totalConta=rs.getFloat("C.totalConta");
           java.sql.Date dbSqlDate = rs.getDate("C.dataLimite");
           dataLimite.setTime(dbSqlDate);
           totalContaPago=rs.getFloat("C.totalContaPago");
           nrPessoasApagar=rs.getInt("C.nrPessoasApagar");
           
       Conta conta = new Conta(nomeConta, tipo,totalConta,dataLimite,nrPessoasApagar,nrPessoasPagaram,idConta,totalContaPago);
       
       contasPagas.add(conta);
       
       
       }
       
      } catch(SQLException e)
       { //System.out.println(e.getMessage());
      
      }
    finally
        { c.close();}
    return contasPagas;
     
 } 
   
 
 public static float ultimoApagar(int idConta) throws SQLException {
 
       Connection c = Connect.connect();
       String query = "select nrPessoasPagaram , nrPessoasApagar ,totalConta, totalContaPago from conta "
               + " where idConta='"+idConta+"'";
       int nrPessoas =0;
       int nrPessoasPagaram=0;
       float totalPago=0;
       float totalApagar=0;
       float retorno=-1;
       
  try {
      ResultSet rs = c.createStatement()
                .executeQuery(query); 
      rs.next();
      nrPessoas= rs.getInt("nrPessoasApagar");
      nrPessoasPagaram = rs.getInt("nrPessoasPagaram");
      totalPago = rs.getFloat("totalContaPago");
      totalApagar = rs.getFloat("totalConta");
      
      
      if(nrPessoas-1==nrPessoasPagaram) {
      
          retorno = totalApagar-totalPago;
          
      }
     
 } catch(SQLException e)
       { //System.out.println(e.getMessage());
      
      }
    finally
        { c.close();}
  
  return retorno;
 
 }
 
 
 public static float valorConta(int idConta) throws SQLException {
 
      Connection c = Connect.connect();
       String query = "select totalConta from conta "
               + " where idConta='"+idConta+"'";
       
       float totalApagar=0;
       
       
  try {
      ResultSet rs = c.createStatement()
                .executeQuery(query); 
      rs.next();
      
      totalApagar = rs.getFloat("totalConta");
      
      
      
     
 } catch(SQLException e)
       { //System.out.println(e.getMessage());
      
      }
    finally
        { c.close();}
  
  return totalApagar;
 
 
 }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Conta> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Conta e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends Conta> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection<? extends Conta> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta set(int i, Conta e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int i, Conta e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta remove(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<Conta> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<Conta> listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Conta> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
