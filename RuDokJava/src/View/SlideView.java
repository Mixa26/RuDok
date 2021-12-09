package View;

import Model.Slot;
import Model.treeModel.Presentation;
import Model.treeModel.Slide;
import observer.ISubscriber;
import observer.NotifyType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SlideView extends JPanel implements ISubscriber {
    private Slide slide;

    private List<SlotView> slotViews;

    private boolean mini;

    private final int width = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3);
    private final int height = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3);

    private JLabel ordinalNumber;

    public SlideView(Slide slide) {
        mini = false;
        this.slide = slide;
        setBackground(Color.LIGHT_GRAY);
        setMaximumSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3));
        setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3));
        //setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 100)));
        setLayout(new BorderLayout());

        slotViews = new ArrayList<SlotView>();
        for (Slot slot : slide.getSlots())
        {
            slotViews.add(new SlotView(slot));
        }
        //addMouseListener(new StateMouseListener(this));

        ordinalNumber = new JLabel(String.valueOf(slide.getOrdinalNumber()));
        ordinalNumber.setFont(new Font("Aerial", Font.BOLD, 25));
        add(ordinalNumber, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (new ImageIcon(((Presentation)slide.getParent()).getBackgroundImage()).getImage() != null)
        {
            Image image = new ImageIcon(((Presentation)slide.getParent()).getBackgroundImage()).getImage();
            g.drawImage((image),0, 0, null);
        }

        for (SlotView slotView : slotViews)
        {
            slotView.paint((Graphics2D) g);
        }

    }

    public boolean compareTo(SlideView slideView)
    {
        return this.slide.equals(slideView.slide);
        //return (slide == slideView.getSlide() && ordinalNumber == slideView.getOrdinalNumber());
    }

    @Override
    public void update(Object notification, NotifyType type) {
        if (notification instanceof Slot slot)
        {
            if (type == NotifyType.AddSlot)
            {
                SlotView slotView = new SlotView(slot);
                if (mini)
                {
                    slotView.setHeight(slotView.getSlot().getHeight()/3);
                    slotView.setWidth(slotView.getSlot().getWidth()/3);
                    slotView.setX(slotView.getSlot().getX()/3-5);
                    slotView.setY(slotView.getSlot().getY()/3-5);
                }
                slotViews.add(slotView);
                repaint();
            }
            else if (type == NotifyType.RemoveSlot)
            {
                for (SlotView slotView : slotViews)
                {
                    if (slotView.getSlot().equals((Slot)notification))
                    {
                        slotViews.remove(slotView);
                        repaint();
                        break;
                    }
                }
            }
        }
    }

    public Slide getSlide() {
        return slide;
    }

    public JLabel getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(int ordinalNumber) {
        this.ordinalNumber.setText(String.valueOf(ordinalNumber));
    }

    public List<SlotView> getSlotViews() {
        return slotViews;
    }

    public void setMini(boolean mini) {
        this.mini = mini;
    }
}
