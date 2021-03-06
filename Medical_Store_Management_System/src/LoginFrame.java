
import DBHandling.DBHandler;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adeel
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        scaleImage();
    }
    
    public void scaleImage(){
        ImageIcon icon = new ImageIcon("src//medicines-drug-collection-with-banner-free-space_65709-20.jpg");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(picLbl.getWidth(), picLbl.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        picLbl.setIcon(scaledIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        headingLbl = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        loginSectionPanel = new javax.swing.JPanel();
        usernameLbl = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        passwordLbl = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        picLbl = new javax.swing.JLabel();
        invalidLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login:  Medical Store Management System");
        setLocation(new java.awt.Point(300, 200));
        setName("loginFrame"); // NOI18N

        mainPanel.setLayout(null);

        headingLbl.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        headingLbl.setText("Medical Store Management System");
        mainPanel.add(headingLbl);
        headingLbl.setBounds(10, 14, 510, 30);

        loginBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        mainPanel.add(loginBtn);
        loginBtn.setBounds(460, 260, 100, 30);

        loginSectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N

        usernameLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        usernameLbl.setText("Username:");

        usernameTF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        passwordLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        passwordLbl.setText("Password:");

        passwordField.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginSectionPanelLayout = new javax.swing.GroupLayout(loginSectionPanel);
        loginSectionPanel.setLayout(loginSectionPanelLayout);
        loginSectionPanelLayout.setHorizontalGroup(
            loginSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginSectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginSectionPanelLayout.createSequentialGroup()
                        .addComponent(usernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                    .addGroup(loginSectionPanelLayout.createSequentialGroup()
                        .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordField)))
                .addContainerGap())
        );
        loginSectionPanelLayout.setVerticalGroup(
            loginSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginSectionPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(loginSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(passwordField))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        mainPanel.add(loginSectionPanel);
        loginSectionPanel.setBounds(270, 70, 320, 160);
        mainPanel.add(picLbl);
        picLbl.setBounds(10, 70, 240, 180);

        invalidLbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        invalidLbl.setForeground(new java.awt.Color(255, 0, 0));
        invalidLbl.setText("Enter a valid Username and Password");
        mainPanel.add(invalidLbl);
        invalidLbl.setBounds(280, 230, 250, 30);
        invalidLbl.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        DBHandler db = new DBHandler();
        String username = usernameTF.getText();
        String password = passwordField.getText();
        if(db.validateUser(username, password)){
            if(username.equals("admin")){
                AdminDashboardFrame adminFrame = new AdminDashboardFrame();
                adminFrame.setVisible(true);
            }
            else{
                EmployeeDashboardFrame employeeFrame = new EmployeeDashboardFrame();
                employeeFrame.setVisible(true);
            }
            this.setVisible(false);
        }
        else{
            invalidLbl.setVisible(true);
        }
    }//GEN-LAST:event_loginBtnActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headingLbl;
    private javax.swing.JLabel invalidLbl;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginSectionPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JLabel picLbl;
    private javax.swing.JLabel usernameLbl;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
