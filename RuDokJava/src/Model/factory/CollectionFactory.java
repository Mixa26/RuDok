package Model.factory;

import Model.treeModel.*;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

public class CollectionFactory extends RuNodeFactory{
    @Override
    protected RuNode createRuNode(RuNode parent) {
        Project project = new Project("Project " + (((WorkSpace)parent).getChildren().size() + 1), (WorkSpace) parent);
        return project;
    }
}
