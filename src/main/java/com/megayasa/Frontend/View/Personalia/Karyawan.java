package com.megayasa.Frontend.View.Personalia;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.megayasa.Frontend.View.Asset.Table.TableActionCellEditor;
import com.megayasa.Frontend.View.Asset.Table.TableActionCellRender;
import com.megayasa.Frontend.View.Asset.Table.TableActionEvent;
import com.megayasa.Frontend.View.Asset.components.SimpleForm;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ridho Multazam
 */
public class Karyawan extends SimpleForm {

    public Karyawan() {
        initComponents();
        applyTableStyle(tableKaryawan);
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
            }

            @Override
            public void onDelete(int row) {
                if (tableKaryawan.isEditing()) {
                    tableKaryawan.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) tableKaryawan.getModel();
                model.removeRow(row);
            }

        };
              
        tableKaryawan.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
        tableKaryawan.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(event));
        tableKaryawan.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
    }
    
    private void applyTableStyle(JTable table) {

        cmdAdd.setIcon(new FlatSVGIcon("iconSVG/add.svg", 0.35f));
        cmdPrint.setIcon(new FlatSVGIcon("iconSVG/print.svg", 0.35f));

        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, new FlatSVGIcon("iconSVG/search.svg", 0.35f));
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
        txtSearch = new javax.swing.JTextField();
        cmdAdd = new javax.swing.JButton();
        cmdPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKaryawan = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        jLabel1.setText("Karyawan");

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

        txtSearch.setText("Cari");
        crazyPanel2.add(txtSearch);

        cmdAdd.setText("Tambah");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });
        crazyPanel2.add(cmdAdd);

        cmdPrint.setText("Print");
        crazyPanel2.add(cmdPrint);

        crazyPanel1.add(crazyPanel2);

        tableKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Id Posisi", "Nama Lengkap", "Tanggal Lahir", "Alamat", "Jenis Kelamin", "No Telp", "NIK", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKaryawan.setRowHeight(35);
        jScrollPane1.setViewportView(tableKaryawan);

        crazyPanel1.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(484, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(627, 627, 627))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(54, Short.MAX_VALUE)
                    .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        // TODO add your handling code here:
        tambahKaryawan a = new tambahKaryawan();
        a.setVisible(true);
    }//GEN-LAST:event_cmdAddActionPerformed

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("tableView");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new Karyawan().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdPrint;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableKaryawan;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
