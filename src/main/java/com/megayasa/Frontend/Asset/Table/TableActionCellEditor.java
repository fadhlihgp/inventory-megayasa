package com.megayasa.Frontend.Asset.Table;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Ridho Multazam
 */
public class TableActionCellEditor extends DefaultCellEditor {

    private TableActionEvent event;
//    private TableActionDelete delete;
    
//    public TableActionCellEditor(TableActionDelete event) {
//        super(new JCheckBox());
//        this.delete = event;
//    }

    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

//    @Override
//    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
//        PanelDelete action = new PanelDelete();
//        action.initEvent(, row);
//        action.setBackground(jtable.getSelectionBackground());
//        return action;
//    }
//    
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelAction action = new PanelAction();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
