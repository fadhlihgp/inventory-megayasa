package com.megayasa.Frontend.View.Produksi;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.InventoryController;
import com.megayasa.Backend.Controllers.StockInOutController;
import com.megayasa.Backend.Helpers.ChangeDateFormat;
import com.megayasa.Backend.Models.Inventory;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.ViewModels.Requests.StockInOutRequestVm;
import com.megayasa.Backend.ViewModels.Responses.StockInOutResponseVm;
import com.megayasa.Frontend.Helpers.ComboBoxListCellRender;
import com.megayasa.Frontend.Asset.menu.FormManager;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import java.awt.Font;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import javax.swing.*;

/**
 *
 * @author Ridho Multazam
 */
public class transaksiBarang extends javax.swing.JFrame {

    private InventoryController inventoryController;
    private StockInOutController stockInOutController;
    private String transactionCode;
    List<Inventory> allInventories;
    /**
     * Creates new form Test
     */
    public transaksiBarang(String transactionCode) {
        this.transactionCode = transactionCode;
        initComponents();
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
        initializeData();
    }
    public transaksiBarang() {
        initComponents();
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
        initializeData();
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
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        Title = new javax.swing.JLabel();
        subTitle = new javax.swing.JLabel();
        NamaBarang = new javax.swing.JLabel();
        Barang = new javax.swing.JComboBox<>();
        Jumlah = new javax.swing.JLabel();
        txJumlah = new javax.swing.JTextField();
        Tanggal = new javax.swing.JLabel();
        txDate = new javax.swing.JTextField();
        btCalendar = new javax.swing.JButton();
        keterangan = new javax.swing.JLabel();
        Keterangan = new javax.swing.JComboBox();
        Alamat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCatatan = new javax.swing.JTextArea();
        btSimpan = new javax.swing.JButton();

        dateChooser.setForeground(new java.awt.Color(15, 42, 61));
        dateChooser.setTextRefernce(txDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(64, 67, 69));
        setResizable(false);

        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20;[light]background:shade(@background,2%);[dark]background:tint(@background,2%)",
            new String[]{
                "font:bold +10",
                "font:bold +1",
                "",
                "",
                "",
                "showClearButton:true",
                "",
                "",
                "",
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
                "",
                "",
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

        Title.setText("Transaksi Barang");
        crazyPanel1.add(Title);

        subTitle.setText("Barang Keluar / Masuk");
        crazyPanel1.add(subTitle);

        NamaBarang.setText("Nama Barang");
        crazyPanel1.add(NamaBarang);
        crazyPanel1.add(Barang);

        Jumlah.setText("Jumlah");
        crazyPanel1.add(Jumlah);
        crazyPanel1.add(txJumlah);

        Tanggal.setText("Tanggal");
        crazyPanel1.add(Tanggal);

        txDate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        crazyPanel1.add(txDate);

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

        keterangan.setText("Keterangan");
        crazyPanel1.add(keterangan);

        Keterangan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Barang Masuk", "Barang Keluar" }));
        crazyPanel1.add(Keterangan);

        Alamat.setText("Catatan");
        crazyPanel1.add(Alamat);

        jtCatatan.setColumns(20);
        jtCatatan.setRows(3);
        jScrollPane1.setViewportView(jtCatatan);

        crazyPanel1.add(jScrollPane1);

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
            .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crazyPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalendarActionPerformed
        dateChooser.showPopup();
    }//GEN-LAST:event_btCalendarActionPerformed

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        Inventory inventory = (Inventory) Barang.getSelectedItem();
        String inventoryId = null;
        if (inventory != null) {
            inventoryId = inventory.getId();
        }
        Integer amount = Integer.parseInt(txJumlah.getText());
        Date date = ChangeDateFormat.stringToDateSql("dd-MM-yyyy", txDate.getText());
        Boolean status = Objects.requireNonNull(Keterangan.getSelectedItem()).toString().equalsIgnoreCase("Barang Masuk");
        String note = jtCatatan.getText();
        StockInOutRequestVm save = new StockInOutRequestVm(inventoryId, date, amount, status, note);
        if (transactionCode != null) {
            stockInOutController.createOrUpdateStockInOut(transactionCode, save);
        } else {
            stockInOutController.createOrUpdateStockInOut(null, save);
        }
        this.setVisible(false);
        FormManager.showForm(new Transaksi());
    }//GEN-LAST:event_btSimpanActionPerformed

    private void initializeData() {
        stockInOutController = Guice.createInjector(new Injection()).getInstance(StockInOutController.class);
        inventoryController = Guice.createInjector(new Injection()).getInstance(InventoryController.class);

        if (transactionCode != null) {
            subTitle.setText("Perbarui Barang Keluar / Masuk");
        }

        loadInventoryCombobox();
        loadFields();
    }

    private void loadInventoryCombobox() {
        DefaultComboBoxModel<Inventory> defaultComboBoxModel = new DefaultComboBoxModel<>();
        allInventories = inventoryController.findAllInventories();
        defaultComboBoxModel.addElement(new Inventory(null, "Pilih Barang", null, null, null));
        for (Inventory allInventory : allInventories) {
            defaultComboBoxModel.addElement(allInventory);
        }
        Barang.setModel(defaultComboBoxModel);
        Barang.setRenderer(new ComboBoxListCellRender());
    }

    private void loadFields() {
        if (transactionCode != null) {
            StockInOutResponseVm stockInOutById = stockInOutController.findStockInOutById(transactionCode);
            if (stockInOutById != null) {
                Inventory inventoryStream = allInventories.stream().filter(i -> i.getId()
                        .equals(stockInOutById.getInventoryId())).findFirst().orElse(null);
                Barang.setSelectedItem(inventoryStream);
                txJumlah.setText(stockInOutById.getAmount().toString());
                txDate.setText(ChangeDateFormat.dateToString("dd-MM-yyyy", stockInOutById.getDate()));
                String ket = stockInOutById.getStatus() ? "Barang Masuk" : "Barang Keluar";
                Keterangan.setSelectedItem(ket);
                jtCatatan.setText(stockInOutById.getNote());
            }
        }
    }
    public static void main(String args[]) {
     FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("addThemes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new transaksiBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JComboBox<Inventory> Barang;
    private javax.swing.JLabel Jumlah;
    private javax.swing.JComboBox Keterangan;
    private javax.swing.JLabel NamaBarang;
    private javax.swing.JLabel Tanggal;
    private javax.swing.JLabel Title;
    private javax.swing.JButton btCalendar;
    private javax.swing.JButton btSimpan;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtCatatan;
    private javax.swing.JLabel keterangan;
    private javax.swing.JLabel subTitle;
    private javax.swing.JTextField txDate;
    private javax.swing.JTextField txJumlah;
    // End of variables declaration//GEN-END:variables
}
