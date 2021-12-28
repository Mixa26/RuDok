package Model;

import Model.slotHandler.MultimediaSlotHandler;
import Model.slotHandler.SlotHandler;
import Model.slotHandler.TextSlotHandler;
import observer.IPublisher;
import observer.ISubscriber;
import observer.NotifyType;

import javax.swing.text.StyledDocument;
import java.awt.*;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Slot implements IPublisher {
    public enum type
    {
        Multimedia,
        Text
    }

    private SlotHandler slotHandler;

    private List<ISubscriber> subscribers;

    private int x,y;
    private int width,height;
    private Color color;
    private Stroke stroke;
    private type typeC;
    private String content;

    public Slot(int x, int y, type type) {
        this.x = x;
        this.y = y;
        width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 21;
        height  = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 21;
        color = new Color(255, 255, 255, 100);
        this.typeC = type;
        if (type == Slot.type.Text)
        {
            slotHandler = new TextSlotHandler(this);
        }
        else
        {
            slotHandler = new MultimediaSlotHandler(this);
        }
    }

    public boolean elementAt(int x, int y)
    {
        if ((x >= this.x && x <= this.x + width) && (y >= this.y && y <= this.y + height))
        {
            return true;
        }
        return false;
    }

    public void addSubscriber(ISubscriber subscriber) {

        if (subscriber != null) {
            if (subscribers == null)
            {
                subscribers = new ArrayList<ISubscriber>();
            }
            if (!subscribers.contains(subscriber))
            {
                subscribers.add(subscriber);
            }
        }
    }

    public void removeSubscriber(ISubscriber subscriber) {
        if (subscriber != null && subscribers != null && subscribers.contains(subscriber))
        {
            subscribers.remove(subscriber);
        }
    }

    public void notifySubscribers(Object notification, NotifyType type) {
        if (notification != null && subscribers != null && !subscribers.isEmpty())
        {
            Iterator subs = subscribers.iterator();

            while (subs.hasNext())
            {
                ((ISubscriber)subs.next()).update(notification, type);
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;

    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public Slot.type getType() {
        return typeC;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public SlotHandler getSlotHandler() {
        return slotHandler;
    }
}
