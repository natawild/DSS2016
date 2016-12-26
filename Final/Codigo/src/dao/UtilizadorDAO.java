/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dss.classes.Admin;
import dss.classes.Morador;
import dss.classes.Normal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
public class UtilizadorDAO implements Map<String,Morador>{
    
    
    
     public static int putUtilizador(Morador u) throws SQLException {
         
         Connection c = Connect.connect();
         PreparedStatement preparedStmt = null;
         int resultado =0;
         
         try{
         
             String verEmail = "select count(*) from morador where email = '"+u.getEmail()+"'";
             String verTelemovel = "select count(*) from morador where nrTelemovel = '"+u.getNrTelemovel()+"'";
             
             ResultSet rs = c.createStatement()
                .executeQuery(verEmail);
             
             rs.next();
             if(rs.getInt(1) ==0) {
                ResultSet rs1 = c.createStatement()
                .executeQuery(verTelemovel);  
                 
                rs1.next();
                
                
                if(rs1.getInt(1) ==0) {
                    String inserir = "insert into morador (nome,dataNascimento,password,email,"
                            + "valorConta,nrTelemovel,admin) values (?,?,?,?,?,?,?) ";
                    
               preparedStmt = c.prepareStatement(inserir,Statement.RETURN_GENERATED_KEYS);
               
               String nome =u.getNome();
               String email=u.getEmail();
               String pass = u.getPassword();
               float valor = u.getContaCorrente();
               String tele = u.getNrTelemovel();
               GregorianCalendar date = u.getDataNascimento();
               
               java.sql.Date startDate = new java.sql.Date(date.getTime().getTime());
               
              preparedStmt.setString (1, nome);
              preparedStmt.setDate (2, startDate);
              preparedStmt.setString(3,pass );
              preparedStmt.setString(4,email );
              preparedStmt.setFloat(5,valor );
              preparedStmt.setString(6,tele );
              preparedStmt.setNull(7, Types.NULL);
              
              preparedStmt.execute();
      
                }
                
                else {
                
                    resultado = -1;
                    
                
                }
             
             }
             
             else {
             
                 resultado = -2;
             
             }
             
             
             
             
             
         }
         catch(SQLException e) {
          //System.err.println("Got an exception!");
        System.err.println(e.getMessage());
             
         
         } 
         
         
        finally
        { c.close();
        }
         
      return resultado ;
    
    }
     
     
    
