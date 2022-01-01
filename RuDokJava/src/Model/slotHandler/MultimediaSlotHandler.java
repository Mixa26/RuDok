package Model.slotHandler;

import Model.Slot;

import java.io.Serializable;

public class MultimediaSlotHandler extends SlotHandler implements Serializable {

    public MultimediaSlotHandler(Slot slot) {
        super.slot = slot;
    }

    @Override
    public void setContent(String content) {
        slot.signalizeChange();
        slot.setContent(content);
    }

    @Override
    public String getContent() {
        return slot.getContent();
    }
}
