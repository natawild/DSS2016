/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.gui;


import dss.classes.Divida;
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
public class ConsultarDividas extends javax.swing.JDialog {
    private String emailUser;
    private int i;
    private Facade f;
    /**
     * Creates new form VerMensagemAdmin
     */
    public ConsultarDividas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.i=0;
    }
    
    public ConsultarDividas(String email) throws SQLException {
      this.emailUser=email;
      i=0;
      initComponents();
      f=new Facade();
      String nome = f.getNome(email);
      
      List<Divida> mensagemUser = f.getDividas(email, nome);
      
      if(mensagemUser.isEmpty()) {
      
           JOptionPane.showMessageDialog(null, "Não têm dividas");
          this.mensagem.setText("");
          
      }
      else {
      
           Divida m = mensagemUser.get(i);
                   
                  
                  this.mensagem.setText(m.toString());
          
      
      }
      this.mensagem.setEditable(false);
      
      this.idDividaLabel.setVisible(false);
      this.identificadorDivida.setVisible(false);
      this.ok.setVisible(false);
      this.valorApagarLabel.setVisible(false);
      this.valorDivida.setVisible(false);
      
      
      
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
        pagar = new javax.swing.JButton();
        idDividaLabel = new javax.swing.JLabel();
        identificadorDivida = new javax.swing.JTextField();
        valorApagarLabel = new javax.swing.JLabel();
        valorDivida = new javax.swing.JTextField();
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText(" Dividas");

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

        pagar.setText("Pagar");
        pagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagarMouseClicked(evt);
            }
        });

        idDividaLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        idDividaLabel.setText("Identificador da Divida");

        valorApagarLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        valorApagarLabel.setText("Valor a pagar");

        ok.setText("Pagar");
        ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1)
                                        .addGap(122, 122, 122)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idDividaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(identificadorDivida)
                                    .addComponent(valorApagarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(valorDivida)
                                    .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(203, 203, 203)
                                        .addComponent(pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2)
                                        .addGap(123, 123, 123)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idDividaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(identificadorDivida, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(valorApagarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(valorDivida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(pagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
            List<Divida> mensagemUser=new ArrayList<>();
             String nome = f.getNome(this.emailUser);
           mensagemUser = f.getDividas(this.emailUser, nome);
           i++;
            if(i>=mensagemUser.size()) {
            
                JOptionPane.showMessageDialog(null, "Nao tem mais dividas");
            
            }
            else {
                if(mensagemUser.isEmpty()) {
                
                     JOptionPane.showMessageDialog(null, "Nao tem mais dividas");
                    
                }
                else {
                
                
                   Divida m = mensagemUser.get(i);
                   
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
            List<Divida> mensagemUser=new ArrayList<>();
            String nome = f.getNome(this.emailUser);
      
           mensagemUser = f.getDividas(this.emailUser, nome);
            i--;
            
            if(i<0) {
                
                JOptionPane.showMessageDialog(null, "Nao pode andar mais para trás");
                
                
            }
            else {
                if(mensagemUser.isEmpty()) {
                
                     JOptionPane.showMessageDialog(null, "Nao tem mais dividas");
                    
                }
                else {
                   
                Divida m = mensagemUser.get(i);
                   
                  this.mensagem.setText("");
                  this.mensagem.setText(m.toString());
                    
                }
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerEmprestimos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void pagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagarMouseClicked
        // TODO add your handling code here:
        
        this.idDividaLabel.setVisible(true);
      this.identificadorDivida.setVisible(true);
      this.ok.setVisible(true);
      this.valorApagarLabel.setVisible(true);
      this.valorDivida.setVisible(true);
      this.pagar.setVisible(false);
        
        
        
    }//GEN-LAST:event_pagarMouseClicked

    private void okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseClicked
        // TODO add your handling code here:
        try {
        int id =Integer.parseInt(this.identificadorDivida.getText());
        
        if(f.getIdDividaUser(id,emailUser)==0) {
           JOptionPane.showMessageDialog(null, "Id não existe");
           
            
        }
        else {
             
             float valorInt = Float.parseFloat(this.valorDivida.getText());
             float valor =f.getValorDivida(id);
             float valorConta = f.getDinheiro(emailUser);
             if(valor ==valorInt && valorConta>=valorInt) {
               f.pagarDivida(id);
               f.pagarEmprestimo(valor);
               f.retiraSaldo(valor, emailUser);
               i=0;
               this.mensagem.setText("");
               JOptionPane.showMessageDialog(null, "Divida paga");
                 
                 
             }
             else {
             
                  JOptionPane.showMessageDialog(null, "Valor introduzido incorrecto");
                  
                 
             }
            
        
        }
        
        
        
        }
        catch(Exception e) {
        
            JOptionPane.showMessageDialog(null, "Valor invalido");
            
        
        }
        
        this.valorDivida.setText("");
        this.identificadorDivida.setText("");
        
     
        
        
        
        
    }//GEN-LAST:event_okMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idDividaLabel;
    private javax.swing.JTextField identificadorDivida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mensagem;
    private javax.swing.JButton ok;
    private javax.swing.JButton pagar;
    private javax.swing.JButton sair;
    private javax.swing.JLabel valorApagarLabel;
    private javax.swing.JTextField valorDivida;
    // End of variables declaration//GEN-END:variables
}
