package command;

import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.RuNodeComposite;
import View.MainView;

import java.util.ArrayList;
import java.util.List;

public class AddTreeCommand extends AbstractCommand{
    RuNodeComposite selection;
    RuNode current;

    public AddTreeCommand(RuNodeComposite selection, RuNode current) {
        this.selection = selection;
        this.current = current;
    }

    @Override
    public void doCommmand() {
        selection.addChild(current);
        if (current instanceof Presentation)
        {
            if (!((Presentation) current).getSharedProjects().isEmpty())
            {
                for (Project project : ((Presentation) current).getSharedProjects())
                {
                    project.addChild(current);
                }
            }
        }
        MainView.getInstance().getMyTree().refresh();
    }

    @Override
    public void undoCommand() {
        selection.removeChild(current);
        MainView.getInstance().getMyTree().refresh();
    }

}
