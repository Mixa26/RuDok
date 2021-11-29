package View.treeSwingGUI.view;

import View.treeSwingGUI.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class TreeCellEditor extends DefaultTreeCellEditor implements ActionListener{

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
        text.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (object != null)
        {
            ((MyTreeNode)object).getNode().setName(e.getActionCommand());
        }
    }
}
