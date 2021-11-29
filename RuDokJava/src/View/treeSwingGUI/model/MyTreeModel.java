package View.treeSwingGUI.model;

import Model.treeModel.WorkSpace;

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
