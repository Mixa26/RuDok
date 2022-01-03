package Controller.command;

import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.RuNodeComposite;
import View.MainView;

public class DeleteTreeCommand extends AbstractCommand{
    RuNodeComposite parent;
    RuNode selection;

    public DeleteTreeCommand(RuNodeComposite parent, RuNode selection) {
        this.parent = parent;
        this.selection = selection;
    }

    @Override
    public void doCommmand() {
        parent.removeChild(selection);
        MainView.getInstance().getMyTree().refresh();
    }

    @Override
    public void undoCommand() {
        parent.addChild(selection);
        if (selection instanceof Presentation)
        {
            if (!((Presentation) selection).getSharedProjects().isEmpty())
            {
                for (Project project : ((Presentation) selection).getSharedProjects())
                {
                    project.addChild(selection);
                }
            }
        }
        MainView.getInstance().getMyTree().refresh();
    }
}
