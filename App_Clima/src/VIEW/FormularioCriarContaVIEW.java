/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mello
 */
public class FormularioCriarContaVIEW extends javax.swing.JFrame {

    /**
     * Creates new form FormularioCriarContaVIEW
     */
    public FormularioCriarContaVIEW() {
        initComponents();
        this.setTitle("Weathervane");
        setIconImage();
        centreWindow(this);
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
        txtCriarNomeUsuario = new javax.swing.JTextField();
        txtCriarSenhaUsuario = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        btnCriarConta = new javax.swing.JButton();
        checkSenhaCriar = new javax.swing.JCheckBox();
        comeback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome De Usuario");

        txtCriarNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriarNomeUsuarioActionPerformed(evt);
            }
        });
        txtCriarNomeUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCriarNomeUsuarioKeyPressed(evt);
            }
        });

        txtCriarSenhaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCriarSenhaUsuarioKeyPressed(evt);
            }
        });

        jLabel2.setText("Senha");

        btnCriarConta.setText("Cadastrar");
        btnCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarContaActionPerformed(evt);
            }
        });

        checkSenhaCriar.setText("Mostrar Senha");
        checkSenhaCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSenhaCriarActionPerformed(evt);
            }
        });

        comeback.setText("Voltar");
        comeback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comebackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnCriarConta)
                        .addGap(63, 63, 63)
                        .addComponent(comeback))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(checkSenhaCriar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(txtCriarNomeUsuario)
                                .addComponent(txtCriarSenhaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtCriarNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtCriarSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkSenhaCriar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarConta)
                    .addComponent(comeback))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCriarNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriarNomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriarNomeUsuarioActionPerformed

    private void btnCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarContaActionPerformed
        Checar();
    }//GEN-LAST:event_btnCriarContaActionPerformed

    private void checkSenhaCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSenhaCriarActionPerformed
        if (checkSenhaCriar.isSelected()) {
            txtCriarSenhaUsuario.setEchoChar((char) 0);
        } else {
            txtCriarSenhaUsuario.setEchoChar('*');
        }
    }//GEN-LAST:event_checkSenhaCriarActionPerformed

    private void txtCriarNomeUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriarNomeUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCriarSenhaUsuario.requestFocus();
        }
    }//GEN-LAST:event_txtCriarNomeUsuarioKeyPressed

    private void txtCriarSenhaUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriarSenhaUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Checar();
        }
    }//GEN-LAST:event_txtCriarSenhaUsuarioKeyPressed

    private void comebackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comebackActionPerformed
        FormularioLoginVIEW Flogin = new FormularioLoginVIEW();
        Flogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_comebackActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioCriarContaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioCriarContaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioCriarContaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioCriarContaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioCriarContaVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarConta;
    private javax.swing.JCheckBox checkSenhaCriar;
    private javax.swing.JButton comeback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtCriarNomeUsuario;
    private javax.swing.JPasswordField txtCriarSenhaUsuario;
    // End of variables declaration//GEN-END:variables

    private void Criar() {
        String nome, senha;

        nome = txtCriarNomeUsuario.getText();
        senha = txtCriarSenhaUsuario.getText();

        UsuarioDTO objusuariodto = new UsuarioDTO();
        objusuariodto.setCriar_nome_usuario(nome);
        objusuariodto.setCriar_senha_usuario(senha);

        UsuarioDAO objusuariodao = new UsuarioDAO();
        objusuariodao.cadastrarUsuario(objusuariodto);

        //chamar tela principal
        AppPrincipalVIEW objappprincipalview = new AppPrincipalVIEW();
        objappprincipalview.setVisible(true);

        dispose();

    }

    private void Checar() {
        try {
            String nome = txtCriarNomeUsuario.getText();

            UsuarioDTO objusuariodto = new UsuarioDTO();
            objusuariodto.setCriar_nome_usuario(nome);

            UsuarioDAO objusuariodao = new UsuarioDAO();
            ResultSet rsusuariodao = objusuariodao.checarUsuarioExistente(objusuariodto);

            if (rsusuariodao.next()) {
                JOptionPane.showMessageDialog(null, "Esse usuario já existe");
            } else {
                Criar();
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "FormularioCriarContaVIEW: " + error);
        }
    }
    
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Assets/icons8-climate-64.png")));
    }
    
    private void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
