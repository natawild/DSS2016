/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.gui;


import dss.classes.Emprestimo;
import dss.classes.Facade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gil
 */
public class VerEmprestimos extends javax.swing.JDialog {
    private String emailUser;
    private int i;
    private Facade f;
    /**
     * Creates new form VerMensagemAdmin
     */
    public VerEmprestimos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.i=0;
    }
    
    public VerEmprestimos(String email) throws SQLException {
      this.emailUser=email;
      i=0;
      initComponents();
      f=new Facade();
      String nome = f.getNome(email);
      
      List<Emprestimo> mensagemUser = f.getEmprestimos(email, nome);
      
      if(mensagemUser.isEmpty()) {
      
           JOptionPane.showMessageDialog(null, "Não têm emprestimos feitos");
          this.mensagem.setText("");
          
      }
      else {
      
           Emprestimo m = mensagemUser.get(i);
                   
                  
                  this.mensagem.setText(m.toString());
          
      
      }
      this.mensagem.setEditable(false);
      
      
      
      
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensagem = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        sair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 24)); // NOI18N
        jLabel1.setText("Emprestimos");

        mensagem.setColumns(20);
        mensagem.setRows(5);
        jScrollPane1.setViewportView(mensagem);

        jButton1.setText("seguinte");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setText(">");

        jButton2.setText("anterior");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel3.setText("<");

        sair.setText("Voltar ao menu Inicial");
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/emprestimomelhor.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(440, 440, 440)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(sair))
            .addGroup(layout.createSequentialGroup()
                .addGap(486, 486, 486)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jButton2))
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(jButton2))
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        try {
            // TODO add your handling code here:
            new InicioComCasa(emailUser).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(VerEmprestimos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }//GEN-LAST:event_sairMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            // TODO add your handling code here:
            List<Emprestimo> mensagemUser=new ArrayList<>();
             String nome = f.getNome(this.emailUser);
           mensagemUser = f.getEmprestimos(this.emailUser, nome);
           i++;
            if(i>=mensagemUser.size()) {
            
                JOptionPane.showMessageDialog(null, "Nao fez mais emprestimos");
            
            }
            else {
                if(i<0) {i=0;}
                if(mensagemUser .isEmpty()) {
                
                     JOptionPane.showMessageDialog(null, "Nao tem mais emprestimos");
                    
                }
                else {
                   Emprestimo m = mensagemUser.get(i);
                   
                  this.mensagem.setText("");
                  this.mensagem.setText(m.toString());
                } 
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VerEmprestimos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            // TODO add your handling code here:
            List<Emprestimo> mensagemUser=new ArrayList<>();
            String nome = f.getNome(this.emailUser);
      
           mensagemUser = f.getEmprestimos(this.emailUser, nome);
            i--;
            
            if(i<0) {
                
                JOptionPane.showMessageDialog(null, "Nao pode andar mais para trás");
                
                
            }
            else {
                if(i>=mensagemUser.size()) {i=0;}
                if(mensagemUser.isEmpty()) {
                
                     JOptionPane.showMessageDialog(null, "Nao tem mais emprestimos");
                    
                }
                else {
                   
                Emprestimo m = mensagemUser.get(i);
                   
                  this.mensagem.setText("");
                  this.mensagem.setText(m.toString());
                }  
                
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerEmprestimos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mensagem;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables
}
