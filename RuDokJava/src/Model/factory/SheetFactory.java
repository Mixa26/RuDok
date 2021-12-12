package Model.factory;

import Model.treeModel.Presentation;
import Model.treeModel.RuNode;
import Model.treeModel.Slide;

public class SheetFactory extends RuNodeFactory{
    @Override
    protected RuNode createRuNode(RuNodeType type, RuNode parent) {
        return new Slide("Slide " + (((Presentation) parent).getChildren().size() + 1), (Presentation) parent, ((Presentation) parent).getChildren().size() + 1);
    }
}
