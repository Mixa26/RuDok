package Model;

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
        }
    }

    @Override
    public void removeChild(RuNode child) {
        if (child instanceof Presentation)
        {
            super.getChildren().remove(child);
        }
    }
}
