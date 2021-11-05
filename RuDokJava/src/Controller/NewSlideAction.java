package Controller;

import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.Slide;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import java.awt.event.ActionEvent;

public class NewSlideAction extends AbstractRudokAction{

    public NewSlideAction() {
        putValue(NAME, "Slide");
        putValue(SMALL_ICON, loadIcon("images/newSlide.png"));
        putValue(SHORT_DESCRIPTION, "Creates a new slide");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RuNode selection;

        if (MainView.getIntance().getMyTree().getSelectionPath() != null)
        {
            selection = ((MyTreeNode)MainView.getIntance().getMyTree().getSelectionPath().getLastPathComponent()).getNode();
        }
        else
        {
            return;
        }

        if (selection instanceof Presentation)
        {
            Slide slide = new Slide("Slide " + (((Presentation) selection).getChildren().size() + 1), (Presentation) selection);
            ((Presentation) selection).getChildren().add(slide);
            MainView.getIntance().getMyTree().refresh();
        }
    }
}
