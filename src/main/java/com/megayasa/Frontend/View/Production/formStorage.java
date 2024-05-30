package com.megayasa.Frontend.View.Production;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.InventoryController;
import com.megayasa.Backend.Dialogs.ConfirmationDialog;
import com.megayasa.Backend.Models.Inventory;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.Utils.PrintReport;
import com.megayasa.Frontend.Asset.Table.TableActionCellEditor;
import com.megayasa.Frontend.Asset.Table.TableActionCellRender;
import com.megayasa.Frontend.Asset.Table.TableActionEvent;
import com.megayasa.Frontend.Asset.components.SimpleForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ridho Multazam
 */
public class Penyimpanan extends SimpleForm {

    private InventoryController inventoryController;
    private List<Inventory> allInventories;
    private List<Inventory> filteredInventories;

    public Penyimpanan() {
        initComponents();
        applyTableStyle(tableBarang);
        initializeData();
    }

    private void applyTableStyle(JTable table) {

        btAdd.setIcon(new FlatSVGIcon("iconSVG/add.svg", 0.35f));
        btPrint.setIcon(new FlatSVGIcon("iconSVG/print.svg", 0.35f));

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

        jLabel1 = new javax.swing.JLabel();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        txSearch = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        jLabel1.setText("Gudang Barang");

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

        btAdd.setText("Tambah");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });
        crazyPanel2.add(btAdd);

        btPrint.setText("Print");
        btPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintActionPerformed(evt);
            }
        });
        crazyPanel2.add(btPrint);

        crazyPanel1.add(crazyPanel2);

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Stock", "Tipe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBarang.setRowHeight(35);
        jScrollPane1.setViewportView(tableBarang);

        crazyPanel1.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 469, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearchKeyTyped
        // TODO add your handling code here:
        String search = txSearch.getText();
        filteredInventories = allInventories.stream().filter(i -> i.getCode().toLowerCase().contains(search) ||
                i.getName().toLowerCase().contains(search)).toList();
        fetchAllInventories();
    }//GEN-LAST:event_txSearchKeyTyped

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        tambahBarang a = new tambahBarang();
        a.setVisible(true);
    }//GEN-LAST:event_btAddActionPerformed

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintActionPerformed
        // TODO add your handling code here:
        new PrintReport().print("Inventory.jasper");
    }//GEN-LAST:event_btPrintActionPerformed

    private void initializeData() {
        inventoryController = Guice.createInjector(new Injection()).getInstance(InventoryController.class);
        allInventories = inventoryController.findAllInventories();
        filteredInventories = allInventories;
        fetchAllInventories();
    }

    private void fetchAllInventories() {
        String[] headers = {"Kode", "Nama", "Stok", "Tipe", "Aksi"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, headers);
        tableBarang.setModel(defaultTableModel);

        for (Inventory inventory : filteredInventories) {
            String[] values = { inventory.getCode(), inventory.getName(), inventory.getStock().toString(), inventory.getType() };
            defaultTableModel.addRow(values);
        }

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                Inventory inventory = filteredInventories.get(row);
                tambahBarang t = new tambahBarang(inventory.getCode());
                t.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (tableBarang.isEditing()) {
                    tableBarang.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) tableBarang.getModel();
                Inventory empResponse = filteredInventories.get(row);
                int confirmDelete = ConfirmationDialog.deleteConfirmation("Data yang dihapus tidak dapat dikembalikan. Anda yakin ? ", "Konfirmasi Hapus Data Barang");
                if (confirmDelete == JOptionPane.YES_NO_OPTION) {
                    model.removeRow(row);
                    inventoryController.deleteInventoryByIdOrCode(empResponse.getId());
                }
            }

        };

        tableBarang.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        tableBarang.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        
        // Set horizontal alignment
        for (int i = 0; i < tableBarang.getColumnCount() - 1; i++) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        tableBarang.getColumnModel().getColumn(i).setCellRenderer(renderer);
    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btPrint;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBarang;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables
}
