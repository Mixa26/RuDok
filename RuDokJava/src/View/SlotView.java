package View;

import Model.Slot;
import Model.treeModel.Presentation;
import observer.ISubscriber;
import observer.NotifyType;
import state.SlotBorderStrokeState.SplitStrokeState;

import javax.swing.*;
import java.awt.*;

public class SlotView implements ISubscriber {
    Slot slot;

    int x;
    int y;
    int width;
    int height;

    Stroke stroke;

    boolean mini;
    boolean slideShow;

    public SlotView(Slot slot) {
        mini = false;
        slideShow = false;
        this.slot = slot;
        x = slot.getX();
        y = slot.getY();
        width = slot.getWidth();
        height = slot.getHeight();
        stroke = slot.getStroke();
    }

    public void paint(Graphics2D g)
    {
        Shape shape = new Rectangle(x,y,width,height);
        g.setPaint(slot.getColor());
        g.fill(shape);
        g.setPaint(new Color(0,0,0));
        g.setStroke(stroke);
        g.drawRect(x, y, width, height);

        if (slideShow) {
            if (slot.getType() == Slot.type.Multimedia)
            {
                if (new ImageIcon(slot.getSlotHandler().getContent()).getImage() != null)
                {
                    Image image = new ImageIcon(slot.getSlotHandler().getContent()).getImage();

                    g.drawImage((image), x, y, width, height, null);
                }
            }
            else
            {
                if (slot.getSlotHandler().getContent() != null && !slot.getSlotHandler().getContent().equals(""))
                {
                    g.drawString(slot.getSlotHandler().getContent(), x + 5, y + 15);

                }
            }
        }
    }

    @Override
    public void update(Object notification, NotifyType type) {
        if (notification instanceof Slot slot)
        {
            if (type == NotifyType.DragDropSlot)
            {
                if (mini)
                {
                    this.x = ((Slot)notification).getX()/3-5;
                    this.y = ((Slot)notification).getY()/3-5;
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

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public void setSlideShow(boolean slideShow) {
        this.slideShow = slideShow;
    }
}
