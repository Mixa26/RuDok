package Controller;

import Model.treeModel.*;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import Model.userErrorHandler.ErrorFactory;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class RenameInTreeAction extends AbstractRudokAction{

    public RenameInTreeAction()
    {
        putValue(NAME, "Rename");
        putValue(SMALL_ICON, loadIcon("images/rename.png"));
        putValue(SHORT_DESCRIPTION, "Rename a selected component");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((MainView.getInstance().getMyTree().getSelectionPath()) == null)
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.RenameInTreeError);
            return;
        }

        RuNode selection = ((MyTreeNode) Objects.requireNonNull(MainView.getInstance().getMyTree().getSelectionPath()).getLastPathComponent()).getNode();
        if (selection instanceof WorkSpace)
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.WorkSpaceRename);
        }
        else
        {
            if (selection != null)
            {
                MainView.getInstance().getMyToolBar().getRenameInTreeView().setVisible();
            }
            else
            {
                MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.RenameInTreeError);
            }
        }
    }
}
