package Model.treeModel;

import java.util.ArrayList;
import java.util.List;

public abstract class RuNodeComposite extends RuNode {

    private List<RuNode> children;

    public RuNodeComposite(String name, RuNode parent)
    {
        super(name, parent);
        children = new ArrayList<RuNode>();
    }

    abstract public void addChild(RuNode child);

    abstract public void removeChild(RuNode child);

    public List<RuNode> getChildren() {
        return children;
    }
}
