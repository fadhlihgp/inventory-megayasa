package com.megayasa.Frontend.View.Produksi;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.megayasa.Frontend.View.Asset.components.SimpleForm;
import com.megayasa.Frontend.View.Personalia.laporAbsensi;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Ridho Multazam
 */
public class Transaksi extends SimpleForm {

    public Transaksi() {
        initComponents();
        applyTableStyle(tableTransaksi);
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
        crazyPanel3 = new raven.crazypanel.CrazyPanel();
        crazyPanel4 = new raven.crazypanel.CrazyPanel();
        txSearch = new javax.swing.JTextField();
        btTransaksi = new javax.swing.JButton();
        btPrint = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        jLabel2.setText("Riwayat Transaksi");

        crazyPanel3.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background;[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20",
            null
        ));
        crazyPanel3.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap,fill,insets 15",
            "[fill]",
            "[grow 0][fill]",
            null
        ));

        crazyPanel4.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "background:$Table.background",
            new String[]{
                "JTextField.placeholderText=Search;background:@background",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1",
                "background:lighten(@background,8%);borderWidth:1"
            }
        ));
        crazyPanel4.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
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
        crazyPanel4.add(txSearch);

        btTransaksi.setText("Transaksi");
        btTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTransaksiActionPerformed(evt);
            }
        });
        crazyPanel4.add(btTransaksi);

        btPrint.setText("Print");
        crazyPanel4.add(btPrint);

        crazyPanel3.add(crazyPanel4);

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Barang", "Jumlah", "Tanggal", "Keterangan", "Catatan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableTransaksi);

        crazyPanel3.add(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(crazyPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crazyPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txSearchKeyTyped

    private void btTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTransaksiActionPerformed
        // TODO add your handling code here:
        transaksiBarang a = new transaksiBarang();
        a.setVisible(true);
    }//GEN-LAST:event_btTransaksiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPrint;
    private javax.swing.JButton btTransaksi;
    private raven.crazypanel.CrazyPanel crazyPanel3;
    private raven.crazypanel.CrazyPanel crazyPanel4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableTransaksi;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables
}
