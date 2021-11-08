package Controller;

import View.userErrorHandler.ErrorFactory;
import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.Slide;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import java.awt.event.ActionEvent;

public class NewPresentationAction extends AbstractRudokAction{

    public NewPresentationAction() {
        putValue(NAME, "Presentation");
        putValue(SMALL_ICON, loadIcon("images/newPresentation.png"));
        putValue(SHORT_DESCRIPTION, "Creates a new presentation in a selected project");
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
            MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.AddPresentationError);
            return;
        }

        if (selection instanceof Project)
        {
            Presentation presentation = new Presentation("Presentation " + (((Project) selection).getChildren().size() + 1), (Project)selection);
            presentation.setAuthor("Author");
            Slide slide = new Slide("Slide 1", presentation, 1);
            presentation.addChild(slide);
            ((Project) selection).addChild(presentation);

            MainView.getIntance().getRightWorkArea().setProject((Project)selection);

            MainView.getIntance().getMyTree().expandPath(MainView.getIntance().getMyTree().getSelectionPath());
            MainView.getIntance().getMyTree().refresh();
        }
        else
        {
            MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.AddPresentationError);
        }
    }
}
