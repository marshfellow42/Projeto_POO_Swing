/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Elenita
 */
public class RecuperarSenha extends javax.swing.JFrame {

    /**
     * Creates new form RecuperarSenha
     */
    public RecuperarSenha() {
        initComponents();
        centreWindow(this);
        connectToDatabase();
        this.setTitle("Weathervane");
        setIconImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        verSenha = new javax.swing.JCheckBox();
        newPass = new javax.swing.JPasswordField();
        confirmPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nova Senha");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(34, 39, 90, 16);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Confirmar Senha");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(34, 122, 110, 16);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Recuperar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(34, 239, 90, 23);

        verSenha.setForeground(new java.awt.Color(255, 255, 255));
        verSenha.setText("Mostrar Senha");
        verSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(verSenha);
        verSenha.setBounds(34, 190, 120, 20);

        newPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassActionPerformed(evt);
            }
        });
        jPanel1.add(newPass);
        newPass.setBounds(34, 67, 200, 22);
        jPanel1.add(confirmPass);
        confirmPass.setBounds(34, 150, 200, 22);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/fundo-gradiente.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 400, 300);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String nomeUser = null;
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String novaSenha = newPass.getText();
        String confirmarSenha = confirmPass.getText();

        if (!novaSenha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(null, "As senhas não estão iguais");
        } else {
            mudarSenha(novaSenha, nomeUser);
            AppPrincipalVIEW appP = new AppPrincipalVIEW();
            appP.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void verSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verSenhaActionPerformed
        if (verSenha.isSelected()) {
            newPass.setEchoChar((char) 0);
            confirmPass.setEchoChar((char) 0);
        } else {
            newPass.setEchoChar('*');
            confirmPass.setEchoChar('*');
        }
    }//GEN-LAST:event_verSenhaActionPerformed

    private void newPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassActionPerformed

    private void mudarSenha(String senha, String usuario) {
        try {
            String sql = "UPDATE usuario SET senha_usuario = ? WHERE nome_usuario = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, senha);
            pstm.setString(2, usuario);
            pstm.execute();
            pstm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection conn;

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10669278?user=sql10669278&password=NSBMGmXJXQ";
            conn = DriverManager.getConnection(url);

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "AppPrincipalVIEW: " + error);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecuperarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecuperarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecuperarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecuperarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecuperarSenha().setVisible(true);
            }
        });
    }

    private void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Assets/perereca_engracada.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPass;
    private javax.swing.JCheckBox verSenha;
    // End of variables declaration//GEN-END:variables
}
