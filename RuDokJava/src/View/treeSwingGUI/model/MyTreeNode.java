package View.treeSwingGUI.model;

import Model.treeModel.RuNode;
import Model.treeModel.RuNodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class MyTreeNode extends DefaultMutableTreeNode {
    private final RuNode node;

    public MyTreeNode(RuNode node)
    {
        this.node = node;
    }

    //null situacije nisu regulisane, moguci su uzrok errora
    @Override
    public boolean getAllowsChildren() {
        return node instanceof RuNodeComposite;
    }

    @Override
    public TreeNode getChildAt(int index) {
        return new MyTreeNode(((RuNodeComposite) node).getChildren().get(index));
    }

    @Override
    public int getChildCount() {
        return ((RuNodeComposite)node).getChildren().size();
    }

    @Override
    public int getIndex(TreeNode aChild) {
        return ((RuNodeComposite)node).getChildren().indexOf(((MyTreeNode)aChild).getNode());
    }

    @Override
    public TreeNode getParent() {
        return new MyTreeNode(node.getParent());
    }

    @Override
    public boolean isLeaf() {
        return !(node instanceof RuNodeComposite);
    }

    @Override
    public void add(MutableTreeNode newChild) {
        ((RuNodeComposite)node).getChildren().add(((MyTreeNode)newChild).getNode());
    }

    @Override
    public String toString() {
        return node.getName();
    }

    public RuNode getNode() {
        return node;
    }
}
