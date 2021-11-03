package Controller;

import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.Slide;
import Model.treeModel.WorkSpace;

import java.awt.event.ActionEvent;

public class RenameInTreeAction extends AbstractRudokAction{
    private final Object objectInTree;

    public RenameInTreeAction(Object objectInTree)
    {
        this.objectInTree = objectInTree;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (objectInTree instanceof WorkSpace)
        {
            ((WorkSpace)objectInTree).setName(e.getActionCommand());
        }
        else if (objectInTree instanceof Project)
        {
            ((Project)objectInTree).setName(e.getActionCommand());
        }
        else if (objectInTree instanceof Presentation)
        {
            ((Presentation)objectInTree).setName(e.getActionCommand());
        }
        else
        {
            ((Slide)objectInTree).setName(e.getActionCommand());
        }
    }
}
