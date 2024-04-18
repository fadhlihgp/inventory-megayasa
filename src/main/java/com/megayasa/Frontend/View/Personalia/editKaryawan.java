package com.megayasa.Frontend.View.Personalia;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.EmployeeController;
import com.megayasa.Backend.Controllers.PositionController;
import com.megayasa.Backend.Helpers.ChangeDateFormat;
import com.megayasa.Backend.Models.Position;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.ViewModels.Requests.EmployeeRequestVm;
import com.megayasa.Frontend.Helpers.ComboBoxListCellRender;
import com.megayasa.Frontend.View.Asset.menu.FormManager;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import java.awt.Font;
import java.sql.Date;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Ridho Multazam
 */
public class editKaryawan extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */

    private EmployeeController employeeController;
    private PositionController positionController;
    private EmployeeRequestVm employeeRequestVm;

    public editKaryawan(EmployeeRequestVm employeeRequestVm) {
        this.employeeRequestVm = employeeRequestVm;
        initComponents();
        initializeData();
        btCalendar.setIcon(new FlatSVGIcon("iconSVG/btCalendar.svg", 0.90f));

        new JProgressBar().setIndeterminate(true);
        dateChooser.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser.hidePopup();
                }
            }
        });
    }

    public editKaryawan() {
        initComponents();
        initializeData();
        btCalendar.setIcon(new FlatSVGIcon("iconSVG/btCalendar.svg", 0.90f));

        new JProgressBar().setIndeterminate(true);
        dateChooser.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
//                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser.hidePopup();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new com.raven.datechooser.DateChooser();
        status = new javax.swing.ButtonGroup();
        JK = new javax.swing.ButtonGroup();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        Title = new javax.swing.JLabel();
        subTitle = new javax.swing.JLabel();
        idKaryawan = new javax.swing.JLabel();
        txIdkaryawan = new javax.swing.JTextField();
        Nama = new javax.swing.JLabel();
        txFirst = new javax.swing.JTextField();
        txLast = new javax.swing.JTextField();
        Posisi = new javax.swing.JLabel();
        Jabatan = new javax.swing.JComboBox<>();
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

        dateChooser.setForeground(new java.awt.Color(15, 42, 61));
        dateChooser.setTextRefernce(txBirthday);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(64, 67, 69));

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

        Title.setText("Ubah Karyawan");
        crazyPanel1.add(Title);

        subTitle.setText("Publik");
        crazyPanel1.add(subTitle);

        idKaryawan.setText("ID Karyawan");
        crazyPanel1.add(idKaryawan);

        txIdkaryawan.setEditable(false);
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

        status.add(jAktif);
        jAktif.setText("Aktif");
        crazyPanel1.add(jAktif);

        status.add(jtidakAktif);
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

        JK.add(jPria);
        jPria.setText("Pria");
        crazyPanel1.add(jPria);

        JK.add(jWanita);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalendarActionPerformed
        dateChooser.showPopup();
    }//GEN-LAST:event_btCalendarActionPerformed

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        Position cbPosition = (Position) Jabatan.getSelectedItem();
        String employeeId = txIdkaryawan.getText();
        String fullName = txFirst.getText() + " " + txLast.getText();
        String position = cbPosition.getId();
        Boolean status = jAktif.isSelected() ? Boolean.TRUE : jtidakAktif.isSelected() ? false : null ;
        String identity = txIdentity.getText();
        Date birthDate = ChangeDateFormat.stringToDateSql("dd-MM-yyyy", txBirthday.getText());
        String gender = jPria.isSelected() ? "Pria" : jWanita.isSelected() ? "Wanita" : null;
        String address = jtAlamat.getText();
        String phone = txNumber.getText();

        EmployeeRequestVm employeeSave = new EmployeeRequestVm(employeeId, identity, fullName, birthDate, address, gender, phone, position, status);
        employeeController.createOrUpdateEmployee(employeeId, employeeSave);
        this.setVisible(false);
        FormManager.showForm(new Karyawan());
    }//GEN-LAST:event_btSimpanActionPerformed

    private void loadPositionData() {
        DefaultComboBoxModel<Position> defaultComboBoxModel = new DefaultComboBoxModel<>();
        List<Position> allPositions = positionController.findAllPositions();
        allPositions.add(0, new Position(null, "Pilih Jabatan"));
        for (Position allPosition : allPositions) {
            defaultComboBoxModel.addElement(allPosition);
        }
        Jabatan.setModel(defaultComboBoxModel);
        Jabatan.setRenderer(new ComboBoxListCellRender());
    }

    private void setFieldsValue() {
        if (employeeRequestVm != null) {
            String[] partsFullName = employeeRequestVm.getFullName().split(" ", 2);

            txIdkaryawan.setText(employeeRequestVm.getEmployeeId());
            txFirst.setText(partsFullName[0]);
            if (partsFullName.length > 1) {
                txLast.setText(partsFullName[1]);
            } else {
                txLast.setText("");
            }

            Position position = positionController.findPositionById(employeeRequestVm.getPositionId());
            if (position != null) {
                Jabatan.setSelectedItem(position);
            }

            if (employeeRequestVm.getIsActive()) {
                jAktif.setSelected(true);
            } else {
                jtidakAktif.setSelected(true);
            }

            txIdentity.setText(employeeRequestVm.getIdentityNumber());
            txBirthday.setText(ChangeDateFormat.dateToString("dd-MM-yyyy", employeeRequestVm.getBirthDate()));

            if (employeeRequestVm.getGender().equals("Pria")) {
                jPria.setSelected(true);
            } else {
                jWanita.setSelected(true);
            }

            jtAlamat.setText(employeeRequestVm.getAddress());
            txNumber.setText(employeeRequestVm.getPhoneNumber());
        }
    }

    private void initializeData() {
        employeeController = Guice.createInjector(new Injection()).getInstance(EmployeeController.class);
        positionController = Guice.createInjector(new Injection()).getInstance(PositionController.class);
        loadPositionData();
        setFieldsValue();
    }


    public static void main(String args[]) {
     FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("addThemes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new editKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JLabel Identitas;
    private javax.swing.ButtonGroup JK;
    private javax.swing.JComboBox<Position> Jabatan;
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
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JLabel idKaryawan;
    private javax.swing.JRadioButton jAktif;
    private javax.swing.JRadioButton jPria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton jWanita;
    private javax.swing.JTextArea jtAlamat;
    private javax.swing.JRadioButton jtidakAktif;
    private javax.swing.ButtonGroup status;
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
