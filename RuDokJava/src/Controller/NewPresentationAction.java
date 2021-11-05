package Controller;

import Model.Main;
import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.Slide;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class NewPresentationAction extends AbstractRudokAction{

    public NewPresentationAction() {
        putValue(NAME, "Presentation");
        putValue(SMALL_ICON, loadIcon("images/newPresentation.png"));
        putValue(SHORT_DESCRIPTION, "Creates a new presentation");
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

        if (selection instanceof Project)
        {
            Presentation presentation = new Presentation("Presentation " + (((Project) selection).getChildren().size() + 1), (Project)selection);
            Slide slide = new Slide("Slide 1", presentation);
            presentation.addChild(slide);
            ((Project) selection).getChildren().add(presentation);
            MainView.getIntance().getMyTree().refresh();
        }
    }
}
