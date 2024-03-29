/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import lamhdt.dtos.UserDTO;
import lamhdt.model.UserDAO;

/**
 *
 * @author HL
 */
public class LoginJFrame extends javax.swing.JFrame {
    private UI UI = null;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private int offsetX, offsetY;

    /**
     * Creates new form LoginJFrame
     */
    public void MyInit() {
        txtPassword.setVisible(false);
        txtError.requestFocus();
    }

    public void showError(String msg) {
        if (!msg.equals("")) {
            txtError.setBackground(Color.red);
            txtError.setText(msg);
        } else {
            txtError.setBackground(Color.BLACK);
            txtError.setText("");
        }
    }

    public void showLoading() {
        txtError.setBackground(Color.GREEN);
        txtError.setText(" Loading . . .");
    }

    public LoginJFrame() {
        initComponents();
        MyInit();
        this.setLocation(screenSize.width / 2 - this.getSize().width / 2, screenSize.height / 2 - this.getSize().height / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        txtTitleProject = new javax.swing.JLabel();
        bg_Img = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        titleBar1 = new javax.swing.JPanel();
        loginFormPanel = new javax.swing.JPanel();
        titleBar = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        loginForm = new javax.swing.JPanel();
        titleLogin = new javax.swing.JLabel();
        separate = new javax.swing.JLabel();
        txtError = new javax.swing.JLabel();
        txtAccount = new javax.swing.JTextField();
        separate1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        passPlacehold = new javax.swing.JTextField();
        separate3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        separate4 = new javax.swing.JLabel();
        txtCopyright = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tay Du Ky Project");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(750, 555));
        setMinimumSize(new java.awt.Dimension(750, 555));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(730, 555));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        leftPanel.setToolTipText("");
        leftPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        leftPanel.setPreferredSize(new java.awt.Dimension(428, 600));
        leftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitleProject.setBackground(new java.awt.Color(255, 255, 255));
        txtTitleProject.setFont(new java.awt.Font("SVN-The Carpenter", 3, 120)); // NOI18N
        txtTitleProject.setForeground(new java.awt.Color(255, 255, 255));
        txtTitleProject.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTitleProject.setText(" Tây Du Ký");
        txtTitleProject.setPreferredSize(new java.awt.Dimension(372, 206));
        txtTitleProject.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        leftPanel.add(txtTitleProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 420, 390));

