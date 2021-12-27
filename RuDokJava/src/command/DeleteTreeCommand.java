package command;

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
        MainView.getIntance().getMyTree().refresh();
    }

    @Override
    public void undoCommand() {
        parent.addChild(selection);
        MainView.getIntance().getMyTree().refresh();
    }
}
