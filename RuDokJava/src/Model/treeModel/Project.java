package Model.treeModel;

import observer.NotifyType;

public class Project extends RuNodeComposite{

    public Project(String name, WorkSpace parent)
    {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Presentation)
        {
            super.getChildren().add(child);
            notifySubscribers(this, NotifyType.AddPresentation);
        }
    }

    @Override
    public void removeChild(RuNode child) {
        if (child instanceof Presentation)
        {
            super.getChildren().remove(child);
            notifySubscribers(child, NotifyType.RemovePresentation);
        }
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        notifySubscribers(this, NotifyType.RenameProject);
    }

}
