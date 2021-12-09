package Model.treeModel;

import Model.Slot;
import observer.ISubscriber;
import observer.NotifyType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Slide extends RuNode {

    private int ordinalNumber;

    private List<Slot> slots;

    public Slide(String name, Presentation parent, int ordinalNumber)
    {
        super(name, parent);
        slots = new ArrayList<>();
        this.ordinalNumber = ordinalNumber;
    }

    public void addSlot(Slot slot)
    {
        slots.add(slot);
        notifySubscribers(slot, NotifyType.AddSlot);
    }

    public void removeSlot(Slot slot)
    {
        slots.remove(slot);
        notifySubscribers(slot, NotifyType.RemoveSlot);
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public List<Slot> getSlots() {
        return slots;
    }

}
