/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dss.classes.Pagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author gil
 */
public class PagamentoDAO implements Map<String,Pagamento>{
    
    public static Map<String,Pagamento> getPagamentosConta(int idConta) throws SQLException {
    
     Map<String,Pagamento> pagamentos = new HashMap<>();
     Connection c = Connect.connect();
     try{
     String query = "select M.nome, M.email,P.valorPago,P.valorApagar from "
             + "morador as M inner join pagamento as P on P.idUtilizador=M.idUtilizador "
             + "where idConta='"+idConta+"'";
      
     ResultSet rs = c.createStatement()
                .executeQuery(query);
     
     String nome,email;
     float valorPago,valorApagar;
     
     while(rs.next()) {
         
         nome=rs.getString("M.nome");
         email=rs.getString("M.email");
         valorPago=rs.getFloat("P.valorPago");
         valorApagar=rs.getFloat("P.valorApagar");
         Pagamento p = new Pagamento(email, nome, valorPago,valorApagar);
         
         
         pagamentos.put(email,p);
         
     }
     } catch(SQLException e)
       {     
          System.err.println(e.getMessage());
       }
     finally
        { c.close();}
    return pagamentos;
    } 
    
    
    public static Pagamento getPagamentoUser(String email,int idConta) throws SQLException {
        
     Connection c = Connect.connect();   
       Pagamento p=null;
       try {
       String query = "select M.nome,P.valorPago,P.valorApagar from morador as M inner join "
               + " pagamento as P on P.idUtilizador = M.idUtilizador "
               + " where idConta='"+idConta+"' and email='"+email+"'";
        
        ResultSet rs = c.createStatement()
                .executeQuery(query);
        rs.next();
        String nome;
     float valorPago,valorApagar;
       
      nome=rs.getString("M.nome");
        
         valorPago=rs.getFloat("P.valorPago");
         valorApagar=rs.getFloat("P.valorApagar");
          p = new Pagamento(email, nome, valorPago,valorApagar);
        
        
        } catch(SQLException e)
       {
           System.err.println(e.getMessage());
       }
     
       finally
        { c.close();
        }
       
     return p;
    }
    
    public static float valorPagar(String email,int idConta) throws SQLException {
        
     Connection c = Connect.connect();
       float valorApagar=-1;
      try {
       String query = "select valorApagar from morador as M inner join "
               + " pagamento as P on P.idUtilizador = M.idUtilizador "
               + " where idConta='"+idConta+"' and email='"+email+"'";
        
        ResultSet rs = c.createStatement()
                .executeQuery(query);
        rs.next();
        
   
     
         valorApagar=rs.getFloat("P.valorApagar");
         } 
      catch(SQLException e)
       {
           System.err.println(e.getMessage());
       }
     
       finally
        { c.close();
        }
      
    return valorApagar; 
    }
    
    public static int verificaIdConta(String email,int idConta) throws SQLException {
    
        Connection c = Connect.connect();
       int valorApagar=0;
      try {
       String query = "select count(*) from morador as M inner join "
               + " pagamento as P on P.idUtilizador = M.idUtilizador "
               + " where idConta='"+idConta+"' and email='"+email+"'"
               + " and P.valorPago <0";
        
        ResultSet rs = c.createStatement()
                .executeQuery(query);
        rs.next();
        
   
     
         valorApagar=rs.getInt(1);
         } 
      catch(SQLException e)
       {  System.err.println(e.getMessage());  }
     
       finally
        { c.close();
        }
      
    return valorApagar; 
        
        
    }
    
    
    
    public static int pagarConta(int idConta, String email,float valor) throws SQLException {
    
        Connection c = Connect.connect();
        PreparedStatement preparedStmt1 = null;
        PreparedStatement preparedStmt=null;
        PreparedStatement preparedStmt2=null;
        
        try {
             c.setAutoCommit(false);
            String query = "update Pagamento set valorPago ='"+valor+"'"
                    + " where idConta ='"+idConta+"' and pagamento.idUtilizador=("
                    + " select idUtilizador from morador where email='"+email+"' )";
            
            String query1 = "update Conta set nrPessoasPagaram = nrPessoasPagaram +1 ,"
                    + "totalContaPago = totalContaPago+ '" +valor+"' "
                    + " where idConta='"+idConta+"'";
            
            String query2="update Morador set valorConta = valorConta - '"+valor+"'"
                    + " where email='"+email+"'";
            
           
            preparedStmt = c.prepareStatement(query);
            preparedStmt.execute();
            
            preparedStmt1=c.prepareStatement(query1);
            preparedStmt1.execute();
            
            preparedStmt2=c.prepareStatement(query2);
            preparedStmt2.execute();
            
            
            
            c.commit();
         
        }   
        catch (SQLException e) {
        
        //System.err.println("Got an exception!");
        System.err.println(e.getMessage());
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
        
        if (preparedStmt2 != null) {
            preparedStmt2.close();
        }
        
        
        
        c.setAutoCommit(true);
        
        
        c.close();
        
    }    
        
        
        
    return 0;
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
    public boolean containsKey(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pagamento get(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pagamento put(String k, Pagamento v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pagamento remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends Pagamento> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Pagamento> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Pagamento>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
