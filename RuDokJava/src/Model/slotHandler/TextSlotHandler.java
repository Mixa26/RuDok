package Model.slotHandler;

import Model.Slot;

public class TextSlotHandler extends SlotHandler{
    public TextSlotHandler(Slot slot) {
        super.slot = slot;
    }

    @Override
    public void setContent(String content) {
        slot.setContent(content);
    }

    @Override
    public String getContent() {
        return slot.getContent();
    }
}
