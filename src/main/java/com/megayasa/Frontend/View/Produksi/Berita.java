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
public class Berita extends SimpleForm {

    public Berita() {
        initComponents();
//        applyTableStyle(tableBarang);
    }
   
    private void applyTableStyle(JTable table) {

//        btAdd.setIcon(new FlatSVGIcon("iconSVG/add.svg", 0.35f));
//        btPrint.setIcon(new FlatSVGIcon("iconSVG/print.svg", 0.35f));
//
//        txSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, new FlatSVGIcon("iconSVG/search.svg", 0.35f));
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

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        jLabel1.setText("Berita");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 620, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(632, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
