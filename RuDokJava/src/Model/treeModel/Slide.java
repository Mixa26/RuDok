package Model.treeModel;

import Model.Slot;
import View.MainView;
import View.PresentationView;
import observer.NotifyType;

import java.util.ArrayList;
import java.util.List;

public class Slide extends RuNode {

    //pozicioniranje slota kada se vuce
    private Slot slotDraged;
    private int relativePosX;
    private int relativePosY;

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
        signalizeChange();
        slots.add(slot);
        slot.setStroke(((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getStroke());
        notifySubscribers(slot, NotifyType.AddSlot);
    }

    public void removeSlot(Slot slot)
    {
        signalizeChange();
        slots.remove(slot);
        notifySubscribers(slot, NotifyType.RemoveSlot);
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(int ordinalNumber) {
        signalizeChange();
        this.ordinalNumber = ordinalNumber;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlotDraged(Slot slotDraged) {
        signalizeChange();
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

    public void signalizeChange()
    {
        getParent().setChanged(true);
    }
}
