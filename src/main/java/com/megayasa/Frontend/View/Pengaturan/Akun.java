package com.megayasa.Frontend.View.Pengaturan;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.AccountController;
import com.megayasa.Backend.Dialogs.ConfirmationDialog;
import com.megayasa.Backend.Helpers.ChangeDateFormat;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.Utils.PrintReport;
import com.megayasa.Backend.ViewModels.Responses.AccountResponseVm;
import com.megayasa.Frontend.Asset.Table.TableActionCellEditor;
import com.megayasa.Frontend.Asset.Table.TableActionCellRender;
import com.megayasa.Frontend.Asset.Table.TableActionEvent;
import com.megayasa.Frontend.Asset.components.SimpleForm;
import java.awt.Component;
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
public class Akun extends SimpleForm {

    private AccountController accountController;
    private List<AccountResponseVm> allAccounts;
    private List<AccountResponseVm> filteredAccounts;

    public Akun() {
        initComponents();
        applyTableStyle(tableAkun);
        initializeData();
    }

    private void applyTableStyle(JTable table) {

        btPrint.setIcon(new FlatSVGIcon("iconSVG/print.svg", 0.35f));
        btAdd.setIcon(new FlatSVGIcon("iconSVG/add.svg", 0.35f));

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
        tableAkun = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        jLabel1.setText("Kontrol Akun");

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

        tableAkun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama Lengkap", "Email", "Nomor Ponsel", "Username", "Password", "Role", "Karyawan ", "Status", "Action"
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
        tableAkun.setRowHeight(35);
        jScrollPane1.setViewportView(tableAkun);

        crazyPanel1.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 501, Short.MAX_VALUE))
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
                    .addGap(0, 50, Short.MAX_VALUE)
                    .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearchKeyTyped
        // TODO add your handling code here:
        String search = txSearch.getText().toLowerCase();
        filteredAccounts = allAccounts.stream().filter(a -> a.getFullName().toLowerCase().contains(search) ||
                a.getUsername().toLowerCase().contains(search) || a.getEmail().toLowerCase().contains(search)).toList();
        fetchAccounts();
    }//GEN-LAST:event_txSearchKeyTyped

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        tambahAkun a = new tambahAkun();
        a.setVisible(true);
    }//GEN-LAST:event_btAddActionPerformed

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintActionPerformed
        // TODO add your handling code here:
        new PrintReport().print("Account.jasper");
    }//GEN-LAST:event_btPrintActionPerformed

    private void initializeData() {
        Locale local = new Locale("id", "ID");
        Locale.setDefault(local);
        accountController = Guice.createInjector(new Injection()).getInstance(AccountController.class);
        allAccounts = accountController.getAllAccounts();
        filteredAccounts = allAccounts;
        fetchAccounts();
    }

    private void fetchAccounts() {
        String[] headers = { "Nama Lengkap", "Username", "Email", "Role", "Id Karyawan", "Terakhir Login", "Status Akun", "Aksi" };
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, headers);
        tableAkun.setModel(defaultTableModel);

        for (AccountResponseVm filteredAccount : filteredAccounts) {
            String lastLogin = filteredAccount.getLastLogin() == null ? "-" : ChangeDateFormat.localDateToString("dd-MMM-yyyy HH:mm:ss", filteredAccount.getLastLogin());
            String employeeId = filteredAccount.getEmployee() != null ? filteredAccount.getEmployee().getId() : "-";
            String[] values = { filteredAccount.getFullName(), filteredAccount.getUsername(), filteredAccount.getEmail(),
                    filteredAccount.getRole().getName(), employeeId, lastLogin
                    , filteredAccount.getIsActive() ? "Aktif" : "Tidak Aktif"
            };
            defaultTableModel.addRow(values);
        }

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                AccountResponseVm accountResponseVm = filteredAccounts.get(row);
                tambahAkun a = new tambahAkun(accountResponseVm.getId());
                a.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (tableAkun.isEditing()) {
                    tableAkun.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) tableAkun.getModel();
                AccountResponseVm accountResponseVm = filteredAccounts.get(row);
                int confirm = ConfirmationDialog.deleteConfirmation("Data yang sudah dihapus tidak dapat dikembalikan. Anda yakin ?", "Konfirmasi hapus akun");
                if (confirm == JOptionPane.YES_NO_OPTION) {
                    accountController.deleteAccount(accountResponseVm.getId());
                    model.removeRow(row);
                }
            }
        };

        tableAkun.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        tableAkun.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btPrint;
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAkun;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables
}
