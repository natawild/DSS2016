/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dss.classes.Mensagem;
import java.sql.*;
import java.util.*;


/**
 *
 * @author gil
 */
public class MensagemDAO implements List<Mensagem> {
    
    public static int put(Mensagem m,List<String> emails) throws SQLException {
    
    Connection c = Connect.connect();
    PreparedStatement preparedStmt1 = null;
    PreparedStatement preparedStmt=null;
    int resultado =0;
    try{
         c.setAutoCommit(false);
     String query = " insert into mensagem (assunto, mensagem, dataMensagem)"
        + " values (?, ?, ?)";
     String query1 = " insert into mensagemAdmin (idMensagem, idUtilizador)"
        + " values (?, ?)";
     
     List<Integer> list = new ArrayList<>();
     
         
     if(  emails.isEmpty()) {
    
        resultado = -1;
        
    
    }  
         
         else {
      ResultSet rs = c.createStatement()
                .executeQuery("select idUtilizador, email from morador");
      
      
      while(rs.next()) {
      
          int id = rs.getInt("idUtilizador");
          String email = rs.getString("email");
         
          if(emails.contains(email)) {
              
              list.add(id);
          }
          
      }
      
      
      
      
    
      preparedStmt = c.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
     String assunto = m.getAssunto();
     String texto = m.getMensagem();
     GregorianCalendar data = m.getData();
     
     java.sql.Date startDate = new java.sql.Date(data.getTime().getTime());
     
     
      
      preparedStmt.setString (1, assunto);
      preparedStmt.setString (2, texto);
      preparedStmt.setDate(3,startDate );
      
      preparedStmt.execute();
      
     
     
      ResultSet tableKeys = preparedStmt.getGeneratedKeys();
    tableKeys.next();
    int autoGeneratedID = tableKeys.getInt(1);

     preparedStmt1 = c.prepareStatement(query1);
    

     
    
    for(Integer a :list) {
    
        preparedStmt1.setInt(1,autoGeneratedID);
        preparedStmt1.setInt(2,a);
        
        preparedStmt1.execute();
        
    }
    
     
   
    
    c.commit();
     
         }
    
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
        
        
        c.setAutoCommit(true);
        
        
        c.close();
        
    }    
    return resultado;
    
    }
    
    public static List<Mensagem> lerMensagem(String email) throws SQLException {
    
         Connection c = Connect.connect();
        
        
        List<Mensagem> mensagem = new ArrayList<>();
        
        
        
        try {

            ResultSet rs = c.createStatement().executeQuery ("select idUtilizador from morador where morador.email = '" + email +"'");
            rs.next();
            int idUlti = rs.getInt(1);
            
          ResultSet rs1= c.createStatement()
                .executeQuery( "select assunto, mensagem , dataMensagem from mensagem as A "
                        + "INNER JOIN mensagemadmin as MA ON MA.idMensagem=A.idMensagem "
                        + "where MA.idUtilizador ='"+idUlti+"'"
                        + " order by dataMensagem DESC");
        
            
      
          
          while(rs1.next()) {
          
              String assunto = rs1.getString("assunto");
              String men = rs1.getString("mensagem");
             java.sql.Date dbSqlDate = rs1.getDate("dataMensagem");
               
              GregorianCalendar cal = new GregorianCalendar();
              
              cal.setTime(dbSqlDate);
              
              Mensagem m = new Mensagem(assunto, men, cal);
              
              mensagem.add(m);
          
             
          }
         
            
        } catch (SQLException e) {
        
        //System.err.println("Got an exception!");
        System.err.println(e.getMessage());
        
        
        }finally
        { c.close();}
        
       return mensagem; 
    
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
    public Iterator<Mensagem> iterator() {
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
    public boolean add(Mensagem e) {
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
    public boolean addAll(Collection<? extends Mensagem> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection<? extends Mensagem> clctn) {
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
    public Mensagem get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensagem set(int i, Mensagem e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int i, Mensagem e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensagem remove(int i) {
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
    public ListIterator<Mensagem> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<Mensagem> listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mensagem> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
     
    
    
    
    
    
  
    
    
    

    
    
    
    
    
    
}