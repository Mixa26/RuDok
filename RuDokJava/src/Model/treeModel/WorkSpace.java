package Model.treeModel;

import Model.observer.NotifyType;

import java.io.File;

public class WorkSpace extends RuNodeComposite {

    private File workSpaceFile;

    public WorkSpace(String name)
    {
        super(name, null);
    }

    public WorkSpace()
    {
        super("WorkSpace", null);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Project)
        {
            setChanged(true);
            super.getChildren().add(child);
        }
    }

    @Override
    public void removeChild(RuNode child) {
        if (child instanceof Project)
        {
            setChanged(true);
            super.getChildren().remove(child);
            notifySubscribers(child, NotifyType.DeleteProject);
        }
    }

    public File getWorkSpaceFile() {
        return workSpaceFile;
    }

    public void setWorkSpaceFile(File workSpaceFile) {
        this.workSpaceFile = workSpaceFile;
    }
}
