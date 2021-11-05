package View.treeSwingGUI.model;

import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.WorkSpace;
import View.MainView;

import javax.swing.tree.DefaultTreeModel;

public class MyTreeModel extends DefaultTreeModel {

    public MyTreeModel() {
        super(new MyTreeNode(new WorkSpace()));
    }

    @Override
    public Object getRoot() {
        return super.getRoot();
    }
}
