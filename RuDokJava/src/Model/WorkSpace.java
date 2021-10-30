package Model;

public class WorkSpace extends RuNodeComposite{

    public WorkSpace(String name)
    {
        super(name, null);
    }

    @Override
    public void addChild(RuNode child) {
        if (child instanceof Project)
        {
            super.getChildren().add(child);
        }
    }

    @Override
    public void removeChild(RuNode child) {
        if (child instanceof Project)
        {
            super.getChildren().remove(child);
        }
    }
}
