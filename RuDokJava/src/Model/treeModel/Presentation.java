package Model.treeModel;

import java.awt.*;
import java.net.URL;

public class Presentation extends RuNodeComposite {

    private String author;
    private URL backgroundImage;

    public Presentation(String name, Project parent)
    {
        super(name, parent);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Slide)
        {
            super.getChildren().add(child);
        }
    }

    @Override
    public void removeChild(RuNode child)
    {
        if (child instanceof Slide)
        {
            super.getChildren().remove(child);
        }
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBackgroundImage(URL backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getAuthor() {
        return author;
    }

    public URL getBackgroundImage() {
        return backgroundImage;
    }
}
