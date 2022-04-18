/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package swing.signup;

/**
 *
 * @author gustavo.moraes@VALEMOBI.CORP
 */
public class ComputerRegister extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public ComputerRegister() {
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
        userEmail1 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        userEmail2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        userEmail3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        userEmail4 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        userEmail5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

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

        userEmail1.setBackground(new java.awt.Color(32, 33, 35));
        userEmail1.setForeground(new java.awt.Color(255, 255, 255));
        userEmail1.setBorder(null);
        userEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmail1ActionPerformed(evt);
            }
        });
        jPanel2.add(userEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 340, 20));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 340, -1));

        jLabel3.setBackground(new java.awt.Color(240, 240, 240));
        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("faça o cadastro da mesma para utilizar o sistema.");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        btnSignUp.setBackground(new java.awt.Color(0, 200, 255));
        btnSignUp.setFont(new java.awt.Font("Noto Mono", 1, 15)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(10, 10, 10));
        btnSignUp.setText("CADASTRAR MÁQUINA");
        btnSignUp.setBorder(null);
        btnSignUp.setBorderPainted(false);
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        jPanel2.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 340, 40));

        jLabel5.setBackground(new java.awt.Color(240, 240, 240));
        jLabel5.setForeground(new java.awt.Color(57, 113, 117));
        jLabel5.setText("Nome da Máquina");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 20));

        jLabel6.setBackground(new java.awt.Color(240, 240, 240));
        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Verificamos que essa máquina não está cadastrada,");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 340, -1));

        userEmail2.setBackground(new java.awt.Color(32, 33, 35));
        userEmail2.setForeground(new java.awt.Color(255, 255, 255));
        userEmail2.setBorder(null);
        userEmail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmail2ActionPerformed(evt);
            }
        });
        jPanel2.add(userEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 340, 20));

        jLabel7.setBackground(new java.awt.Color(240, 240, 240));
        jLabel7.setForeground(new java.awt.Color(57, 113, 117));
        jLabel7.setText("Localização");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, 20));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 340, -1));

        userEmail3.setBackground(new java.awt.Color(32, 33, 35));
        userEmail3.setForeground(new java.awt.Color(255, 255, 255));
        userEmail3.setBorder(null);
        userEmail3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmail3ActionPerformed(evt);
            }
        });
        jPanel2.add(userEmail3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 340, 20));

        jLabel8.setBackground(new java.awt.Color(240, 240, 240));
        jLabel8.setForeground(new java.awt.Color(57, 113, 117));
        jLabel8.setText("Sistema Operacional");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, 20));

        jLabel9.setBackground(new java.awt.Color(240, 240, 240));
        jLabel9.setForeground(new java.awt.Color(57, 113, 117));
        jLabel9.setText("Número de Série");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, 20));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 340, -1));

        userEmail4.setBackground(new java.awt.Color(32, 33, 35));
        userEmail4.setForeground(new java.awt.Color(255, 255, 255));
        userEmail4.setBorder(null);
        userEmail4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmail4ActionPerformed(evt);
            }
        });
        jPanel2.add(userEmail4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 340, 20));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 340, -1));

        userEmail5.setBackground(new java.awt.Color(32, 33, 35));
        userEmail5.setForeground(new java.awt.Color(255, 255, 255));
        userEmail5.setBorder(null);
        userEmail5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmail5ActionPerformed(evt);
            }
        });
        jPanel2.add(userEmail5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 340, 20));

        jLabel10.setBackground(new java.awt.Color(240, 240, 240));
        jLabel10.setForeground(new java.awt.Color(57, 113, 117));
        jLabel10.setText("Modelo");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, 20));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmail1ActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void userEmail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmail2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmail2ActionPerformed

    private void userEmail3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmail3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmail3ActionPerformed

    private void userEmail4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmail4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmail4ActionPerformed

    private void userEmail5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmail5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userEmail5ActionPerformed

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
            java.util.logging.Logger.getLogger(ComputerRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComputerRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComputerRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComputerRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComputerRegister().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField userEmail1;
    private javax.swing.JTextField userEmail2;
    private javax.swing.JTextField userEmail3;
    private javax.swing.JTextField userEmail4;
    private javax.swing.JTextField userEmail5;
    // End of variables declaration//GEN-END:variables
}
