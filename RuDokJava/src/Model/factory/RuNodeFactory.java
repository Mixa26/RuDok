package Model.factory;

import Model.treeModel.RuNode;

public abstract class RuNodeFactory {

    public RuNode constructRuNode(RuNode parent) {
        RuNode ruNode;
        ruNode = createRuNode(parent);
        return ruNode;
    }

    protected abstract RuNode createRuNode(RuNode parent);
}
