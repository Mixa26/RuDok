package Controller;

import Model.treeModel.Presentation;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import View.userErrorHandler.ErrorFactory;

import java.awt.event.ActionEvent;

public class SharePresentationAction extends AbstractRudokAction{
    public SharePresentationAction() {
        putValue(NAME, "Share a presentation");
        putValue(SMALL_ICON, loadIcon("images/sharePresentation.png"));
        putValue(SHORT_DESCRIPTION, "Shares the selected presentation with another project.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainView.getIntance().getMyTree().getSelectionPath() != null)
        {
            if (((MyTreeNode)MainView.getIntance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Presentation)
            {
                MainView.getIntance().getSharePresentationView().loadProjects();
                MainView.getIntance().getSharePresentationView().setVisible(true);
            }
            else
            {
                MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.NoPresentationSelected);
            }
        }
        else
        {
            MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.NoPresentationSelected);
        }
    }
}
