package Model.treeModel;

import observer.NotifyType;

import java.io.File;
import java.util.Iterator;

public class Project extends RuNodeComposite{

    private File projectFile;

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
            removePresentationFromSharedProjects(child);
            super.getChildren().remove(child);
            notifySubscribers(child, NotifyType.RemovePresentation);
        }
    }

    private void removePresentationFromSharedProjects(RuNode child)
    {
        if (!((Presentation) child).getSharedProjects().isEmpty())
        {
            Iterator<Project> iterator = ((Presentation)child).getSharedProjects().iterator();
            while (iterator.hasNext())
            {
                iterator.next().getChildren().remove(child);
                notifySubscribers(child, NotifyType.RemovePresentation);
                iterator.remove();
            }
        }
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        notifySubscribers(this, NotifyType.RenameProject);
    }

    public File getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }
}
