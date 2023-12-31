package View;

import Model.Slot;
import Model.slotHandler.TextSlotHandler;
import Model.slotHandler.charStyle;
import Model.observer.ISubscriber;
import Model.observer.NotifyType;

import javax.swing.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.awt.*;
import java.util.Map;

public class SlotView implements ISubscriber {
    Slot slot;

    int x;
    int y;
    int width;
    int height;

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
    }

    public void paint(Graphics2D g)
    {
        Shape shape = new Rectangle(x,y,width,height);
        g.setPaint(slot.getColor());
        g.fill(shape);
        g.setPaint(new Color(0,0,0));
        g.setStroke(slot.getStroke());
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
                    if (((TextSlotHandler)slot.getSlotHandler()).getCharStyle().isEmpty())
                    {
                        g.drawString(slot.getSlotHandler().getContent(), x + 5, y + 15);
                    }
                    else
                    {
                        for (int i = 0; i < slot.getContent().length(); i++)
                        {
                            charStyle CharStyle = ((TextSlotHandler) slot.getSlotHandler()).getCharStyle().get(i);
                            if (CharStyle.isBold() && CharStyle.isItalic() && CharStyle.isUnderline())
                            {
                                Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
                                fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                g.setFont(new Font("Aerial", Font.BOLD | Font.ITALIC ,12).deriveFont(fontAttributes));
                            }
                            else if (!CharStyle.isBold() && CharStyle.isItalic() && CharStyle.isUnderline())
                            {
                                Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
                                fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                g.setFont(new Font("Aerial", Font.ITALIC ,12).deriveFont(fontAttributes));
                            }
                            else if (CharStyle.isBold() && !CharStyle.isItalic() && CharStyle.isUnderline())
                            {
                                Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
                                fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                g.setFont(new Font("Aerial", Font.BOLD ,12).deriveFont(fontAttributes));
                            }
                            else if (CharStyle.isBold() && CharStyle.isItalic() && !CharStyle.isUnderline())
                            {
                                g.setFont(new Font("Aerial", Font.BOLD | Font.ITALIC ,12));
                            }
                            else if (!CharStyle.isBold() && !CharStyle.isItalic() && CharStyle.isUnderline())
                            {
                                Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
                                fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                                g.setFont(new Font("Aerial", Font.PLAIN,12).deriveFont(fontAttributes));
                            }
                            else if (!CharStyle.isBold() && CharStyle.isItalic() && !CharStyle.isUnderline())
                            {
                                g.setFont(new Font("Aerial", Font.ITALIC ,12));
                            }
                            else if (CharStyle.isBold() && !CharStyle.isItalic() && !CharStyle.isUnderline())
                            {
                                g.setFont(new Font("Aerial", Font.BOLD ,12));
                            }
                            else if (!CharStyle.isBold() && !CharStyle.isItalic() && !CharStyle.isUnderline())
                            {
                                g.setFont(new Font("Aerial", Font.PLAIN ,12));
                            }
                            g.drawString(""+slot.getContent().charAt(i), x + i*10, y+15);
                        }
                    }
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
        slot.setStroke(stroke);
    }

    public void setSlideShow(boolean slideShow) {
        this.slideShow = slideShow;
    }
}
