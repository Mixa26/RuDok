package Controller;

import Model.treeModel.*;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import View.treeSwingGUI.view.MyTree;
import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
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

        Project project = new Project("Project " + (root.getChildren().size() + 1), root);
        Presentation presentation = new Presentation("Presentation 1", project);
        presentation.setAuthor("Author");
        Slide slide = new Slide("Slide 1", presentation);

        presentation.addChild(slide);
        project.addChild(presentation);
        root.addChild(project);

        MainView.getIntance().getMyTree().expandPath(new TreePath(MainView.getIntance().getMyTree().getModel().getRoot()));
        MainView.getIntance().getMyTree().refresh();
    }
}
