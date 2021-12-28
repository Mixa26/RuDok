package Model.slotHandler;

import Model.Slot;

public abstract class SlotHandler {
    protected Slot slot;

    public abstract void setContent(String content);

    public abstract String getContent();
}
