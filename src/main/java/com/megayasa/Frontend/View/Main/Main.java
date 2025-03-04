package com.megayasa.Frontend.View.Main;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.LoginController;
import com.megayasa.Backend.Controllers.LoginInformationController;
import com.megayasa.Backend.Models.LoginInformation;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.ViewModels.Requests.LoginRequestVm;
import com.megayasa.Backend.ViewModels.Responses.LoginResponseVm;
import com.megayasa.Frontend.Asset.application.Application;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;

/**
 *
 * @author Ridho Multazam
 */
public class Main extends javax.swing.JFrame {
    /**
     * Creates new form LoginPage
     */
    int xx, xy;
    private final LoginController loginController;
    private final LoginInformationController loginInformationController;
    public Main() {
        loginController = Guice.createInjector(new Injection()).getInstance(LoginController.class);
        loginInformationController = Guice.createInjector(new Injection()).getInstance(LoginInformationController.class);
        checkLogin();
        initComponents();
        setApplicationIcon();
        txUsername.setBackground(new java.awt.Color(0,0,0,1));
        txPassword.setBackground(new java.awt.Color(0,0,0,1));

        txUsername.setText("USERNAME");
        txPassword.setText("PASSWORD");
//        logo.setIcon(new FlatSVGIcon("iconSVG/worker.svg", 0.90f));

//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

          // Menambahkan window listener untuk menangani event windowDeiconified
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowDeiconified(WindowEvent e) {
//                // Set frame menjadi fullscreen ketika diaktifkan dari taskbar
//                setExtendedState(JFrame.MAXIMIZED_BOTH);
//            }
//        });
    }

//    Jika masih ada riwayat login (Belum logout) dan timeout expired login belum berakhir, maka akan dialihkan langsung ke halaman utama
    private void checkLogin() {
        LoginInformation loginInformation = loginInformationController.currentLogin();
        if (loginInformation != null) {
            if (loginInformation.getExpiredLogin().isAfter(LocalDateTime.now())) {
                EventQueue.invokeLater(() -> this.setVisible(false));
                new Application().open();
            } else {
                loginInformationController.deleteLoginInformation();
            }
        }
    }
    
    private void setApplicationIcon() {
        try {
            Image icon = ImageIO.read(getClass().getResourceAsStream("/image/logoME.png"));
            setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        bt_close = new javax.swing.JLabel();
        bt_minimize = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        txUsername = new javax.swing.JTextField();
        lock = new javax.swing.JLabel();
        txPassword = new javax.swing.JPasswordField();
        btLogin = new javax.swing.JButton();
        forgotPassword = new javax.swing.JLabel();
        copyright = new javax.swing.JLabel();
        Bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setUndecorated(true);
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

        jPanel1.setBackground(new java.awt.Color(33, 72, 192));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close-30.png"))); // NOI18N
        bt_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_closeMouseClicked(evt);
            }
        });
        jPanel1.add(bt_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, -1, -1));

        bt_minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bt_minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minimize-30.png"))); // NOI18N
        bt_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_minimizeMouseClicked(evt);
            }
        });
        jPanel1.add(bt_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 30, 30));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/worker-male-skin-type-3-100.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 170, 124, 117));

        User.setBackground(new java.awt.Color(33, 72, 192));
        User.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        User.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UserFocusLost(evt);
            }
        });
        jPanel1.add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 343, 20, 20));

        txUsername.setBackground(new java.awt.Color(33, 72, 192));
        txUsername.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txUsername.setForeground(new java.awt.Color(255, 255, 255));
        txUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txUsername.setText("USERNAME");
        txUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 300, 45));
        txUsername.getAccessibleContext().setAccessibleName("");

        lock.setBackground(new java.awt.Color(33, 72, 192));
        lock.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        lock.setForeground(new java.awt.Color(255, 255, 255));
        lock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lock.png"))); // NOI18N
        lock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lockFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lockFocusLost(evt);
            }
        });
        jPanel1.add(lock, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 408, 20, 20));

        txPassword.setBackground(new java.awt.Color(33, 72, 192));
        txPassword.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txPassword.setForeground(new java.awt.Color(255, 255, 255));
        txPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txPassword.setText("PASSWORD");
        txPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(txPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 395, 300, 45));

        btLogin.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        btLogin.setForeground(new java.awt.Color(33, 72, 192));
        btLogin.setText("LOGIN");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 483, 300, 45));

        forgotPassword.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        forgotPassword.setForeground(new java.awt.Color(255, 255, 255));
        forgotPassword.setText("Forgot password?");
        jPanel1.add(forgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(644, 539, 146, 20));

        copyright.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        copyright.setForeground(new java.awt.Color(204, 204, 204));
        copyright.setText("copyright © PT MEGAYASA ENGINEERING All rights reserved");
        jPanel1.add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 680, -1, -1));

        Bg.setBackground(new java.awt.Color(255, 255, 255));
        Bg.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        Bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg-login.png"))); // NOI18N
        jPanel1.add(Bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1280, 720));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_minimizeMouseClicked
            this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_bt_minimizeMouseClicked

    private void bt_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_closeMouseClicked
//        dispose();
        System.exit(0);
    }//GEN-LAST:event_bt_closeMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void lockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lockFocusGained
        String pass=txPassword.getText();
        if(pass.equals("PASSWORD")){
            txPassword.setText("");
        }
    }//GEN-LAST:event_lockFocusGained

    private void lockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lockFocusLost
        String pass=txPassword.getText();
        if(pass.equals("") ||pass.equals("PASSWORD")){
            txPassword.setText("PASSWORD");
        }
    }//GEN-LAST:event_lockFocusLost

    private void UserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserFocusGained
        String username=txUsername.getText();
        if(username.equals("USERNAME")){
            txUsername.setText("");
        }
    }//GEN-LAST:event_UserFocusGained

    private void UserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserFocusLost
        String username=txUsername.getText();
        if(username.equals("") ||username.equals("USERNAME")){
            txUsername.setText("USERNAME");
        }
    }//GEN-LAST:event_UserFocusLost

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // TODO add your handling code here:
        String username = txUsername.getText();
        String password = txPassword.getText();

        LoginResponseVm login = loginController.login(new LoginRequestVm(username, password));
        if (login != null) {
            this.setVisible(false);
            new Application().open();
        }
    }//GEN-LAST:event_btLoginActionPerformed
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bg;
    private javax.swing.JLabel User;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel bt_close;
    private javax.swing.JLabel bt_minimize;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel forgotPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lock;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField txPassword;
    private javax.swing.JTextField txUsername;
    // End of variables declaration//GEN-END:variables
}
