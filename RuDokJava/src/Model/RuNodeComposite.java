package Model;

import java.util.List;

public abstract class RuNodeComposite extends RuNode{

    private List<RuNode> children;

    public RuNodeComposite(String name, RuNode parent)
    {
        super(name, parent);
    }

    abstract public void addChild(RuNode child);

    abstract public void removeChild(RuNode child);

    public List<RuNode> getChildren() {
        return children;
    }
}
