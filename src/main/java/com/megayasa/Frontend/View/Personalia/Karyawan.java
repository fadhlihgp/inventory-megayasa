package com.megayasa.Frontend.View.Personalia;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.EmployeeController;
import com.megayasa.Backend.Dialogs.ConfirmationDialog;
import com.megayasa.Backend.Helpers.ChangeDateFormat;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.Utils.PrintReport;
import com.megayasa.Backend.ViewModels.Requests.EmployeeRequestVm;
import com.megayasa.Backend.ViewModels.Responses.EmployeeResponseVm;
import com.megayasa.Frontend.Asset.Table.TableActionCellEditor;
import com.megayasa.Frontend.Asset.Table.TableActionCellRender;
import com.megayasa.Frontend.Asset.Table.TableActionEvent;
import com.megayasa.Frontend.Asset.components.SimpleForm;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ridho Multazam
 */
public class Karyawan extends SimpleForm {

    private EmployeeController employeeController;
    private List<EmployeeResponseVm> allEmployees;
    private List<EmployeeResponseVm> employeeFilters;

    public Karyawan() {
        initComponents();
        initializeData();
        applyTableStyle(tableKaryawan);
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
            @Override
            public void actionPerformed(ActionEvent e) {
                btPrintActionPerformed(e);
            }
        });
        crazyPanel2.add(btPrint);

        crazyPanel1.add(crazyPanel2);

        tableKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
                .addComponent(crazyPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(627, 627, 627))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(59, Short.MAX_VALUE)
                    .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initializeData() {
        Locale local = new Locale("id", "ID");
        Locale.setDefault(local);
        employeeController = Guice.createInjector(new Injection()).getInstance(EmployeeController.class);
        allEmployees = employeeController.findAllEmployees();
        employeeFilters = allEmployees;
        fetchAllEmployees();
    }

    private void fetchAllEmployees() {
        String[] headers = {"Id", "Posisi", "Nama Lengkap", "Tanggal Lahir", "Alamat", "Jenis Kelamin", "No Telp", "NIK", "Aksi"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, headers);
        tableKaryawan.setModel(defaultTableModel);

        for (EmployeeResponseVm employeeFilter : employeeFilters) {
            String[] values = { employeeFilter.getId(), employeeFilter.getPosition(), employeeFilter.getFullName(),
                    ChangeDateFormat.dateToString("dd-MMM-yyyy", employeeFilter.getBirthDate()), employeeFilter.getAddress(),
                    employeeFilter.getGender(), employeeFilter.getPhoneNumber(), employeeFilter.getIdentityNumber()
            };
            defaultTableModel.addRow(values);
        }

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                EmployeeResponseVm empResponse = employeeFilters.get(row);
                EmployeeRequestVm employeeRequestVm = new EmployeeRequestVm(empResponse.getId(), empResponse.getIdentityNumber(),
                        empResponse.getFullName(), new Date(empResponse.getBirthDate().getTime()), empResponse.getAddress(), empResponse.getGender(),
                        empResponse.getPhoneNumber(), empResponse.getPositionId(), empResponse.isActive());

                editKaryawan a = new editKaryawan(employeeRequestVm);
                a.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (tableKaryawan.isEditing()) {
                    tableKaryawan.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) tableKaryawan.getModel();
                EmployeeResponseVm empResponse = employeeFilters.get(row);
                int confirmDelete = ConfirmationDialog.deleteConfirmation("Yakin ingin menghapus data " + empResponse.getFullName() + " ?", "Konfirmasi Hapus Data Karyawan");
                if (confirmDelete == JOptionPane.YES_NO_OPTION) {
                    model.removeRow(row);
                    employeeController.deleteEmployee(empResponse.getId());
                }
            }

        };

        tableKaryawan.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
        tableKaryawan.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(event));
        
        // Set horizontal alignment
        for (int i = 0; i < tableKaryawan.getColumnCount() - 1; i++) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        tableKaryawan.getColumnModel().getColumn(i).setCellRenderer(renderer);
    }
    }

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        tambahKaryawan a = new tambahKaryawan();
        a.setVisible(true);
    }                                     

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        new PrintReport().print("Employee.jasper");
    }//GEN-LAST:event_btAddActionPerformed

    private void txSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearchKeyTyped
        // TODO add your handling code here:
        String search = txSearch.getText().toLowerCase();
        employeeFilters = allEmployees.stream().filter(e -> e.getFullName().toLowerCase().contains(search)
                || e.getId().toLowerCase().contains(search)).toList();
        fetchAllEmployees();
    }//GEN-LAST:event_txSearchKeyTyped

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
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btPrint;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableKaryawan;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables
}
