package com.megayasa.Frontend.Asset.forms;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.google.inject.Guice;
import com.megayasa.Backend.Controllers.DashboardController;
import com.megayasa.Backend.Utils.Injection;
import com.megayasa.Backend.ViewModels.Responses.AbsenceDashboardResponseVm;
import com.megayasa.Backend.ViewModels.Responses.DashboardResponseVm;
import com.megayasa.Backend.ViewModels.Responses.StockInOutDashboardResponseVm;
import com.megayasa.Frontend.Asset.components.SimpleForm;
import com.megayasa.Frontend.Asset.utils.DateCalculator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import raven.chart.ChartLegendRenderer;
import raven.chart.bar.HorizontalBarChart;
import raven.chart.data.category.DefaultCategoryDataset;
import raven.chart.data.pie.DefaultPieDataset;
import raven.chart.line.LineChart;

/**
 *
 * @author Ridho Multazam
 */
public class Dashboard extends SimpleForm {
    private final DashboardResponseVm dashboardResponseVm;

    public Dashboard() {
        DashboardController dashboardController = Guice.createInjector(new Injection()).getInstance(DashboardController.class);
        dashboardResponseVm = dashboardController.getDashboard();
        initComponents();
        jLabel3.setText(Integer.toString(dashboardResponseVm.getEmployeeTotal()));
        jLabel6.setText(Integer.toString(dashboardResponseVm.getTransactionTotal()));
        jLabel9.setText(Integer.toString(dashboardResponseVm.getIncidentTotal()));
        dsKaryawan.setIcon(new FlatSVGIcon("iconSVG/employee.svg", 0.90f));
        dsTransaksi.setIcon(new FlatSVGIcon("iconSVG/right-left.svg", 0.90f));
        dsBerita.setIcon(new FlatSVGIcon("iconSVG/alert.svg", 0.90f));
        dsAbsensi.setIcon(new FlatSVGIcon("iconSVG/presence.svg", 0.90f));
        crazyPanel7.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20");
        init();
    }

    @Override
    public void formRefresh() {
        lineChart.startAnimation();
        barChart1.startAnimation();
        barChart2.startAnimation();
    }


    @Override
    public void formInitAndOpen() {
        System.out.println("init and open");
    }

    @Override
    public void formOpen() {
        System.out.println("Open");
    }

    private void init() {
        setLayout(new MigLayout("wrap,fill,gap 10", "fill"));
        createLineChart();
        createBarChart();
    }

    private void createLineChart() {
        lineChart = new LineChart();
        lineChart.setChartType(LineChart.ChartType.CURVE);
        lineChart.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20");
        add(lineChart);
        createLineChartData();
    }

    private void createBarChart() {
        // BarChart 1
        barChart1 = new HorizontalBarChart();
        JLabel header1 = new JLabel("Transaksi Barang Masuk");
        header1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+1;"
                + "border:0,0,5,0");
        barChart1.setHeader(header1);
        barChart1.setBarColor(Color.decode("#10b981"));
        barChart1.setDataset(createDataStockIn());
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20");
        panel1.add(barChart1);
        add(panel1, "split 2,gap 0 20");

