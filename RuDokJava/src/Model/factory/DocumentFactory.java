package Model.factory;

import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.Slide;

public class DocumentFactory extends RuNodeFactory{
    private boolean error;
    @Override
    protected RuNode createRuNode(RuNode parent) {
        Presentation presentation = new Presentation("Presentation " + (((Project) parent).getChildren().size() + 1), (Project)parent);
        presentation.setAuthor("Author");
        return presentation;
    }
}
