package Model;

import javax.swing.*;
import java.awt.*;

public class Presentation extends RuNodeComposite{

    private String author;
    private Image backgroundImage;

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
}
