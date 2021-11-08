package Controller;

import Model.treeModel.Project;
import View.userErrorHandler.ErrorFactory;
import Model.treeModel.Presentation;
import Model.treeModel.RuNode;
import Model.treeModel.Slide;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import java.awt.event.ActionEvent;

public class NewSlideAction extends AbstractRudokAction{

    public NewSlideAction() {
        putValue(NAME, "Slide");
        putValue(SMALL_ICON, loadIcon("images/newSlide.png"));
        putValue(SHORT_DESCRIPTION, "Creates a new slide in a selected presentation");
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
            MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.AddSlideError);
            return;
        }

        if (selection instanceof Presentation)
        {
            Slide slide = new Slide("Slide " + (((Presentation) selection).getChildren().size() + 1), (Presentation) selection, ((Presentation) selection).getChildren().size() + 1);
            ((Presentation) selection).addChild(slide);

            MainView.getIntance().getRightWorkArea().setProject(((Project)((Presentation)selection).getParent()));

            MainView.getIntance().getMyTree().expandPath(MainView.getIntance().getMyTree().getSelectionPath());
            MainView.getIntance().getMyTree().refresh();
        }
        else
        {
            MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.AddSlideError);
        }
    }
}
