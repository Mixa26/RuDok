package Controller;

import Model.factory.FactoryGenerator;
import Model.treeModel.*;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;

public class NewProjectAction extends AbstractRudokAction{

    public NewProjectAction() {
        putValue(NAME, "Project");
        putValue(SMALL_ICON, loadIcon("images/newProject.png"));
        putValue(SHORT_DESCRIPTION, "Creates a new project in the workspace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WorkSpace root = (WorkSpace) ((MyTreeNode)MainView.getIntance().getMyTree().getModel().getRoot()).getNode();

        Project project = (Project) FactoryGenerator.returnFactory(root).constructRuNode(root);
        Presentation presentation = (Presentation) FactoryGenerator.returnFactory(project).constructRuNode(project);
        Slide slide = (Slide) FactoryGenerator.returnFactory(presentation).constructRuNode(presentation);
        presentation.addChild(slide);
        project.addChild(presentation);
//        Project project = new Project("Project " + (root.getChildren().size() + 1), root);
//        Presentation presentation = new Presentation("Presentation 1", project);
//        presentation.setAuthor("Author");
//        Slide slide = new Slide("Slide 1", presentation, 1);
//
//        presentation.addChild(slide);
//        project.addChild(presentation);
        root.addChild(project);

        //MainView.getIntance().getRightWorkArea().openProject(project);

        MainView.getIntance().getMyTree().expandPath(new TreePath(MainView.getIntance().getMyTree().getModel().getRoot()));
        MainView.getIntance().getMyTree().refresh();
    }
}
