package com.megayasa.Frontend.Asset.Table;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Ridho Multazam
 */
public class TableActionCellEditorDelete extends DefaultCellEditor {

    private TableActionDelete event;

    public TableActionCellEditorDelete(TableActionDelete event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelDelete action = new PanelDelete();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
