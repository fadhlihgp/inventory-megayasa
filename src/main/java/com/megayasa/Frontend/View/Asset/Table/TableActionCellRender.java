package com.megayasa.Frontend.View.Asset.Table;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ridho Multazam
 */
public class TableActionCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        PanelAction action = new PanelAction();
        if (isSeleted == false && row % 2 == 0) {
            action.setBackground(com.getBackground());
        } else {
            action.setBackground(com.getBackground());
        }
        return action;
    }
}