        // BarChart 2
        barChart2 = new HorizontalBarChart();
        JLabel header2 = new JLabel("Transaksi Barang Keluar");
        header2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+1;"
                + "border:0,0,5,0");
        barChart2.setHeader(header2);
        barChart2.setBarColor(Color.decode("#C40C0C"));
        barChart2.setDataset(createDataStockOut());
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20");
        panel2.add(barChart2);
        add(panel2);
    }

    private DefaultPieDataset createDataStockIn() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        for (StockInOutDashboardResponseVm transaction : dashboardResponseVm.getTransactions()) {
            dataset.addValue(sdf.format(transaction.getDate()), transaction.getStockIn());
        }
        return dataset;
    }

    private DefaultPieDataset createDataStockOut() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        for (StockInOutDashboardResponseVm transaction : dashboardResponseVm.getTransactions()) {
            dataset.addValue(sdf.format(transaction.getDate()), transaction.getStockOut());
        }
        return dataset;
    }

    private void createLineChartData() {
        DefaultCategoryDataset<String, String> categoryDataset = new DefaultCategoryDataset<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
        Random ran = new Random();
        int randomDate = 30;
        for (AbsenceDashboardResponseVm absence : dashboardResponseVm.getAbsences()) {
            String date = df.format(absence.getDate());
            categoryDataset.addValue(absence.getPresent(), "Hadir", date);
            categoryDataset.addValue(absence.getPermission(), "Izin", date);
            categoryDataset.addValue(absence.getSick(), "Sakit", date);
            categoryDataset.addValue(absence.getLeave(), "Cuti", date);
            categoryDataset.addValue(absence.getAlpa(), "Alpa", date);
        }
//        for (int i = 1; i <= randomDate; i++) {
//            String date = df.format(cal.getTime());
//            categoryDataset.addValue(ran.nextInt(700) + 5, "Income", date);
//            categoryDataset.addValue(ran.nextInt(700) + 5, "Expense", date);
//            categoryDataset.addValue(ran.nextInt(700) + 5, "Profit", date);
//
//            cal.add(Calendar.DATE, 1);
//        }

        /**
         * Control the legend we do not show all legend
         */
        try {
            Date date = df.parse(categoryDataset.getColumnKey(0));
            Date dateEnd = df.parse(categoryDataset.getColumnKey(categoryDataset.getColumnCount() - 1));

            DateCalculator dcal = new DateCalculator(date, dateEnd);
            long diff = dcal.getDifferenceDays();

            double d = Math.ceil((diff / 10f));
            lineChart.setLegendRenderer(new ChartLegendRenderer() {
                @Override
                public Component getLegendComponent(Object legend, int index) {
                    if (index % d == 0) {
                        return super.getLegendComponent(legend, index);
                    } else {
                        return null;
                    }
                }
            });
        } catch (ParseException e) {
            System.err.println(e);
        }

        lineChart.setCategoryDataset(categoryDataset);
        lineChart.getChartColor().addColor(Color.decode("#38bdf8"), Color.decode("#fb7185"), Color.decode("#34d399"));
        JLabel header = new JLabel("Data Presensi");
        header.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+1;"
                + "border:0,0,5,0");
        lineChart.setHeader(header);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crazyPanel7 = new raven.crazypanel.CrazyPanel();
        crazyPanel2 = new raven.crazypanel.CrazyPanel();
        dsKaryawan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        crazyPanel9 = new raven.crazypanel.CrazyPanel();
        dsAbsensi = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        crazyPanel4 = new raven.crazypanel.CrazyPanel();
        dsTransaksi = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        crazyPanel6 = new raven.crazypanel.CrazyPanel();
        dsBerita = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        crazyPanel7.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "arc:20;[light]background:shade(@background,2%);[dark]background:tint(@background,2%);[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20",
            null
        ));
        crazyPanel7.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "fill",
            "[fill,200]",
            "[fill]",
            null
        ));

        crazyPanel2.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "arc:20;[light]background:lighten(@background,3%);[dark]background:darken(@background,3%)",
            new String[]{
                "",
                "[light]foreground:tint(@foreground,50%);[dark]foreground:shade(@foreground,50%)",
                "font:bold +3"
            }
        ));
        crazyPanel2.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "inset s 10 10 10 15",
            "[]20 push[trail]",
            "[]0[]",
            new String[]{
                "span 1 2",
                "wrap",
                "ay top"
            }
        ));
        crazyPanel2.add(dsKaryawan);

        jLabel2.setText("Junlah Karyawan");
        crazyPanel2.add(jLabel2);

        jLabel3.setText("900");
        crazyPanel2.add(jLabel3);

        crazyPanel7.add(crazyPanel2);

        crazyPanel9.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "arc:20;[light]background:lighten(@background,3%);[dark]background:darken(@background,3%)",
            new String[]{
                "",
                "[light]foreground:tint(@foreground,50%);[dark]foreground:shade(@foreground,50%)",
                "font:bold +3"
            }
        ));
        crazyPanel9.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "inset s 10 10 10 15",
            "[]20 push[trail]",
            "[]0[]",
            new String[]{
                "span 1 2",
                "wrap",
                "ay top"
            }
        ));
        crazyPanel9.add(dsAbsensi);

        jLabel4.setText("Kehadiran");
        crazyPanel9.add(jLabel4);

        jLabel7.setText("900");
        crazyPanel9.add(jLabel7);

        crazyPanel7.add(crazyPanel9);

        crazyPanel4.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "arc:20;[light]background:lighten(@background,3%);[dark]background:darken(@background,3%)",
            new String[]{
                "",
                "[light]foreground:tint(@foreground,50%);[dark]foreground:shade(@foreground,50%)",
                "font:bold +3"
            }
        ));
        crazyPanel4.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "inset s 10 10 10 15",
            "[]20 push[trail]",
            "[]0[]",
            new String[]{
                "span 1 2",
                "wrap",
                "ay top"
            }
        ));
        crazyPanel4.add(dsTransaksi);

        jLabel5.setText("Transaksi Bulan Ini");
        crazyPanel4.add(jLabel5);

        jLabel6.setText("900");
        crazyPanel4.add(jLabel6);

        crazyPanel7.add(crazyPanel4);

        crazyPanel6.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "arc:20;[light]background:lighten(@background,3%);[dark]background:darken(@background,3%)",
            new String[]{
                "",
                "[light]foreground:tint(@foreground,50%);[dark]foreground:shade(@foreground,50%)",
                "font:bold +3"
            }
        ));
        crazyPanel6.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "inset s 10 10 10 15",
            "[]20 push[trail]",
            "[]0[]",
            new String[]{
                "span 1 2",
                "wrap",
                "ay top"
            }
        ));
        crazyPanel6.add(dsBerita);

        jLabel8.setText("Berita Acara");
        crazyPanel6.add(jLabel8);

        jLabel9.setText("900");
        crazyPanel6.add(jLabel9);

        crazyPanel7.add(crazyPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crazyPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(crazyPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(599, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private LineChart lineChart;
    private HorizontalBarChart barChart1;
    private HorizontalBarChart barChart2;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.crazypanel.CrazyPanel crazyPanel2;
    private raven.crazypanel.CrazyPanel crazyPanel4;
    private raven.crazypanel.CrazyPanel crazyPanel6;
    private raven.crazypanel.CrazyPanel crazyPanel7;
    private raven.crazypanel.CrazyPanel crazyPanel9;
    private javax.swing.JLabel dsAbsensi;
    private javax.swing.JLabel dsBerita;
    private javax.swing.JLabel dsKaryawan;
    private javax.swing.JLabel dsTransaksi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
