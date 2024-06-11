package com.megayasa.Frontend.View.Production;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.IncidentController;
import com.megayasa.Backend.Dialogs.ConfirmationDialog;
import com.megayasa.Backend.Helpers.ChangeDateFormat;
import com.megayasa.Backend.Models.Incident;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.Utils.PrintReport;
import com.megayasa.Frontend.Asset.Table.TableActionCellEditor;
import com.megayasa.Frontend.Asset.Table.TableActionCellRender;
import com.megayasa.Frontend.Asset.Table.TableActionEvent;
import com.megayasa.Frontend.Asset.components.SimpleForm;
import com.megayasa.Frontend.Asset.menu.FormManager;
import com.megayasa.Frontend.Helpers.ImageRender;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ridho Multazam
 */
public class formIncident extends SimpleForm {

    private IncidentController incidentController;
    private List<Incident> allIncidents;
    private List<Incident> filteredIncidents;
    public formIncident() {
        initComponents();
        applyTableStyle(tableBerita);
        initializeData();
    }

    private void applyTableStyle(JTable table) {

        btAdd.setIcon(new FlatSVGIcon("iconSVG/add.svg", 0.35f));
        btPrint.setIcon(new FlatSVGIcon("iconSVG/print.svg", 0.35f));

        txSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, new FlatSVGIcon("iconSVG/search.svg", 0.35f));
//          Change scroll style
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
        crazyPanel3 = new raven.crazypanel.CrazyPanel();
        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        txSearch = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btPrint = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBerita = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        jLabel1.setText("Berita Kejadian");

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

        crazyPanel3.add(crazyPanel2);

        tableBerita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Judul", "Tanggal", "Detail Kejadian", "Bukti"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableBerita);

        crazyPanel3.add(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 426, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crazyPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(crazyPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearchKeyTyped
        // TODO add your handling code here:
        String search = txSearch.getText().toLowerCase();
        filteredIncidents = allIncidents.stream().filter(s -> s.getTitle().toLowerCase().contains(search)).toList();
        fetchAllIncidents();
    }//GEN-LAST:event_txSearchKeyTyped

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        addIncident a = new addIncident();
        a.setVisible(true);
    }//GEN-LAST:event_btAddActionPerformed

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintActionPerformed
        // TODO add your handling code here:
        new PrintReport().print("Incident.jasper");
    }//GEN-LAST:event_btPrintActionPerformed

    private void initializeData() {
        Locale local = new Locale("id", "ID");
        Locale.setDefault(local);
        incidentController = Guice.createInjector(new Injection()).getInstance(IncidentController.class);
        allIncidents = incidentController.findAllIncidents();
        filteredIncidents = allIncidents;
        fetchAllIncidents();
    }
    private void fetchAllIncidents() {
        String[] headers = { "Tanggal", "Judul", "Catatan", "Foto", "Aksi" };
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, headers) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) { // Kolom "Foto"
                    return ImageIcon.class; // Mengembalikan tipe ImageIcon untuk kolom "Foto"
                }
                return super.getColumnClass(columnIndex);
            }
        };
        tableBerita.setModel(defaultTableModel);
        tableBerita.setRowHeight(50);

        for (Incident filteredIncident : filteredIncidents) {
            Object[] values = {
                    ChangeDateFormat.dateToString("dd-MM-yyyy", filteredIncident.getDate()),
                    filteredIncident.getTitle(),
                    filteredIncident.getDescription(),
                    filteredIncident.getPictureUrl()
            };
            defaultTableModel.addRow(values);
        }

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                Incident incident = filteredIncidents.get(row);
                addIncident t = new addIncident(incident.getId());
                t.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (tableBerita.isEditing()) {
                    tableBerita.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) tableBerita.getModel();
                Incident incident = filteredIncidents.get(row);
                int confirmDelete = ConfirmationDialog.deleteConfirmation("Data yang dihapus tidak dapat dikembalikan. Anda yakin ? ", "Konfirmasi Hapus Data Berita / Insiden");
                if (confirmDelete == JOptionPane.YES_NO_OPTION) {
                    model.removeRow(row);
                    incidentController.deleteIncident(incident.getId());
                    FormManager.showForm(new formIncident());
                }
            }
        };

        tableBerita.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        tableBerita.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        tableBerita.getColumnModel().getColumn(3).setCellRenderer(new ImageRender());

//             Set horizontal alignment for columns
            for (int i = 0; i < tableBerita.getColumnCount() - 1; i++) {
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            if (i == 3) {
                continue;
            } else {
                tableBerita.getColumnModel().getColumn(i).setCellRenderer(renderer);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btPrint;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private raven.crazypanel.CrazyPanel crazyPanel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableBerita;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables
}
