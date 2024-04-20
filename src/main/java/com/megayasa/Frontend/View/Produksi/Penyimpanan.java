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
public class Penyimpanan extends SimpleForm {

    public Penyimpanan() {
        initComponents();
        applyTableStyle(tableBarang);
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
    }//GEN-LAST:event_txSearchKeyTyped

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        tambahBarang a = new tambahBarang();
        a.setVisible(true);
    }//GEN-LAST:event_btAddActionPerformed

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
