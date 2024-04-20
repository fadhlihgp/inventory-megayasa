package com.megayasa.Frontend.View.Pengaturan;

import com.megayasa.Frontend.View.Asset.components.SimpleForm;

/**
 *
 * @author Ridho Multazam
 */
public class Akun extends SimpleForm {

    public Akun() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        Title = new javax.swing.JLabel();
        subTitle = new javax.swing.JLabel();
        idKaryawan = new javax.swing.JLabel();
        txIdkaryawan = new javax.swing.JTextField();
        Nama = new javax.swing.JLabel();
        txFirst = new javax.swing.JTextField();
        txLast = new javax.swing.JTextField();
        Posisi = new javax.swing.JLabel();
        Jabatan = new javax.swing.JComboBox();
        Status = new javax.swing.JLabel();
        jAktif = new javax.swing.JRadioButton();
        jtidakAktif = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        subTitle2 = new javax.swing.JLabel();
        Identitas = new javax.swing.JLabel();
        txIdentity = new javax.swing.JTextField();
        TanggalLahir = new javax.swing.JLabel();
        txBirthday = new javax.swing.JTextField();
        btCalendar = new javax.swing.JButton();
        JenisKelamin = new javax.swing.JLabel();
        jPria = new javax.swing.JRadioButton();
        jWanita = new javax.swing.JRadioButton();
        Alamat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlamat = new javax.swing.JTextArea();
        Telepon = new javax.swing.JLabel();
        txNumber = new javax.swing.JTextField();
        btSimpan = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        jLabel1.setText("Akun");

        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20;[light]background:shade(@background,2%);[dark]background:tint(@background,2%)",
            new String[]{
                "font:bold +10",
                "font:bold +1",
                "",
                "showClearButton:true",
                "",
                "showClearButton:true;JTextField.placeholderText=Nama Depan",
                "showClearButton:true;JTextField.placeholderText=Nama Belakang",
                "",
                "",
                "",
                "",
                "",
                "",
                "font:bold +1",
                "",
                "showClearButton:true;JTextField.placeholderText=KTP",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "showClearButton:true",
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
                "",
                "",
                "split 2",
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
                "split 2",
                "",
                "",
                "split 2",
                "",
                "",
                "",
                "",
                "",
                "span 2,al trail"
            }
        ));

        Title.setText("Tambah Karyawan");
        crazyPanel1.add(Title);

        subTitle.setText("Publik");
        crazyPanel1.add(subTitle);

        idKaryawan.setText("ID Karyawan");
        crazyPanel1.add(idKaryawan);
        crazyPanel1.add(txIdkaryawan);

        Nama.setText("Nama Lengkap");
        crazyPanel1.add(Nama);
        crazyPanel1.add(txFirst);
        crazyPanel1.add(txLast);

        Posisi.setText("Posisi");
        crazyPanel1.add(Posisi);
        crazyPanel1.add(Jabatan);

        Status.setText("Status");
        crazyPanel1.add(Status);

        jAktif.setText("Aktif");
        crazyPanel1.add(jAktif);

        jtidakAktif.setText("Tidak Aktif");
        crazyPanel1.add(jtidakAktif);
        crazyPanel1.add(jSeparator1);

        subTitle2.setText("Privasi");
        crazyPanel1.add(subTitle2);

        Identitas.setText("No Identitas");
        crazyPanel1.add(Identitas);
        crazyPanel1.add(txIdentity);

        TanggalLahir.setText("Tanggal Lahir");
        crazyPanel1.add(TanggalLahir);

        txBirthday.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        crazyPanel1.add(txBirthday);

        btCalendar.setMaximumSize(new java.awt.Dimension(72, 23));
        btCalendar.setMinimumSize(new java.awt.Dimension(72, 23));
        btCalendar.setPreferredSize(new java.awt.Dimension(72, 23));
        btCalendar.setSelected(true);
        btCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalendarActionPerformed(evt);
            }
        });
        crazyPanel1.add(btCalendar);

        JenisKelamin.setText("Jenis Kelamin");
        crazyPanel1.add(JenisKelamin);

        jPria.setText("Pria");
        crazyPanel1.add(jPria);

        jWanita.setText("Wanita");
        crazyPanel1.add(jWanita);

        Alamat.setText("Alamat");
        crazyPanel1.add(Alamat);

        jtAlamat.setColumns(20);
        jtAlamat.setRows(3);
        jScrollPane1.setViewportView(jtAlamat);

        crazyPanel1.add(jScrollPane1);

        Telepon.setText("No Telepon");
        crazyPanel1.add(Telepon);
        crazyPanel1.add(txNumber);

        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });
        crazyPanel1.add(btSimpan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalendarActionPerformed
  
    }//GEN-LAST:event_btCalendarActionPerformed

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btSimpanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JLabel Identitas;
    private javax.swing.JComboBox Jabatan;
    private javax.swing.JLabel JenisKelamin;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel Posisi;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel TanggalLahir;
    private javax.swing.JLabel Telepon;
    private javax.swing.JLabel Title;
    private javax.swing.JButton btCalendar;
    private javax.swing.JButton btSimpan;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private javax.swing.JLabel idKaryawan;
    private javax.swing.JRadioButton jAktif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jPria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton jWanita;
    private javax.swing.JTextArea jtAlamat;
    private javax.swing.JRadioButton jtidakAktif;
    private javax.swing.JLabel subTitle;
    private javax.swing.JLabel subTitle2;
    private javax.swing.JTextField txBirthday;
    private javax.swing.JTextField txFirst;
    private javax.swing.JTextField txIdentity;
    private javax.swing.JTextField txIdkaryawan;
    private javax.swing.JTextField txLast;
    private javax.swing.JTextField txNumber;
    // End of variables declaration//GEN-END:variables
}
