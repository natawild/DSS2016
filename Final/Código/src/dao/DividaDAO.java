/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dss.classes.Divida;
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
public class DividaDAO implements Map<String,List<Divida>> {
    
    
    public static int inserDivida(Divida d) throws SQLException {
    
         Connection c = Connect.connect();
         PreparedStatement preparedStmt=null;
          ResultSet rs=null;
         
        try {
         String query = "insert into divida (valorDivida,dataDivida,idUtilizador) values (?,?,?)";
         
         String query1 = "select idUtilizador from morador where email ='" +d.getEmail()+"'";
         
             rs = c.createStatement()
                .executeQuery(query1);
         rs.next();
         
         int idUti =rs.getInt(1);
         
         
         
          preparedStmt = c.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        GregorianCalendar date = d.getData();
        float valor = d.getValor();
        
        
        java.sql.Date startDate = new java.sql.Date(date.getTime().getTime());
         
         preparedStmt.setFloat(1, valor);
        preparedStmt.setDate(2, startDate);
        preparedStmt.setInt(3, idUti);
       
       
       preparedStmt.execute(); 
       } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        {   if(rs!=null) {
        
            rs.close();
        }
            if(preparedStmt !=null) {
            
                preparedStmt.close();
            }
            
            c.close();} 
        
        
        return 0;
    
    }
    
    
    public static int getIdDivida(int idDivida) throws SQLException {
    
         Connection c = Connect.connect();
         int valor=0;
         ResultSet rs=null;
       try {  
        String query = "select count(*) from divida where idDivida ='"+idDivida+"'";
        
                rs = c.createStatement()
                .executeQuery(query);
        
        rs.next();
        valor=rs.getInt(1);
      } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { 
            if(rs!=null) {
        
            rs.close();
        }
            
            c.close();}
    return valor;
    }
    
    
    public static int getIdDividaUser(int idDivida,String email) throws SQLException {
    
         Connection c = Connect.connect();
         int valor=0;
         ResultSet rs=null;
       try {  
        String query = "select count(*) from divida as D inner join morador as M on D.idUtilizador=M.idUtilizador where idDivida ='"+idDivida+"' "
                + " and email='"+email+"'";
        
                 rs = c.createStatement()
                .executeQuery(query);
        
        rs.next();
        valor=rs.getInt(1);
      } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { 
            if(rs!=null) {
        
            rs.close();
        }
            
            
            c.close();}
    return valor;
    }
    
    
    
    
    public static int pagaDivida(int idDivida) throws SQLException {
    
         Connection c = Connect.connect();
         PreparedStatement preparedStmt =null;
         
       try {  
        String query = "delete from divida where idDivida ='"+idDivida+"'";
        
                preparedStmt = c.prepareStatement(query);
        
        preparedStmt.execute();
        
      } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { 
            if(preparedStmt !=null) {
              preparedStmt.close();
                
            }
            
            c.close();}
    return 0;
        
    }
    
     public static float valorDivida(int idDivida) throws SQLException {
    
         Connection c = Connect.connect();
         float valor =-1;
         ResultSet rs=null;
         
       try {  
        String query = "select valorDivida from divida where idDivida ='"+idDivida+"'";
        
              rs = c.createStatement()
                .executeQuery(query);
        
        rs.next();
        valor=rs.getFloat(1);
        
       
        
      } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { 
            if(rs !=null) {
              rs.close();
                
            }
            
            c.close();}
    return valor;
        
    }
     
     public static int dropDivida(int idDivida) throws SQLException {
      Connection c = Connect.connect();
      PreparedStatement preparedStmt=null;
       try {  
        String query = "delete from divida where idDivida ='"+idDivida+"'";
        
             preparedStmt = c.prepareStatement(query);
        
        preparedStmt.execute();
        
      } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { 
            if(preparedStmt !=null) {
              preparedStmt.close();
                
            }
            
            c.close();
                    }
    return 0;
     }
    
    
    
    
    
    
    public static List<Divida> apresentarDividaUser(String email,String nome) throws SQLException {
    
        List<Divida> dividas = new ArrayList<>();
        Connection c = Connect.connect();
        ResultSet rs =null;
       try { 
        String query = "Select idDivida , dataDivida, valorDivida from Divida as D "
                + "inner join morador as M on M.idUtilizador = D.idUtilizador "
                + "where email ='"+email+"'"+
                "order by dataDivida ASC";
        
            rs = c.createStatement()
                .executeQuery(query);
        
        while(rs.next()) {
        
            int idDivida = rs.getInt("idDivida");
            float valor = rs.getFloat("valorDivida");
            java.sql.Date dbSqlDate = rs.getDate("dataDivida");
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(dbSqlDate);
            
            Divida a = new Divida(email, nome, valor, cal, idDivida);
            dividas.add(a);
            
            
        
        }
        } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { 
            if(rs!=null) {
            rs.close();
            }
            
            c.close();}
    return dividas;
    } 
    
    
    public static List<Divida> apresentarDividaAdmin() throws SQLException {
    
        List<Divida> dividas = new ArrayList<>();
        Connection c = Connect.connect();
        ResultSet rs=null;
        try {
        String query = "Select email,nome,idDivida , dataDivida, valorDivida from Divida as D "
                + "inner join morador as M on M.idUtilizador = D.idUtilizador "
                +"order by dataDivida ASC";
        
            rs = c.createStatement()
                .executeQuery(query);
        
        while(rs.next()) {
        
            int idDivida = rs.getInt("idDivida");
            float valor = rs.getFloat("valorDivida");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            java.sql.Date dbSqlDate = rs.getDate("dataDivida");
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(dbSqlDate);
            
            Divida a = new Divida(email, nome, valor, cal, idDivida);
            dividas.add(a);
            
           
        
        }
        } catch(SQLException e)
       {  System.err.println(e.getMessage());   }
     finally
        { 
             if(rs!=null) {
            rs.close();
            }
            
            c.close();}
    return dividas;
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
    public List<Divida> get(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Divida> put(String k, List<Divida> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Divida> remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends List<Divida>> map) {
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
    public Collection<List<Divida>> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, List<Divida>>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
