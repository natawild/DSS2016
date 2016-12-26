/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.gui;


import dss.classes.Facade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gil
 */
public class InicioComCasa extends javax.swing.JDialog {
    private String emailUser;
    private Facade f;
    /**
     * Creates new form InicioComCasa
     */
    public InicioComCasa(java.awt.Frame parent, boolean modal)  {
        super(parent, modal);
        initComponents();
        f=new Facade();
         
        
        
    }
    
    public InicioComCasa(String email) throws SQLException {
       f=new Facade();
        this.emailUser=email;
        initComponents();
        float saldo;
        
        saldo =f.getDinheiro(this.emailUser);
        
        this.saldoCasa.setText(saldo+"");
        this.saldoCasa.setEditable(false);
        
        if(f.getEmailAdmin().equals(this.emailUser)) {
        
            this.admin.setVisible(true);
            this.sair.setVisible(false);
            this.mensagemAdmin.setVisible(false);
            
        }
        
        else {this.admin.setVisible(false);
              this.sair.setVisible(true);
              this.mensagemAdmin.setVisible(true);
              }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mensagemAdmin = new javax.swing.JButton();
        pagarDivida = new javax.swing.JButton();
        emprestimos = new javax.swing.JButton();
        pagarConta = new javax.swing.JButton();
        verContasPagas = new javax.swing.JButton();
        carregarConta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        saldoCasa = new javax.swing.JTextField();
        sair = new javax.swing.JButton();
        admin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mensagemAdmin.setText("Ver mensagens do admin");
        mensagemAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mensagemAdminMouseClicked(evt);
            }
        });

        pagarDivida.setText("Consultar Dividas");
        pagarDivida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagarDividaMouseClicked(evt);
            }
        });

        emprestimos.setText("Consultar emprestimos");
        emprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emprestimosMouseClicked(evt);
            }
        });

        pagarConta.setText("Pagar Conta");
        pagarConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagarContaMouseClicked(evt);
            }
        });

        verContasPagas.setText("Ver Contas Pagas");
        verContasPagas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verContasPagasMouseClicked(evt);
            }
        });

        carregarConta.setText("actualizar o saldo");
        carregarConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carregarContaMouseClicked(evt);
            }
        });

        jLabel1.setText("Saldo dentro da casa");

        sair.setText("Logout");
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        admin.setText("voltar ao menu admin");
        admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(verContasPagas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(emprestimos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mensagemAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(123, 123, 123)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pagarDivida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pagarConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(carregarConta, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))))
                        .addContainerGap(153, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saldoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(admin)
                        .addGap(96, 96, 96)
                        .addComponent(sair)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sair)
                        .addComponent(admin))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mensagemAdmin)
                            .addComponent(pagarDivida))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emprestimos)
                            .addComponent(pagarConta))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(verContasPagas)
                            .addComponent(carregarConta))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saldoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_sairMouseClicked

    private void mensagemAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mensagemAdminMouseClicked
        try {
            // TODO add your handling code here:
            new VerMesagemAdmin(this.emailUser).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(InicioComCasa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mensagemAdminMouseClicked

    private void emprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emprestimosMouseClicked
        try {
            // TODO add your handling code here:
            new VerEmprestimos(emailUser).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(InicioComCasa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_emprestimosMouseClicked

    private void verContasPagasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verContasPagasMouseClicked
        try {
            // TODO add your handling code here:
            new VerContasPagas(emailUser).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(InicioComCasa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_verContasPagasMouseClicked

    private void carregarContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carregarContaMouseClicked
        // TODO add your handling code here:
        
        new ActualizarSaldo(this.emailUser).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_carregarContaMouseClicked

    private void pagarDividaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagarDividaMouseClicked
        try {
            // TODO add your handling code here:
            
            new ConsultarDividas(emailUser).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(InicioComCasa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }//GEN-LAST:event_pagarDividaMouseClicked

    private void pagarContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagarContaMouseClicked
        try {
            // TODO add your handling code here:
            new ConsultarConta(emailUser).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(InicioComCasa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_pagarContaMouseClicked

    private void adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminMouseClicked
        // TODO add your handling code here:
        new JanelaAdmin(this.emailUser).setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_adminMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin;
    private javax.swing.JButton carregarConta;
    private javax.swing.JButton emprestimos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton mensagemAdmin;
    private javax.swing.JButton pagarConta;
    private javax.swing.JButton pagarDivida;
    private javax.swing.JButton sair;
    private javax.swing.JTextField saldoCasa;
    private javax.swing.JButton verContasPagas;
    // End of variables declaration//GEN-END:variables
}