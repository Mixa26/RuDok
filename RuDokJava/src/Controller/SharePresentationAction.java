package Controller;

import Model.treeModel.Presentation;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import Model.userErrorHandler.ErrorFactory;

import java.awt.event.ActionEvent;

public class SharePresentationAction extends AbstractRudokAction{
    public SharePresentationAction() {
        putValue(NAME, "Share a presentation");
        putValue(SMALL_ICON, loadIcon("images/sharePresentation.png"));
        putValue(SHORT_DESCRIPTION, "Shares the selected presentation with another project.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainView.getInstance().getMyTree().getSelectionPath() != null)
        {
            if (((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Presentation)
            {
                MainView.getInstance().getSharePresentationView().loadProjects();
                MainView.getInstance().getSharePresentationView().setVisible(true);
                MainView.getInstance().getMyTree().refresh();
            }
            else
            {
                MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.NoPresentationSelected);
            }
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.NoPresentationSelected);
        }
    }
}
