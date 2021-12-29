package Controller;

import Model.treeModel.*;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import View.userErrorHandler.ErrorFactory;
import command.DeleteTreeCommand;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class DeleteAction extends AbstractRudokAction{

    public DeleteAction() {
        putValue(NAME, "Delete");
        putValue(SMALL_ICON, loadIcon("images/delete.png"));
        putValue(SHORT_DESCRIPTION, "Deletes a selected component and its children");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainView.getInstance().getMyTree().getSelectionPath() == null)
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.DeleteError);
            return;
        }

        RuNode selection = ((MyTreeNode) Objects.requireNonNull(MainView.getInstance().getMyTree().getSelectionPath()).getLastPathComponent()).getNode();
        RuNode parent;

        if (selection != null && !(selection instanceof WorkSpace) )
        {
            parent = selection.getParent();
            MainView.getInstance().getCommandManager().addComand(new DeleteTreeCommand((RuNodeComposite) parent, selection));
            //((RuNodeComposite)parent).removeChild(selection);
            MainView.getInstance().getMyTree().clearSelection();
            MainView.getInstance().getMyTree().refresh();
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.DeleteError);
        }
    }
}
