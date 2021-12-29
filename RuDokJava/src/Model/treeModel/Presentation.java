package Model.treeModel;

import observer.NotifyType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Presentation extends RuNodeComposite{

    private File presentationFile;

    private String author;
    private String backgroundImage;

    private List<Project> sharedProjects;

    public Presentation(String name, Project parent)
    {
        super(name, parent);
        sharedProjects = new ArrayList<Project>();
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Slide)
        {
            super.getChildren().add(child);
            notifySubscribers(this, NotifyType.AddSlide);
        }
    }

    @Override
    public void removeChild(RuNode child)
    {
        if (child instanceof Slide)
        {
            super.getChildren().remove(child);
            for (RuNode slide : super.getChildren())
            {
                ((Slide)slide).setOrdinalNumber(super.getChildren().indexOf((Slide)slide)+1);
            }
            notifySubscribers(child, NotifyType.RemoveSlide);
        }
    }

    public void setAuthor(String author) {
        this.author = author;
        notifySubscribers(this, NotifyType.EditPresentation);
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getAuthor() {
        return author;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        notifySubscribers(this, NotifyType.RenamePresentation);
    }

    public List<Project> getSharedProjects() {
        return sharedProjects;
    }

    public File getPresentationFile() {
        return presentationFile;
    }

    public void setPresentationFile(File presentationFile) {
        this.presentationFile = presentationFile;
    }
}
