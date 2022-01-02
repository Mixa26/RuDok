package Controller;

import Model.factory.FactoryGenerator;
import Model.treeModel.*;
import Model.userErrorHandler.ErrorFactory;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import command.AddTreeCommand;

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

        if (MainView.getInstance().getMyTree().getSelectionPath() != null)
        {
            selection = ((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode();
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.AddSlideError);
            return;
        }

        if (selection instanceof Presentation)
        {
            Slide slide = (Slide) FactoryGenerator.returnFactory(selection).constructRuNode(selection);
//            Slide slide = new Slide("Slide " + (((Presentation) selection).getChildren().size() + 1), (Presentation) selection, ((Presentation) selection).getChildren().size() + 1);
            MainView.getInstance().getCommandManager().addComand(new AddTreeCommand((RuNodeComposite) selection, slide));
            //((Presentation) selection).addChild(slide);

            //MainView.getIntance().getRightWorkArea().setProject(((Project)((Presentation)selection).getParent()));

            MainView.getInstance().getMyTree().expandPath(MainView.getInstance().getMyTree().getSelectionPath());
            MainView.getInstance().getMyTree().refresh();
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.AddSlideError);
        }
    }
}
