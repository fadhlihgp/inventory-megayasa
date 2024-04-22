package com.megayasa.Frontend.Helpers;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ImageRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String photoName = value.toString();
        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(photoName).getImage()
                        .getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        return new JLabel(imageIcon);
    }
}
