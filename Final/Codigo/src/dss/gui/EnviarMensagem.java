/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.gui;

import dss.classes.Facade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author gil
 */
public class EnviarMensagem extends javax.swing.JDialog {
    private String email;
    private Facade f;
    private DefaultListModel dlm = new DefaultListModel();
    private DefaultListModel dlm2 = new DefaultListModel();
    private List<String> a;
    /**
     * Creates new form EnviarMensagem
     */
    public EnviarMensagem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    public EnviarMensagem(String emailAdmin) throws SQLException {
    
        f=new Facade();
        this.email=emailAdmin;
        initComponents();
        this.a=new ArrayList<>();
        
        List<String> userCasa = f.getEmailMensagem(this.email);
        
         
           for (String e : userCasa) {
               dlm.addElement(e);
               
           }
           this.utilizadoresCasa.setModel(dlm);
        
        
           this.label.setVisible(false);
           this.enviar.setVisible(false);
           this.remover.setVisible(false);
           this.utilizadoresEscolhidos.setVisible(false);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        utilizadoresCasa = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        utilizadoresEscolhidos = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        remover = new javax.swing.JButton();
        enviar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        utilizadoresCasa.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(utilizadoresCasa);

        utilizadoresEscolhidos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(utilizadoresEscolhidos);

        jButton1.setText("escolher");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        remover.setText("remover");
        remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removerMouseClicked(evt);
            }
        });

        enviar.setText("enviar");
        enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enviarMouseClicked(evt);
            }
        });

        jButton4.setText("voltar ao menu");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Utilizadores casa");

        label.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        label.setText("Utilizadores Escolhidos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enviar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        try {
            // TODO add your handling code here:
            new Administrar(email).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(EnviarMensagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
       DefaultListModel model = (DefaultListModel) utilizadoresCasa.getModel();
        int selectedIndex = utilizadoresCasa.getSelectedIndex();
        if (selectedIndex != -1) {
            dlm2.addElement(this.utilizadoresCasa.getSelectedValue());
            this.label.setVisible(true);
           this.enviar.setVisible(true);
           this.remover.setVisible(true);
           this.utilizadoresEscolhidos.setVisible(true);
            a.add(this.utilizadoresCasa.getSelectedValue());
            model.remove(selectedIndex);
            
        }
       
       
       this.utilizadoresEscolhidos.setModel(dlm2);
        
        
        
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void removerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseClicked
        // TODO add your handling code here:
        
        
        
        
        DefaultListModel model = (DefaultListModel) utilizadoresEscolhidos.getModel();
        int selectedIndex = utilizadoresEscolhidos.getSelectedIndex();
        if (selectedIndex != -1) {
            dlm.addElement(this.utilizadoresEscolhidos.getSelectedValue());
            a.remove(this.utilizadoresEscolhidos.getSelectedValue());
            model.remove(selectedIndex);
        }
        
        this.utilizadoresCasa.setModel(dlm);
        
        
    }//GEN-LAST:event_removerMouseClicked

    private void enviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarMouseClicked
        // TODO add your handling code here:
        
        if(a.isEmpty()) {
        
            JOptionPane.showMessageDialog(null, "Não selecionou utilizadores para enviar mensagem ");
        
        }
        else {
            
            new MensagemEnviar(email, a).setVisible(true);
            this.dispose();
        
        }
        
        
    }//GEN-LAST:event_enviarMouseClicked

    /**
     * @param args the command line arguments
     */
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JButton remover;
    private javax.swing.JList<String> utilizadoresCasa;
    private javax.swing.JList<String> utilizadoresEscolhidos;
    // End of variables declaration//GEN-END:variables
}
