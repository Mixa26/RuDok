package View.treeSwingGUI.controller;

import Model.treeModel.Project;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    public MyMouseListener() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2)
        {
            if (MainView.getIntance().getMyTree().getSelectionPath() == null)
            {
                return;
            }

            if (((MyTreeNode) MainView.getIntance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Project project)
            {
                MainView.getIntance().getRightWorkArea().openProject(project);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
