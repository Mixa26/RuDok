package View.treeSwingGUI.controller;

import Model.treeModel.Slide;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class TreeCellController implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();

        for (int i = 0; i < path.getPathCount(); i++)
        {
            if (path.getPathComponent(i) instanceof Slide selectedSlide)
            {
                System.out.println("Selected slide: " + selectedSlide);
            }
        }
    }
}
