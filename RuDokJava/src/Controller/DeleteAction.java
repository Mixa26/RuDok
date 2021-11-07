package Controller;

import Model.treeModel.RuNode;
import Model.treeModel.RuNodeComposite;
import Model.treeModel.Slide;
import Model.treeModel.WorkSpace;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import View.treeSwingGUI.view.MyTree;
import View.userErrorHandler.ErrorFactory;

import javax.swing.*;
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
        if (MainView.getIntance().getMyTree().getSelectionPath() == null)
        {
            MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.DeleteError);
            return;
        }

        RuNode selection = ((MyTreeNode) Objects.requireNonNull(MainView.getIntance().getMyTree().getSelectionPath()).getLastPathComponent()).getNode();
        RuNode parent;

        if (selection != null && !(selection instanceof WorkSpace) )
        {
            parent = selection.getParent();
            ((RuNodeComposite)parent).removeChild(selection);
            MainView.getIntance().getMyTree().refresh();
        }
        else
        {
            MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.DeleteError);
        }
    }
}
