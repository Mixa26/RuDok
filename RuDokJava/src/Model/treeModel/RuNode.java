package Model.treeModel;

public abstract class RuNode {

    private String name;
    private RuNode parent;

    public RuNode(String name, RuNode parent)
    {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RuNode getParent() {
        return parent;
    }
}
