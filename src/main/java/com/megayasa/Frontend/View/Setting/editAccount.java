package com.megayasa.Frontend.View.Setting;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Ridho Multazam
 */
public class editAccount extends javax.swing.JFrame {


    /**
     * Creates new form Test
     */
    public editAccount() {
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

        status = new javax.swing.ButtonGroup();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        Title = new javax.swing.JLabel();
        subTitle = new javax.swing.JLabel();
        Nama = new javax.swing.JLabel();
        txFirst = new javax.swing.JTextField();
        txLast = new javax.swing.JTextField();
        idKaryawan = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        Telepon = new javax.swing.JLabel();
        txNumber = new javax.swing.JTextField();
        Karyawan = new javax.swing.JLabel();
        jcKaryawan = new javax.swing.JComboBox();
        Status = new javax.swing.JLabel();
        jAktif = new javax.swing.JRadioButton();
        jtidakAktif = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        subTitle2 = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        txUsername = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        Karyawan1 = new javax.swing.JLabel();
        jcRole = new javax.swing.JComboBox();
        btSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(64, 67, 69));
        setResizable(false);

        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20;[light]background:shade(@background,2%);[dark]background:tint(@background,2%)",
            new String[]{
                "font:bold +10",
                "font:bold +1",
                "",
                "showClearButton:true;JTextField.placeholderText=Nama Depan",
                "showClearButton:true;JTextField.placeholderText=Nama Belakang",
                "",
                "showClearButton:true",
                "",
                "showClearButton:true",
                "",
                "",
                "",
                "",
                "",
                "",
                "font:bold +1",
                "",
                "showClearButton:true",
                "",
                "showClearButton:true",
                "",
                "",
                ""
            }
        ));
        crazyPanel1.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap 2,fillx,insets 25",
            "[grow 0,trail]15[fill]",
            "",
            new String[]{
                "wrap,al lead",
                "wrap,al lead",
                "",
                "split 2",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "split 2",
                "",
                "span 2,grow 1",
                "wrap,al lead",
                "",
                "",
                "",
                "",
                "",
                "",
                "span 2,al trail"
            }
        ));

        Title.setText("Ubah Akun");
        crazyPanel1.add(Title);

        subTitle.setText("Personal");
        crazyPanel1.add(subTitle);

        Nama.setText("Nama Lengkap");
        crazyPanel1.add(Nama);
        crazyPanel1.add(txFirst);
        crazyPanel1.add(txLast);

        idKaryawan.setText("Email");
        crazyPanel1.add(idKaryawan);
        crazyPanel1.add(txEmail);

        Telepon.setText("No Telepon");
        crazyPanel1.add(Telepon);
        crazyPanel1.add(txNumber);

        Karyawan.setText("Karyawan");
        crazyPanel1.add(Karyawan);

        jcKaryawan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Karyawan" }));
        crazyPanel1.add(jcKaryawan);

        Status.setText("Status");
        crazyPanel1.add(Status);

        status.add(jAktif);
        jAktif.setText("Aktif");
        crazyPanel1.add(jAktif);

        status.add(jtidakAktif);
        jtidakAktif.setText("Tidak Aktif");
        crazyPanel1.add(jtidakAktif);
        crazyPanel1.add(jSeparator1);

        subTitle2.setText("Login");
        crazyPanel1.add(subTitle2);

        Username.setText("Username");
        crazyPanel1.add(Username);
        crazyPanel1.add(txUsername);

        Password.setText("Password");
        crazyPanel1.add(Password);

        jPassword.setText("jPasswordField1");
        crazyPanel1.add(jPassword);

        Karyawan1.setText("Role");
        crazyPanel1.add(Karyawan1);

        jcRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Role" }));
        crazyPanel1.add(jcRole);

        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });
        crazyPanel1.add(btSimpan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addGap(460, 460, 460))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSimpanActionPerformed


    public static void main(String args[]) {
     FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("addThemes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new editAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Karyawan;
    private javax.swing.JLabel Karyawan1;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel Telepon;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Username;
    private javax.swing.JButton btSimpan;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private javax.swing.JLabel idKaryawan;
    private javax.swing.JRadioButton jAktif;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox jcKaryawan;
    private javax.swing.JComboBox jcRole;
    private javax.swing.JRadioButton jtidakAktif;
    private javax.swing.ButtonGroup status;
    private javax.swing.JLabel subTitle;
    private javax.swing.JLabel subTitle2;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txFirst;
    private javax.swing.JTextField txLast;
    private javax.swing.JTextField txNumber;
    private javax.swing.JTextField txUsername;
    // End of variables declaration//GEN-END:variables
}
