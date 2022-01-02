package Controller;

import Model.treeModel.Presentation;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import View.userErrorHandler.ErrorFactory;

import java.awt.event.ActionEvent;

public class SubmitPresentationInitialsAction extends AbstractRudokAction{
    private String url;
    private String extension = new String();
    private boolean imgValid = false;

    public SubmitPresentationInitialsAction() {
        putValue(NAME, "Submit");
        putValue(SHORT_DESCRIPTION, "Sets the background image and author for the selected Presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        imgValid = false;

        if (MainView.getInstance().getMyTree().getSelectionPath() == null)
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.EditPresentationError);
            return;
        }

        String author = MainView.getInstance().getMyToolBar().getEditPresentationView().getAuthor().getText();
        //String author = MainView.getInstance().getActionManager().getEditPresentationAction().getEditPresentationView().getAuthor().getText();

        Presentation presentation = (Presentation)((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode();

        if (author != null && !author.equals(""))
        {
            presentation.setAuthor(author);
        }

        if (url != null)
        {
            presentation.setBackgroundImage(url);
        }


        MainView.getInstance().getMyToolBar().getEditPresentationView().setVisible(false);
        //MainView.getInstance().getActionManager().getEditPresentationAction().getEditPresentationView().setVisible(false);

    }

    public void setUrl(String url) {
        this.url = url;
    }
}
