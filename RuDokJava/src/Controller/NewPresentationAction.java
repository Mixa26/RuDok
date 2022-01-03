package Controller;

import Model.factory.FactoryGenerator;
import Model.treeModel.*;
import Model.userErrorHandler.ErrorFactory;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import Controller.command.AddTreeCommand;

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

        if (MainView.getInstance().getMyTree().getSelectionPath() != null)
        {

            selection = ((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode();
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.AddPresentationError);
            return;
        }

        if (selection instanceof Project)
        {
            Presentation presentation = (Presentation) FactoryGenerator.returnFactory(selection).constructRuNode(selection);
            Slide slide = (Slide) FactoryGenerator.returnFactory(presentation).constructRuNode(presentation);
            presentation.addChild(slide);
//            Presentation presentation = new Presentation("Presentation " + (((Project) selection).getChildren().size() + 1), (Project)selection);
//            presentation.setAuthor("Author");
//            Slide slide = new Slide("Slide 1", presentation, 1);
//            presentation.addChild(slide);
            MainView.getInstance().getCommandManager().addComand(new AddTreeCommand((RuNodeComposite) selection, presentation));
            //((Project) selection).addChild(presentation);

            //MainView.getIntance().getRightWorkArea().setProject((Project)selection);

            MainView.getInstance().getMyTree().expandPath(MainView.getInstance().getMyTree().getSelectionPath());
            //MainView.getIntance().getMyTree().refresh();
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.AddPresentationError);
        }
    }
}