        bg_Img.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bg_Img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg-login.jpg"))); // NOI18N
        bg_Img.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        leftPanel.add(bg_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        leftPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 40));

        titleBar1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleBar1MouseDragged(evt);
            }
        });
        titleBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleBar1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout titleBar1Layout = new javax.swing.GroupLayout(titleBar1);
        titleBar1.setLayout(titleBar1Layout);
        titleBar1Layout.setHorizontalGroup(
            titleBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        titleBar1Layout.setVerticalGroup(
            titleBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        leftPanel.add(titleBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 40));

        getContentPane().add(leftPanel);
        leftPanel.getAccessibleContext().setAccessibleName("");

        loginFormPanel.setBackground(new java.awt.Color(13, 13, 14));
        loginFormPanel.setPreferredSize(new java.awt.Dimension(410, 116));
        loginFormPanel.setLayout(new java.awt.BorderLayout());

        titleBar.setBackground(new java.awt.Color(32, 33, 35));
        titleBar.setPreferredSize(new java.awt.Dimension(420, 36));

        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_power_off_button_36px.png"))); // NOI18N
        btnExit.setToolTipText("Exit");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setIconTextGap(3);
        btnExit.setPreferredSize(new java.awt.Dimension(50, 50));
        btnExit.setRequestFocusEnabled(false);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleBarLayout.createSequentialGroup()
                .addGap(0, 517, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        loginFormPanel.add(titleBar, java.awt.BorderLayout.PAGE_START);

        loginForm.setBackground(new java.awt.Color(32, 33, 35));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        loginForm.setLayout(flowLayout1);

        titleLogin.setBackground(new java.awt.Color(0, 0, 0));
        titleLogin.setFont(new java.awt.Font("SVN-Sliced", 0, 110)); // NOI18N
        titleLogin.setForeground(new java.awt.Color(255, 255, 255));
        titleLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLogin.setText("LOGIN");
        titleLogin.setPreferredSize(new java.awt.Dimension(300, 70));
        loginForm.add(titleLogin);

        separate.setPreferredSize(new java.awt.Dimension(410, 30));
        loginForm.add(separate);

        txtError.setBackground(new java.awt.Color(32, 33, 35));
        txtError.setFont(new java.awt.Font("SVN-Sliced", 0, 36)); // NOI18N
        txtError.setForeground(new java.awt.Color(255, 255, 255));
        txtError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtError.setOpaque(true);
        txtError.setPreferredSize(new java.awt.Dimension(420, 60));
        loginForm.add(txtError);

        txtAccount.setBackground(new java.awt.Color(32, 33, 35));
        txtAccount.setFont(new java.awt.Font("SVN-Sliced", 0, 36)); // NOI18N
        txtAccount.setForeground(new java.awt.Color(255, 255, 255));
        txtAccount.setText("   Account");
        txtAccount.setToolTipText("Username must be letter or number");
        txtAccount.setAutoscrolls(false);
        txtAccount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 255)));
        txtAccount.setCaretColor(new java.awt.Color(13, 13, 14));
        txtAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAccount.setOpaque(false);
        txtAccount.setPreferredSize(new java.awt.Dimension(300, 50));
        txtAccount.setSelectionColor(new java.awt.Color(0, 0, 204));
        txtAccount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAccountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAccountFocusLost(evt);
            }
        });
        txtAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccountActionPerformed(evt);
            }
        });
        loginForm.add(txtAccount);

        separate1.setPreferredSize(new java.awt.Dimension(300, 25));
        loginForm.add(separate1);

        txtPassword.setBackground(new java.awt.Color(32, 33, 35));
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setToolTipText("Password must be letter or number");
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 255)));
        txtPassword.setPreferredSize(new java.awt.Dimension(300, 50));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        loginForm.add(txtPassword);

        passPlacehold.setEditable(false);
        passPlacehold.setBackground(new java.awt.Color(32, 33, 35));
        passPlacehold.setFont(new java.awt.Font("SVN-Sliced", 0, 36)); // NOI18N
        passPlacehold.setForeground(new java.awt.Color(255, 255, 255));
        passPlacehold.setText("   Password");
        passPlacehold.setToolTipText("Password must be letter or number");
        passPlacehold.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 255)));
        passPlacehold.setOpaque(false);
        passPlacehold.setPreferredSize(new java.awt.Dimension(300, 50));
        passPlacehold.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passPlaceholdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passPlaceholdFocusLost(evt);
            }
        });
        passPlacehold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passPlaceholdActionPerformed(evt);
            }
        });
        loginForm.add(passPlacehold);

        separate3.setBackground(new java.awt.Color(0, 0, 0));
        separate3.setPreferredSize(new java.awt.Dimension(300, 50));
        loginForm.add(separate3);

        btnLogin.setBackground(new java.awt.Color(57, 112, 167));
        btnLogin.setFont(new java.awt.Font("SVN-Segoe UI", 3, 36)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setMnemonic(KeyEvent.VK_ENTER);
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLogin.setBorderPainted(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setPreferredSize(new java.awt.Dimension(335, 50));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        loginForm.add(btnLogin);

        separate4.setPreferredSize(new java.awt.Dimension(300, 20));
        loginForm.add(separate4);

        txtCopyright.setBackground(new java.awt.Color(13, 13, 14));
        txtCopyright.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        txtCopyright.setForeground(new java.awt.Color(255, 255, 255));
        txtCopyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCopyright.setText("© SE141120");
        txtCopyright.setPreferredSize(new java.awt.Dimension(250, 20));
        loginForm.add(txtCopyright);

        loginFormPanel.add(loginForm, java.awt.BorderLayout.CENTER);

        getContentPane().add(loginFormPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccountActionPerformed


    }//GEN-LAST:event_txtAccountActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void passPlaceholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passPlaceholdActionPerformed

    }//GEN-LAST:event_passPlaceholdActionPerformed

    private void txtAccountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAccountFocusGained
        if (txtAccount.getText().trim().equalsIgnoreCase("Account")) {
            txtAccount.setText("");
        }
        txtAccount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(57, 112, 167)));
    }//GEN-LAST:event_txtAccountFocusGained

    private void txtAccountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAccountFocusLost
        if (txtAccount.getText().trim().equals("")) {
            txtAccount.setText("  Account");
        }
        txtAccount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_txtAccountFocusLost

    private void passPlaceholdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passPlaceholdFocusGained
        passPlacehold.setVisible(false);
        txtPassword.setVisible(true);
        txtPassword.setFocusable(true);
        txtPassword.requestFocus();
        if (passPlacehold.getText().trim().equals("Password")) {
            passPlacehold.setText("");
        }
        passPlacehold.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(57, 112, 167)));
    }//GEN-LAST:event_passPlaceholdFocusGained

    private void passPlaceholdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passPlaceholdFocusLost
        if (passPlacehold.getText().trim().equals("")) {
            passPlacehold.setText("  Password");
        }
        passPlacehold.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(255, 255, 255)));
    }//GEN-LAST:event_passPlaceholdFocusLost

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = txtAccount.getText();
        String password = new String(txtPassword.getPassword());
        int permission = -1;
        if (username.trim().equalsIgnoreCase("Account")) {
            showError("Please Input Account");
            return;
        }
        if (!username.matches("[A-Za-z0-9]+")) {
            showError("Account Invalid(A-z0-9)");
            return;
        }

        if (password.trim().equals("")) {
            showError("Please Input Password");
            return;
        }
        if (!password.trim().matches("[A-Za-z0-9]+")) {
            showError("Password Invalid(A-z0-9)");
            return;
        }
        showLoading();
        UserDAO dao = new UserDAO();
        UserDTO dto = new UserDTO(username, password);
        try {
            permission = dao.checkLogin(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (permission != -1) {
            this.dispose();
            UI = new UI(permission, dto.getUsername(),dto.getPassword());
            UI.setVisible(true);
        } else {
            showError("!!! Invalid username or password");
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        offsetX = evt.getX();
        offsetY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        this.setLocation(evt.getXOnScreen() - offsetX, evt.getYOnScreen() - offsetY);
    }//GEN-LAST:event_formMouseDragged

    private void titleBar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBar1MousePressed
        // TODO add your handling code here:
        offsetX = evt.getX();
        offsetY = evt.getY();
    }//GEN-LAST:event_titleBar1MousePressed

    private void titleBar1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBar1MouseDragged
        // TODO add your handling code here:
        this.setLocation(evt.getXOnScreen() - offsetX, evt.getYOnScreen() - offsetY);
    }//GEN-LAST:event_titleBar1MouseDragged

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(57, 112, 167)));
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if ((new String(txtPassword.getPassword())).equals("")) {
            txtPassword.setVisible(false);
            passPlacehold.setVisible(true);

        }
    }//GEN-LAST:event_txtPasswordFocusLost

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
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg_Img;
    private javax.swing.JLabel btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel loginForm;
    private javax.swing.JPanel loginFormPanel;
    private javax.swing.JTextField passPlacehold;
    private javax.swing.JLabel separate;
    private javax.swing.JLabel separate1;
    private javax.swing.JLabel separate3;
    private javax.swing.JLabel separate4;
    private javax.swing.JPanel titleBar;
    private javax.swing.JPanel titleBar1;
    private javax.swing.JLabel titleLogin;
    private javax.swing.JTextField txtAccount;
    private javax.swing.JLabel txtCopyright;
    private javax.swing.JLabel txtError;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel txtTitleProject;
    // End of variables declaration//GEN-END:variables
}
