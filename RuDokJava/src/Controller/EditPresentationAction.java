package Controller;

import Model.userErrorHandler.ErrorFactory;
import Model.treeModel.Presentation;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import java.awt.event.ActionEvent;

public class EditPresentationAction extends AbstractRudokAction {

    public EditPresentationAction()
    {
        putValue(NAME, "Presentation");
        putValue(SMALL_ICON, loadIcon("images/editPresentation.png"));
        putValue(SHORT_DESCRIPTION, "Edit the author and background image of a selected presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainView.getInstance().getMyTree().getSelectionPath() != null && ((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Presentation)
        {
            MainView.getInstance().getMyToolBar().getEditPresentationView().setVisible();
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.EditPresentationError);
        }
    }

}
