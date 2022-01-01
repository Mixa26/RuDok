package Model.slotHandler;

import Model.Slot;

import java.io.Serializable;

public abstract class SlotHandler implements Serializable{
    protected Slot slot;

    public abstract void setContent(String content);

    public abstract String getContent();
}
