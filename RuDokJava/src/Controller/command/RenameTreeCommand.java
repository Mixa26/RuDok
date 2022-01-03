package Controller.command;

import Model.treeModel.RuNode;
import View.MainView;

public class RenameTreeCommand extends AbstractCommand{
    RuNode selection;
    String oldName;
    String name;

    public RenameTreeCommand(RuNode selection, String name) {
        this.selection = selection;
        oldName = selection.getName();
        this.name = name;
    }

    @Override
    public void doCommmand() {
        selection.setName(name);
        MainView.getInstance().getMyTree().refresh();
    }

    @Override
    public void undoCommand() {
        selection.setName(oldName);
        MainView.getInstance().getMyTree().refresh();
    }
}
