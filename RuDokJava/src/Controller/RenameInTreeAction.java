package Controller;

import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.Slide;
import Model.treeModel.WorkSpace;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RenameInTreeAction extends AbstractRudokAction{
    private final Object objectInTree;

    public RenameInTreeAction(Object objectInTree)
    {
        this.objectInTree = objectInTree;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ((MyTreeNode)objectInTree).getNode().setName(e.getActionCommand());
    }
}
