package Controller;

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
        MainView.getIntance().getSharePresentationView().sharedProject.addChild(((MyTreeNode)MainView.getIntance().getMyTree().getSelectionPath().getLastPathComponent()).getNode());
        MainView.getIntance().getSharePresentationView().setVisible(false);
    }
}
