package com.megayasa.Frontend.View.Production;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.StockInOutController;
import com.megayasa.Backend.Dialogs.ConfirmationDialog;
import com.megayasa.Backend.Helpers.ChangeDateFormat;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.Utils.PrintReport;
import com.megayasa.Backend.ViewModels.Responses.StockInOutResponseVm;
import com.megayasa.Frontend.Asset.Table.TableActionCellEditorDelete;
import com.megayasa.Frontend.Asset.Table.TableActionCellRenderDelete;
import com.megayasa.Frontend.Asset.Table.TableActionDelete;
import com.megayasa.Frontend.Asset.components.SimpleForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ridho Multazam
 */
public class formTransaction extends SimpleForm {

    private StockInOutController stockInOutController;
    private List<StockInOutResponseVm> allTransactions;
    private List<StockInOutResponseVm> filteredTransactions;

    public formTransaction() {
        initComponents();
        applyTableStyle(tableTransaksi);
        initializeData();
    }

    private void applyTableStyle(JTable table) {

        btPrint.setIcon(new FlatSVGIcon("iconSVG/print.svg", 0.35f));
        btTransaksi.setIcon(new FlatSVGIcon("iconSVG/right-left.svg", 0.35f));

        txSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, new FlatSVGIcon("iconSVG/search.svg", 0.35f));
        //  Change scroll style
        JScrollPane scroll = (JScrollPane) table.getParent().getParent();
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Table.background;"
                + "track:$Table.background;"
                + "trackArc:999");

        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        table.putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        txSearch = new javax.swing.JTextField();
        btTransaksi = new javax.swing.JButton();
        btPrint = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        jLabel2.setText("Riwayat Transaksi");

        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background;[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20",
            null
        ));
        crazyPanel1.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fill,insets 15",
            "[fill]",
            "[grow 0][fill]",
            null
        ));

        crazyPanel2.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background",
            new String[]{
                "JTextField.placeholderText=Search;background:@background",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1"
            }
        ));
        crazyPanel2.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "",
            "[]push[][]",
            "",
            new String[]{
                "width 200"
            }
        ));

        txSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txSearchKeyTyped(evt);
            }
        });
        crazyPanel2.add(txSearch);

        btTransaksi.setText("Transaksi");
        btTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTransaksiActionPerformed(evt);
            }
        });
        crazyPanel2.add(btTransaksi);

        btPrint.setText("Print");
        btPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintActionPerformed(evt);
            }
        });
        crazyPanel2.add(btPrint);

        crazyPanel1.add(crazyPanel2);

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Barang", "Jumlah", "Tanggal", "Keterangan", "Catatan", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTransaksi.setRowHeight(35);
        jScrollPane2.setViewportView(tableTransaksi);

        crazyPanel1.add(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 383, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(648, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(50, Short.MAX_VALUE)
                    .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearchKeyTyped
        // TODO add your handling code here:
        String search = txSearch.getText().toLowerCase();
        filteredTransactions = allTransactions.stream().filter(t -> t.getInventoryName().toLowerCase().contains(search)
                || t.getInventoryCode().toLowerCase().contains(search)
        ).toList();
        fetchAllTransactions();
    }//GEN-LAST:event_txSearchKeyTyped

    private void btTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTransaksiActionPerformed
        // TODO add your handling code here:
        addTransaction a = new addTransaction();
        a.setVisible(true);
    }//GEN-LAST:event_btTransaksiActionPerformed

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintActionPerformed
        // TODO add your handling code here:
        new PrintReport().print("InventoryTransaction.jasper");
    }//GEN-LAST:event_btPrintActionPerformed

    private void initializeData() {
        stockInOutController = Guice.createInjector(new Injection()).getInstance(StockInOutController.class);
        allTransactions = stockInOutController.findStockInOuts();
        filteredTransactions = allTransactions;
        fetchAllTransactions();
    }

    private void fetchAllTransactions() {
        String[] headers = { "Kode Barang", "Nama Barang", "Jumlah", "Keterangan", "Tanggal", "Catatan", "Aksi" };
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, headers);
        tableTransaksi.setModel(defaultTableModel);

        for (StockInOutResponseVm filteredTransaction : filteredTransactions) {
            String keterangan = filteredTransaction.getStatus() ? "Barang Masuk" : "Barang Keluar";
            String[] values = { filteredTransaction.getInventoryCode(), filteredTransaction.getInventoryName(),
                    filteredTransaction.getAmount().toString(), keterangan, ChangeDateFormat.dateToString("dd-MMM-yyyy", filteredTransaction.getDate()), filteredTransaction.getNote()
            };
            defaultTableModel.addRow(values);
        }
        
        TableActionDelete event = new TableActionDelete() {
            @Override
            public void onDelete(int row) {
                if (tableTransaksi.isEditing()) {
                    tableTransaksi.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) tableTransaksi.getModel();
                StockInOutResponseVm stock = filteredTransactions.get(row);
                int confirmDelete = ConfirmationDialog.deleteConfirmation("Data yang dihapus tidak dapat dikembalikan. Anda yakin ? ", "Konfirmasi Hapus Data Transaksi Barang");
                if (confirmDelete == JOptionPane.YES_NO_OPTION) {
                    model.removeRow(row);
                    stockInOutController.deleteStockInOut(stock.getId());
                }
            }

        };

        tableTransaksi.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRenderDelete());
        tableTransaksi.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditorDelete(event));
        
        // Set horizontal alignment for columns 0 to 3
        for (int i = 0; i < tableTransaksi.getColumnCount() - 1; i++) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        tableTransaksi.getColumnModel().getColumn(i).setCellRenderer(renderer);
    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPrint;
    private javax.swing.JButton btTransaksi;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableTransaksi;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables
}
