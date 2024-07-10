package com.megayasa.Frontend.Asset.Table;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ridho Multazam
 */
public class TableActionCellRenderDelete extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
//        setHorizontalAlignment(SwingConstants.CENTER);
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        PanelDelete action = new PanelDelete();
        if (isSeleted == false && row % 2 == 0) {
            action.setBackground(com.getBackground());
        } else {
            action.setBackground(com.getBackground());
        }
        return action;
    }
}
