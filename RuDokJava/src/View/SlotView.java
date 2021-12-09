package View;

import Model.Slot;

import java.awt.*;

public class SlotView {
    Slot slot;

    int x;
    int y;
    int width;
    int height;

    public SlotView(Slot slot) {
        this.slot = slot;
        x = slot.getX();
        y = slot.getY();
        width = slot.getWidth();
        height = slot.getHeight();
    }

    public void paint(Graphics2D g)
    {
        g.setPaint(slot.getColor());
        //g.setStroke(slot.getStroke());
        g.drawRect(x, y, width, height);
    }

    public void elementAt()
    {

    }

    public Slot getSlot() {
        return slot;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}