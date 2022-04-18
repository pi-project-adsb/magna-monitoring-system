/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package swing.signup;

import database.connection.Connection;
import external.Network;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author gustavo.moraes@VALEMOBI.CORP
 */
public class LoginScreen extends javax.swing.JFrame {
    /**
     * Creates new form Home
     */
    public LoginScreen() {
        initComponents();
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
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        userEmail1 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lblPass = new javax.swing.JLabel();
        userPass = new javax.swing.JPasswordField();
        jSeparator4 = new javax.swing.JSeparator();
        btnSignUp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setForeground(new java.awt.Color(60, 63, 65));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/magna_banner.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEmail.setBackground(new java.awt.Color(240, 240, 240));
        lblEmail.setForeground(new java.awt.Color(57, 113, 117));
        lblEmail.setText("Email");
        jPanel2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, 20));

        userEmail1.setBackground(new java.awt.Color(32, 33, 35));
        userEmail1.setForeground(new java.awt.Color(255, 255, 255));
        userEmail1.setBorder(null);
        userEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmail1ActionPerformed(evt);
            }
        });
        jPanel2.add(userEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 340, 20));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 340, -1));

        lblPass.setBackground(new java.awt.Color(240, 240, 240));
        lblPass.setForeground(new java.awt.Color(57, 113, 117));
        lblPass.setText("Senha");
        jPanel2.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, 20));

        userPass.setBackground(new java.awt.Color(32, 33, 35));
        userPass.setForeground(new java.awt.Color(255, 255, 255));
        userPass.setBorder(null);
        userPass.setCaretColor(new java.awt.Color(255, 255, 255));
        userPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPassActionPerformed(evt);
            }
        });
        jPanel2.add(userPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 340, 20));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 340, -1));

        btnSignUp.setBackground(new java.awt.Color(0, 200, 255));
        btnSignUp.setFont(new java.awt.Font("Noto Mono", 1, 15)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(10, 10, 10));
        btnSignUp.setText("ENTRAR");
        btnSignUp.setBorder(null);
        btnSignUp.setBorderPainted(false);
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSignUpActionPerformed(evt);
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                } catch (SocketException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jPanel2.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 340, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmail1ActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) throws UnknownHostException, SocketException {//GEN-FIRST:event_btnSignUpActionPerformed
        ComputerRegister computerRegister = new ComputerRegister();
        String passwordGetText = new String(userPass.getPassword());
        Network net = new Network();
        
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        
        if (userEmail1.getText().equals("admin@gmail.com") && passwordGetText.equals("123")) {
            InetAddress addr = InetAddress.getLocalHost();
            
            this.dispose();
            computerRegister.setVisible(true);
            
            con.update("INSERT INTO totem VALUES (?, ?, ?, ?)",
                null, "Primeiro andar", "Rodando", net.getMAC(addr), net.getLocalHost());
            
        }

        

    }//GEN-LAST:event_btnSignUpActionPerformed

    private void userPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userPassActionPerformed

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPass;
    private javax.swing.JTextField userEmail1;
    private javax.swing.JPasswordField userPass;
    // End of variables declaration//GEN-END:variables
}
