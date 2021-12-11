package Model.treeModel;

import Model.Slot;
import View.SlideView;
import observer.ISubscriber;
import observer.NotifyType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Slide extends RuNode {

    //pozicioniranje slota kada se vuce
    private Slot slotDraged;
    private int relativePosX;
    private int relativePosY;

    private int ordinalNumber;

    private List<Slot> slots;

    private List<SlideView> slideViews;

    public Slide(String name, Presentation parent, int ordinalNumber)
    {
        super(name, parent);
        slots = new ArrayList<>();
        slideViews = new ArrayList<>();
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

    public List<SlideView> getSlideViews() {
        return slideViews;
    }

    public void setSlotDraged(Slot slotDraged) {
        this.slotDraged = slotDraged;
    }

    public Slot getSlotDraged() {
        return slotDraged;
    }

    public int getRelativePosX() {
        return relativePosX;
    }

    public int getRelativePosY() {
        return relativePosY;
    }

    public void setRelativePosX(int relativePosX) {
        this.relativePosX = relativePosX;
    }

    public void setRelativePosY(int relativePosY) {
        this.relativePosY = relativePosY;
    }
}
