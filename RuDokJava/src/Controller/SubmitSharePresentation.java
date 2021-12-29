package Controller;

import Model.treeModel.Presentation;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import java.awt.event.ActionEvent;

public class SubmitSharePresentation extends AbstractRudokAction{
    public SubmitSharePresentation() {
        putValue(NAME, "Submit");
        putValue(SHORT_DESCRIPTION, "Shares the presentation with the selected project.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((Presentation)((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode()).getSharedProjects().add(MainView.getInstance().getSharePresentationView().sharedProject);
        MainView.getInstance().getSharePresentationView().sharedProject.addChild(((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode());
        MainView.getInstance().getSharePresentationView().setVisible(false);
    }
}
