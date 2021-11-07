package Controller;

import Model.treeModel.Presentation;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import View.userErrorHandler.ErrorFactory;

import java.awt.event.ActionEvent;
import java.net.URL;

public class SubmitPresentationInitialsAction extends AbstractRudokAction{
    public SubmitPresentationInitialsAction() {
        putValue(NAME, "Submit");
        putValue(SHORT_DESCRIPTION, "Sets the background image and author for the selected Presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainView.getIntance().getMyTree().getSelectionPath() == null)
        {
            MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.EditPresentationError);
            return;
        }

        String author = MainView.getIntance().getActionManager().getEditPresentationAction().getEditPresentationView().getAuthor().getText();
        String url = MainView.getIntance().getActionManager().getEditPresentationAction().getEditPresentationView().getImageURL().getText();

        Presentation presentation = (Presentation)((MyTreeNode)MainView.getIntance().getMyTree().getSelectionPath().getLastPathComponent()).getNode();

        if (author != null && !author.equals(""))
        {
            presentation.setAuthor(author);
        }

        if (presentation != null)
        {
            presentation.setBackgroundImage(url);
        }
        else
        {
            System.out.println("pres img = null");
        }

        MainView.getIntance().getActionManager().getEditPresentationAction().getEditPresentationView().setVisible(false);

    }
}
