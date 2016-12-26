/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dss.classes.Emprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author gil
 */
public class EmprestimoDAO implements Map<String,List<Emprestimo>> {
    
    
   public static int  putEmprestimo (Emprestimo emp) throws SQLException {
   
       int resultado=0;
       Connection c = Connect.connect();
       PreparedStatement preparedStmt;
       
       try {
           
       String query = "select idUtilizador from morador where email = '"+emp.getEmail()+"'";
       
        ResultSet rs = c.createStatement()
                .executeQuery(query);
              rs.next();
       
       int idUtilizador=rs.getInt(1);
      
       
        query= "insert into emprestimo (valor,dataEmprestimo,idUtilizador) values (?,?,?)";
        
       
        preparedStmt = c.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        GregorianCalendar date = emp.getData();
        float valor = emp.getValor();
        
        
        java.sql.Date startDate = new java.sql.Date(date.getTime().getTime());
       
        preparedStmt.setFloat(1, valor);
        preparedStmt.setDate(2, startDate);
        preparedStmt.setInt(3, idUtilizador);
       
       
       preparedStmt.execute();
       } catch (SQLException e) {
       
          System.err.println(e.getMessage());
       
       }
       finally {
       
    c.close();
       }
   return resultado;
   }
   
   
   public static int removeEmprestimo (float valor) throws SQLException {
       
       int resultado=0;
       
       
       float valorEmprestimo;
       int idEmprestimo;
       int idUtilizador;
       Connection c = Connect.connect();
       PreparedStatement preparedStmt;
      try { 
      
       
           String query = "select idEmprestimo, valor ,idUtilizador from emprestimo order by dataEmprestimo ASC";
            ResultSet rs = c.createStatement()
                .executeQuery(query);
            
       while(valor>0 && rs.next()) {  
           
           valorEmprestimo =rs.getFloat("valor");
           idEmprestimo = rs.getInt("idEmprestimo");
           idUtilizador = rs.getInt("idUtilizador");
           
           if(valorEmprestimo<=valor) {
           
              
               valor = valor -valorEmprestimo;
               query = "delete from emprestimo where idEmprestimo = '" +idEmprestimo+"'";
               
               preparedStmt=c.prepareStatement(query);
               preparedStmt.execute();
               
               query= "update morador set valorConta = valorConta + '"+valorEmprestimo+"'" + "where idUtilizador ='"+ 
                       idUtilizador+"'" ;
               
               preparedStmt=c.prepareStatement(query);
               preparedStmt.execute();
               
           }
           
           else {
               
               query = "update emprestimo set valor = valor - '"+valor+"'" +"where idEmprestimo = '" +idEmprestimo+"'";
               preparedStmt=c.prepareStatement(query);
               preparedStmt.execute();
               
               
               query = "update morador set valorConta = valorConta + '"+valor+"'" + "where idUtilizador ='"+ 
                       idUtilizador+"'" ;
               
               preparedStmt=c.prepareStatement(query);
               preparedStmt.execute();
               
               valor = valor -valorEmprestimo;
             
           }
           
       }
       
       } catch(SQLException e)
       {   System.err.println(e.getMessage());  }
     finally
        { c.close();}
          
       
   return resultado;
   }
   
   public static int getIdEmprestimo(int idEmprestimo) throws SQLException {
    
         Connection c = Connect.connect();
         int valor=0;
       try {  
        String query = "select count(*) from emprestimo where idEmprestimo ='"+idEmprestimo+"'";
        
        ResultSet rs = c.createStatement()
                .executeQuery(query);
        
        rs.next();
        valor=rs.getInt(1);
      } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { c.close();}
    return valor;
    }
   
    public static int dropEmprestimo(int idEmprestimo) throws SQLException {
      Connection c = Connect.connect();
       try {
        String dinheiro = "select valor,idUtilizador from Emprestimo where idEmprestimo='"+idEmprestimo+"'";
        int idUtilizador;
        float valor;
        ResultSet rs = c.createStatement()
                .executeQuery(dinheiro);
        rs.next();
        valor=rs.getFloat("valor");
        idUtilizador=rs.getInt("idUtilizador");
        
        
        
        String query = "delete from Emprestimo where idEmprestimo ='"+idEmprestimo+"'";
        String query2 = "update morador set valorConta=valorConta + '"+valor+"' where idUtilizador='"+idUtilizador+"'";
        PreparedStatement preparedStmt = c.prepareStatement(query);
        
        preparedStmt.execute();
        
        preparedStmt = c.prepareStatement(query2);
        
        preparedStmt.execute();
        
      } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { c.close();}
    return 0;
     }
   
   
   
   
   
   public static List<Emprestimo> darEmprestimosUser (String email,String nome) throws SQLException {
   
      
       List<Emprestimo> emprestimos = new ArrayList<>();
       
       Connection c = Connect.connect();
      try { 
       String query = "select valor , dataEmprestimo "
               + "from emprestimo as E inner join  morador as M on E.idUtilizador=M.idUtilizador"
               + " where email ='"+email+"'"
               + "order by dataEmprestimo ASC";
       
        ResultSet rs = c.createStatement()
                .executeQuery(query);
        
       
        float valor ;
        
        while(rs.next()) {
            
            java.sql.Date dbSqlDate = rs.getDate("dataEmprestimo");
            valor = rs.getFloat("valor");
            
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(dbSqlDate);
        
            Emprestimo a = new Emprestimo(email, nome, valor, cal);
            
           emprestimos.add(a);
        }
       
      } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { c.close();}
      
   return emprestimos;
   }
   
public static List<Emprestimo> darEmprestimosAdmin () throws SQLException {
   
      
       List<Emprestimo> emprestimos = new ArrayList<>();
       
       Connection c = Connect.connect();
       try {
       String query = "select idEmprestimo,nome,email, valor , dataEmprestimo "
               + "from emprestimo as E inner join  morador as M on E.idUtilizador=M.idUtilizador"
               + " order by dataEmprestimo ASC";
       
        ResultSet rs = c.createStatement()
                .executeQuery(query);
        
        GregorianCalendar data;
        float valor ;
        String email;
        String nome;
        int idEmprestimo;
        
        while(rs.next()) {
            
            java.sql.Date dbSqlDate = rs.getDate("dataEmprestimo");
            valor = rs.getFloat("valor");
            email=rs.getString("email");
            nome = rs.getString("nome");
            idEmprestimo=rs.getInt("idEmprestimo");
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(dbSqlDate);
        
            Emprestimo a = new Emprestimo(idEmprestimo,email, nome, valor, cal);
            
           emprestimos.add(a);
        }
       
      } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { c.close();}
       
   return emprestimos;
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
    public List<Emprestimo> get(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprestimo> put(String k, List<Emprestimo> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprestimo> remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends List<Emprestimo>> map) {
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
    public Collection<List<Emprestimo>> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, List<Emprestimo>>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

}
