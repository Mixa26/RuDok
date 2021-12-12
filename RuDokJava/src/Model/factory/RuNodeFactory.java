package Model.factory;

import Model.treeModel.RuNode;

public abstract class RuNodeFactory {

    public RuNode constructRuNode(RuNodeType type, RuNode parent) {
        RuNode ruNode;
        ruNode = createRuNode(type, parent);
        return ruNode;
    }

    protected abstract RuNode createRuNode(RuNodeType type, RuNode parent);
}
