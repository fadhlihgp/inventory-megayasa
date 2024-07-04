package com.megayasa.Backend.Utils;

import com.megayasa.Backend.Context.AppDbContext;
import com.megayasa.Backend.Exceptions.ErrorException;
import com.megayasa.Backend.Helpers.DataProperties;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class PrintReport {

    private final Connection connection;

    public PrintReport() {
        this.connection = new AppDbContext().getConnection();
    }

    public void print(String fileName) {
        try {
            String filePath = "/Reports/" + fileName;
            InputStream inputStream = getClass().getResourceAsStream(filePath);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("IMAGE_DIR", getClass().getResource("/icon/").toString());

            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, connection);
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }

//    public void print(String fileName) {
//        try {
//            String filePath = DataProperties.REPORT_FOLDER + fileName;
//            // Load the .jasper file from classpath
//            InputStream inputStream = getClass().getResourceAsStream("");
//
//            // Fill the report using the inputStream
//            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, null, connection);
//
//            // Create a viewer for the JasperPrint
//            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
//            jviewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            jviewer.setVisible(true);
//        } catch (Exception e) {
//            throw new ErrorException(e.getMessage());
//        }
//    }

    public void print(String fileName, HashMap parameters) {
        try {
            String filePath = DataProperties.REPORT_FOLDER + fileName;
            InputStream inputStream = new FileInputStream(filePath);
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, connection);
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }
}
