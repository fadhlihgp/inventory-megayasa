package com.megayasa.Backend.Utils;

import com.google.inject.Inject;
import com.megayasa.Backend.Context.AppDbContext;
import com.megayasa.Backend.Exceptions.ErrorException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.HashMap;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class PrintReport {

    private final Connection connection;

    public PrintReport() {
        this.connection = new AppDbContext().getConnection();
    }

    public void print(String fileName) {
        try {
            String filePath = DataProperties.REPORT_FOLDER + fileName;
            JasperPrint jasperPrint = JasperFillManager.fillReport(filePath, null, connection);
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

    public void print(String fileName, HashMap parameters) {
        try {
            String filePath = DataProperties.REPORT_FOLDER + fileName;
            JasperPrint jasperPrint = JasperFillManager.fillReport(filePath, parameters, connection);
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }
}
