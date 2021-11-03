package View.treeSwingGUI.view;

import View.treeSwingGUI.controller.TreeCellController;
import View.treeSwingGUI.controller.TreeCellEditor;
import View.treeSwingGUI.controller.TreeCellRendered;
import View.treeSwingGUI.model.MyTreeNode;

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
}
