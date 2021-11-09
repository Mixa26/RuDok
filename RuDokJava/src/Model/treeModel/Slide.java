package Model.treeModel;

public class Slide extends RuNode {

    private int ordinalNumber;

    public Slide(String name, Presentation parent, int ordinalNumber)
    {
        super(name, parent);
        this.ordinalNumber = ordinalNumber;
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }
}
