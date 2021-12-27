package command;

import Model.treeModel.RuNode;
import Model.treeModel.RuNodeComposite;
import View.MainView;

import javax.swing.tree.TreePath;

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
        MainView.getIntance().getMyTree().refresh();
    }

    @Override
    public void undoCommand() {
        selection.removeChild(current);
        MainView.getIntance().getMyTree().refresh();
    }
}
