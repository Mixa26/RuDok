package View;

import Model.Slot;
import observer.ISubscriber;
import observer.NotifyType;

import java.awt.*;

public class SlotView implements ISubscriber {
    Slot slot;

    int x;
    int y;
    int width;
    int height;

    boolean mini;

    public SlotView(Slot slot) {
        mini = false;
        this.slot = slot;
        x = slot.getX();
        y = slot.getY();
        width = slot.getWidth();
        height = slot.getHeight();
    }

    public void paint(Graphics2D g)
    {
        Shape shape = new Rectangle(x,y,width,height);
        g.setPaint(slot.getColor());
        //g.setStroke(slot.getStroke());
        g.fill(shape);
        g.drawRect(x, y, width, height);
    }

    public boolean elementAt(int x, int y)
    {
        if ((x >= this.x && x <= this.x + width) && (y >= this.y && y <= this.y + height))
        {
            return true;
        }
        return false;
    }

    @Override
    public void update(Object notification, NotifyType type) {
        if (notification instanceof Slot slot)
        {
            if (type == NotifyType.DragDropSlot)
            {
                if (mini)
                {
                    this.x = ((Slot)notification).getX()/3;
                    this.y = ((Slot)notification).getY()/3;
                }
                else
                {
                    this.x = ((Slot)notification).getX();
                    this.y = ((Slot)notification).getY();
                }
            }
        }
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

    public void setMini(boolean mini) {
        this.mini = mini;
    }

    public boolean isMini() {
        return mini;
    }
}
