package View.treeSwingGUI.view;

import View.treeSwingGUI.controller.TreeCellController;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyTree extends JTree {

    public MyTree()
    {
        addTreeSelectionListener(new TreeCellController());
        setCellEditor(new TreeCellEditor(this, new DefaultTreeCellRenderer()));
        setCellRenderer(new TreeCellRendered());
        setEditable(true);
    }

    public void refresh()
    {
        SwingUtilities.updateComponentTreeUI(this);
    }
}
