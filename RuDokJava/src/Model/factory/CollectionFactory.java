package Model.factory;

import Model.treeModel.*;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

public class CollectionFactory extends RuNodeFactory{
    @Override
    protected RuNode createRuNode(RuNodeType type, RuNode parent) {
        Project project = new Project("Project " + (((WorkSpace)parent).getChildren().size() + 1), (WorkSpace) parent);
        Presentation presentation = new Presentation("Presentation 1", project);
        presentation.setAuthor("Author");
        Slide slide = new Slide("Slide 1", presentation, 1);

        presentation.addChild(slide);
        project.addChild(presentation);
        return project;
    }
}
