package View.treeSwingGUI.view;

import View.treeSwingGUI.controller.MyMouseListener;
import View.treeSwingGUI.controller.TreeCellController;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

public class MyTree extends JTree {

    public MyTree()
    {
        addTreeSelectionListener(new TreeCellController());
        setCellEditor(new TreeCellEditor(this, new DefaultTreeCellRenderer()));
        setCellRenderer(new TreeCellRendered());
        setEditable(true);
        this.addMouseListener(new MyMouseListener());
    }

    public void refresh()
    {
        SwingUtilities.updateComponentTreeUI(this);
    }
}
