package Controller;

import View.userErrorHandler.ErrorFactory;
import Model.treeModel.Presentation;
import View.EditPresentationView;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import java.awt.event.ActionEvent;

public class EditPresentationAction extends AbstractRudokAction {
    private final EditPresentationView editPresentationView = new EditPresentationView(MainView.getIntance(), "Edit presentation", true);

    public EditPresentationAction()
    {
        putValue(NAME, "Presentation");
        putValue(SMALL_ICON, loadIcon("images/editPresentation.png"));
        putValue(SHORT_DESCRIPTION, "Edit the author and background image of a selected presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainView.getIntance().getMyTree().getSelectionPath() != null && ((MyTreeNode)MainView.getIntance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Presentation) {
            editPresentationView.setVisible();
        }
        else
        {
            MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.EditPresentationError);
        }
    }

    public EditPresentationView getEditPresentationView() {
        return editPresentationView;
    }
}