     public static int putAdmin (String email) throws SQLException {
     
         Connection c = Connect.connect();
         PreparedStatement preparedStmt;
         int resultado=0;
         
         try{
             String que = "select count(*) from morador where admin is not null;";
              ResultSet rs = c.createStatement()
                .executeQuery(que);
              rs.next();
             int idAdmin=rs.getInt(1);
             
             if(idAdmin ==0) { 
             
             
             
             
             
             String query = "select idUtilizador from morador where email = '"+email+"'";
             
               rs = c.createStatement()
                .executeQuery(query);
              rs.next();
              
              idAdmin=rs.getInt(1);
              
              String update = "update morador set admin = ' "+idAdmin+" '" 
                      +" where idUtilizador= '"+idAdmin+"'" ;
              
             
             preparedStmt=c.prepareStatement(update);
             preparedStmt.execute();
             
            
             }
             
             else {
             
                 resultado=-1;
                 
             
             }
            
             
             
               
               
                 
         
         }
         catch(SQLException e) {
         
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
             
         
         }
         finally
        { c.close();
        }
         
     return resultado;
     }
     public static int nrAdmin () throws SQLException {
     
         Connection c = Connect.connect();
         
         int resultado=0;
         
         try{
             String que = "select count(*) from morador where admin is not null;";
              ResultSet rs = c.createStatement()
                .executeQuery(que);
              rs.next();
             resultado=rs.getInt(1);
             
             
             }
         catch(SQLException e) {
         
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
             
         
         }
         finally
        { c.close();
        }
         
     return resultado;
         }
     
     
     
     
     public static int verAdmin() throws SQLException {
     
          Connection c = Connect.connect();
         
         int resultado=0;
         
         try{
             String que = "select count(*) from morador where admin is not null;";
              ResultSet rs = c.createStatement()
                .executeQuery(que);
              rs.next();
             resultado=rs.getInt(1);
         
         
         }
         catch(SQLException e) {
         
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
             
         
         }
         finally
        { c.close();
        }
      return resultado;
     }
     
  
     public static int inserCasa(String emailAdmin,String a) throws SQLException {
     
         Connection c = Connect.connect();
         PreparedStatement preparedStmt;
         
         try{
             String query = "select idUtilizador from morador where email = '"+emailAdmin+"'";
             
              ResultSet rs = c.createStatement()
                .executeQuery(query);
              rs.next();
              
              int idAdmin=rs.getInt(1);
              String update;
           
            
            
                
               
                     update = "update morador set admin = ' "+idAdmin+" '" 
                      +" where email= '"+a+"'" ;
              
             
                    preparedStmt=c.prepareStatement(update);
                    preparedStmt.execute();
                    
                
                
                
            
            
         
         }
         catch(SQLException e) {
         
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
           
           
         }
         
        finally
        { c.close();
        }
         
     return 0;
     }
     
     
     public static int removeUserCasa(String a) throws SQLException {
     
        Connection c = Connect.connect();
        PreparedStatement preparedStmt; 
        int nr;
        int resultado =0;
        try {
        
       
        
            String dividas = "select count(*) from divida AS D INNER JOIN morador AS M "
                    + " on D.idUtilizador = M.idUtilizador where M.email ='"+a+"'";
            
             ResultSet rs = c.createStatement()
                .executeQuery(dividas);
              rs.next();
            
              nr=rs.getInt(1);
              
              if(nr ==0) {
              
                  dividas = "select count(*) from emprestimo AS D INNER JOIN morador AS M "
                    + " on D.idUtilizador = M.idUtilizador where M.email ='"+a+"'";
                  
                  rs = c.createStatement()
                        .executeQuery(dividas);
                        
                  rs.next();
                  nr=rs.getInt(1);
                  
                  if(nr==0) {
                    
                      dividas = "select count(*) from pagamento AS P INNER JOIN morador AS M "
                    + " on P.idUtilizador = M.idUtilizador inner join conta as C "
                              + " on C.idConta = P.idConta " 
                              + " where M.email ='"+a+"'" + " and pago=false";
                  
                  rs = c.createStatement()
                        .executeQuery(dividas);
                        
                  rs.next();
                  nr=rs.getInt(1);
                  
                  if(nr==0) {
                      
                      dividas = "update morador set admin =null where email = '" +a+"'";
                      
                    preparedStmt=c.prepareStatement(dividas);
                    preparedStmt.execute();
                  
                  }
                      
                  else resultado = -3;
                      
                  }
                  else resultado = -2;
                  
              }
              
              else resultado = -1;
        }
        
         catch(SQLException e) {
         
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
            
             
         
         }
        finally
        { c.close();
        }
     
     return resultado ;
     
 }
     
public static int updateTelemovel(String email, String telemovel) throws SQLException {

    Connection c = Connect.connect();
        PreparedStatement preparedStmt; 
         int resultado =0;
        
        try{
            String verEmail = "select count(*) from morador where nrTelemovel='"+telemovel+"'";
             ResultSet rs = c.createStatement()
                .executeQuery(verEmail);
             rs.next();
             int nrEmail=rs.getInt(1);
            
            if(nrEmail==0) {
            String update = "update morador set nrTelemovel = '"+telemovel+"'" 
                             +" where email = '" + email+ "'";
            
            preparedStmt=c.prepareStatement(update);
                    preparedStmt.execute();
            }
            else resultado =-1;
        } 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
    return resultado;
}

public static int updateNome(String nome, String email) throws SQLException {

    Connection c = Connect.connect();
        PreparedStatement preparedStmt; 
        
        
        try{
            String update = "update morador set nome = '"+nome+"'" 
                             +" where email = '" + email+ "'";
            
            preparedStmt=c.prepareStatement(update);
                    preparedStmt.execute();
            
        } 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
    return 0;
}


public static int updateDataNascimento(String email,GregorianCalendar dataNascimento) throws SQLException {

    Connection c = Connect.connect();
        PreparedStatement preparedStmt; 
        
        
        try{
            
            
               
               java.sql.Date startDate = new java.sql.Date(dataNascimento.getTime().getTime());
            
            String update = "update morador set dataNascimento = '"+startDate+"'" 
                             +" where email = '" + email+ "'";
            
            preparedStmt=c.prepareStatement(update);
                    preparedStmt.execute();
            
        } 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
    return 0;
}

public static int updatePass(String pass, String email) throws SQLException {

    Connection c = Connect.connect();
        PreparedStatement preparedStmt; 
        
        
        try{
            String update = "update morador set password= '"+pass+"'" 
                             +" where email = '" + email+ "'";
            
            preparedStmt=c.prepareStatement(update);
                    preparedStmt.execute();
            
        } 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
        
    return 0;
}


public static int updateEmail(String emailNovo, String email) throws SQLException {

    Connection c = Connect.connect();
        PreparedStatement preparedStmt; 
        int resultado =0;
        
        try{
            String verEmail = "select count(*) from morador where email='"+emailNovo+"'";
             ResultSet rs = c.createStatement()
                .executeQuery(verEmail);
             rs.next();
             int nrEmail=rs.getInt(1);
            
            if(nrEmail==0) {
             
            String update = "update morador set email= '"+emailNovo+"'" 
                             +" where email = '" + email+ "'";
            
            preparedStmt=c.prepareStatement(update);
                    preparedStmt.execute();
            }
            
            else resultado =-1;
        } 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
        
    return resultado;
}


public static int updateConta(float dinheiro, String email) throws SQLException {

    Connection c = Connect.connect();
        PreparedStatement preparedStmt; 
        
        
        try{
            String update = "update morador set valorConta= valorConta + '"+dinheiro+"'" 
                             +" where email = '" + email+ "'";
            
            preparedStmt=c.prepareStatement(update);
                    preparedStmt.execute();
            
        } 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
    return 0;
}

public static List<String> emailsUser() throws SQLException {
 
   List<String> emails = new ArrayList<>();
   Connection c = Connect.connect();
   try{
   String que = "select email from morador where admin is null" ;
              ResultSet rs = c.createStatement()
                .executeQuery(que);
   
    while(rs.next()) {
    
        String email = rs.getString(1);
        
        emails.add(email);
        
    }          
   } 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
    finally
        { c.close();
        }
   return emails;
}  


public static List<String> emailsUserCasa() throws SQLException {
 
   List<String> emails = new ArrayList<>();
   Connection c = Connect.connect();
   try{
   String que = "select email from morador where admin is not null";
              ResultSet rs = c.createStatement()
                .executeQuery(que);
   
    while(rs.next()) {
    
        String email = rs.getString("email");
        
        emails.add(email);
        
    }          
   } 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
    finally
        { c.close();
        }
   return emails;
} 


public static List<String> emailsMensagem(String emailAdmin) throws SQLException {
 
   List<String> emails = new ArrayList<>();
   Connection c = Connect.connect();
   try{
   String que = "select email from morador where admin is not null and email!='"+emailAdmin+"'";
              ResultSet rs = c.createStatement()
                .executeQuery(que);
   
    while(rs.next()) {
    
        String email = rs.getString("email");
        
        emails.add(email);
        
    }          
   } 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
    finally
        { c.close();
        }
   return emails;
} 






public static String getNome(String email) throws SQLException {

    String nome="";

    Connection c = Connect.connect();
   try {
    String que = "select nome from morador where email ='" +email+"'";
              ResultSet rs = c.createStatement()
                .executeQuery(que);     
            
     rs.next();
     nome=rs.getString(1);
   
} 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
return nome;

}

public static int getDinheiro(String email) throws SQLException {

    int dinheiro=0;

    Connection c = Connect.connect();
   try {
    String que = "select valorConta from morador where email ='" +email+"'";
              ResultSet rs = c.createStatement()
                .executeQuery(que);     
            
     rs.next();
     dinheiro=rs.getInt(1);
   
} 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
   
return dinheiro;
}

public static Morador getUtilizador(String email) throws SQLException {
  
  Connection c = Connect.connect();
  Normal n = new Normal();
  try {
      String nome;
      String pass;
      String nrTelemovel;
      float valorConta;
      GregorianCalendar data = new GregorianCalendar();
      
    String que = "select nome,dataNascimento,password,valorConta,nrTelemovel from morador where email ='" +email+"'";
              ResultSet rs = c.createStatement()
                .executeQuery(que);     
            
     rs.next();
     
     nome = rs.getString("nome");
     pass = rs.getString("password");
     nrTelemovel = rs.getString("nrTelemovel");
     valorConta = rs.getFloat("valorConta");
     java.sql.Date dbSqlDate = rs.getDate("dataNascimento");
     data.setTime(dbSqlDate);
     
     n=new Normal(nome, email, pass, valorConta, nrTelemovel, data);
     
     
     
     
} 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
   

    return n;
  
}

public static Morador getAdmin(String email) throws SQLException {
  
  Connection c = Connect.connect();
  Admin n = new Admin();
  try {
      String nome;
      String pass;
      String nrTelemovel;
      float valorConta;
      GregorianCalendar data = new GregorianCalendar();
      
    String que = "select nome,dataNascimento,password,valorConta,nrTelemovel from morador where email ='" +email+"'";
              ResultSet rs = c.createStatement()
                .executeQuery(que);     
            
     rs.next();
     
     nome = rs.getString("nome");
     pass = rs.getString("password");
     nrTelemovel = rs.getString("nrTelemovel");
     valorConta = rs.getFloat("valorConta");
     java.sql.Date dbSqlDate = rs.getDate("dataNascimento");
     data.setTime(dbSqlDate);
     
     n=new Admin(nome, email, pass, valorConta, nrTelemovel, data);
     
     
     
     
} 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
   

    return n;
  
}




public static String isAdmin () throws SQLException {

    Connection c = Connect.connect();
    String email = "";
    try { 
        
        String query = "select admin from morador where admin is not null";
        ResultSet rs = c.createStatement()
                .executeQuery(query);     
            
     rs.next();
     int idAdmin = rs.getInt(1);
     
     query = "select email from morador where idUtilizador='"+idAdmin+"'";
     rs = c.createStatement()
                .executeQuery(query);  
    
    rs.next();
    email=rs.getString(1);


} 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
   
return email;
} 

public static int estaEmCasa(String email) throws SQLException {

      
  Connection c = Connect.connect();
  int resultado=0;
   try {
    String que = "select count(*) from morador where email ='" +email+"' and admin is null ";
              ResultSet rs = c.createStatement()
                .executeQuery(que);     
            
     rs.next();
     resultado=rs.getInt(1);
   
} 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
   
return resultado;  

}

public static float getSaldoGlobal() throws SQLException {

    Connection c = Connect.connect();
  float resultado=0;
   try {
    String que = "select sum(valorConta) from morador where  admin is not null ";
              ResultSet rs = c.createStatement()
                .executeQuery(que);     
            
     rs.next();
     resultado=rs.getFloat(1);
   
} 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
   
return resultado;  
    
    

}




public static int login(String email,String pw) throws SQLException {

    
  Connection c = Connect.connect();
  int resultado=0;
   try {
    String que = "select count(*) from morador where email ='" +email+"' and password ='"+pw+"'";
              ResultSet rs = c.createStatement()
                .executeQuery(que);     
            
     rs.next();
     resultado=rs.getInt(1);
   
} 
        catch(SQLException e) {
        
             //System.err.println("Got an exception!");
        
             //System.err.println(e.getMessage());
        
        }
finally
        { c.close();
        }
   
return resultado;  

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
    public Morador get(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Morador put(String k, Morador v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Morador remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends Morador> map) {
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
    public Collection<Morador> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Morador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   




     
     
  
}
