package Controller;

import Model.treeModel.Presentation;
import View.EditPresentationView;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditPresentationAction extends AbstractRudokAction {
    private final EditPresentationView editPresentationView = new EditPresentationView(MainView.getIntance(), "Edit presentation", true);

    public EditPresentationAction()
    {
        putValue(NAME, "Presentation");
        putValue(SMALL_ICON, loadIcon("images/editPresentation.png"));
        putValue(SHORT_DESCRIPTION, "Edit the author and background image of a presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainView.getIntance().getMyTree().getSelectionPath() != null && ((MyTreeNode)MainView.getIntance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Presentation) {
            editPresentationView.setVisible();
        }
        else
        {
            //TODO dodaj ovde prozor iz tacke 8 koj ce da bude iz simplefactorija da regulise ako korisnik ne selektuje prezentaciju a hoce da edituje pozadinsku sliku i autora
        }
    }

    public EditPresentationView getEditPresentationView() {
        return editPresentationView;
    }
}
