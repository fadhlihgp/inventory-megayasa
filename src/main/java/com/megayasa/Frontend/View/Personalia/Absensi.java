package com.megayasa.Frontend.View.Personalia;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.AbsenceController;
import com.megayasa.Backend.Dialogs.ConfirmationDialog;
import com.megayasa.Backend.Helpers.ChangeDateFormat;
import com.megayasa.Backend.Models.Absence;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.ViewModels.Requests.EmployeeRequestVm;
import com.megayasa.Backend.ViewModels.Responses.AbsenceDetailResponseVm;
import com.megayasa.Backend.ViewModels.Responses.EmployeeResponseVm;
import com.megayasa.Frontend.View.Asset.Table.TableActionCellEditor;
import com.megayasa.Frontend.View.Asset.Table.TableActionCellRender;
import com.megayasa.Frontend.View.Asset.Table.TableActionEvent;
import com.megayasa.Frontend.View.Asset.components.SimpleForm;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Ridho Multazam
 */
public class Absensi extends SimpleForm {
    private AbsenceController absenceController;
    private List<AbsenceDetailResponseVm> allAbsences;
    private List<AbsenceDetailResponseVm> filteredAbsences;

    /**
     * Creates new form ReadForm
     */
    public Absensi() {
        initComponents();
        initializeData();
        applyTableStyle(tableAbsensi);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        tableAbsensi = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        jLabel1.setText("Absensi");

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

        tableAbsensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Karyawan", "Tanggal", "Alasan", "Catatan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAbsensi.setRowHeight(35);
        jScrollPane1.setViewportView(tableAbsensi);

        crazyPanel1.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 609, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 632, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(59, Short.MAX_VALUE)
                    .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearchKeyTyped
        // TODO add your handling code here:
        String search = txSearch.getText().toLowerCase();
        filteredAbsences = allAbsences.stream().filter(a -> a.getEmployeeName().toLowerCase().contains(search)).toList();
        fetchAllAbsences();
    }//GEN-LAST:event_txSearchKeyTyped

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        laporAbsensi a = new laporAbsensi();
        a.setVisible(true);
    }//GEN-LAST:event_btAddActionPerformed

    private void initializeData() {
        absenceController = Guice.createInjector(new Injection()).getInstance(AbsenceController.class);
        allAbsences = absenceController.absenceDetailList();
        filteredAbsences = allAbsences;
        fetchAllAbsences();
    }

    private void fetchAllAbsences() {
        String[] headers = { "Karyawan", "Tanggal", "Alasan", "Catatan", "Aksi" };
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, headers);
        tableAbsensi.setModel(defaultTableModel);

        for (AbsenceDetailResponseVm filteredAbsence : filteredAbsences) {
            String[] values = { filteredAbsence.getEmployeeName(), ChangeDateFormat.dateToString("dd MMM yyyy", filteredAbsence.getDate()),
                    filteredAbsence.getInformation(), filteredAbsence.getNote()
            };
            defaultTableModel.addRow(values);
        }

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                AbsenceDetailResponseVm absenceDetailResponseVm = filteredAbsences.get(row);
               laporAbsensi l = new laporAbsensi(absenceDetailResponseVm);
               l.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (tableAbsensi.isEditing()) {
                    tableAbsensi.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) tableAbsensi.getModel();
                AbsenceDetailResponseVm absenceDet = filteredAbsences.get(row);
                int confirmDelete = ConfirmationDialog.deleteConfirmation("Data yang dihapus tidak dapat dikembalikan. Anda yakin ?", "Konfirmasi Hapus Data Absensi");
                if (confirmDelete == JOptionPane.YES_NO_OPTION) {
                    model.removeRow(row);
                    absenceController.deleteAbsence(absenceDet.getId());
                }
            }

        };

        tableAbsensi.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        tableAbsensi.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btPrint;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAbsensi;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables
}
