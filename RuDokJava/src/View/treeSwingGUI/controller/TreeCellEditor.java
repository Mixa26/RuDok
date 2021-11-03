package View.treeSwingGUI.controller;

import View.MainView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class TreeCellEditor extends DefaultTreeCellEditor{

    private Object object = null;
    private JTextField text = null;

    public TreeCellEditor(JTree tree, DefaultTreeCellRenderer dtcr)
    {
        super(tree, dtcr);
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {

        object = value;

        text = new JTextField(value.toString());
        text.addActionListener(MainView.getIntance().getActionManager().getRenameInTreeAction());
        return text;
    }

    @Override
    public boolean isCellEditable(EventObject event) {
        if (event instanceof MouseEvent)
        {
            if (((MouseEvent)event).getClickCount() == 3)
            {
                return true;
            }
        }
        return false;
    }
}
