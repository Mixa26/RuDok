package View;

import Model.Main;
import Model.Slot;
import Model.treeModel.Presentation;
import Model.treeModel.Slide;
import observer.ISubscriber;
import observer.NotifyType;
import state.SlotBorderStrokeState.SplitStrokeState;
import state.SlotBorderStrokeState.StrokeStateManager;
import state.SlotState.SlotStateManager;
import state.SlotState.StateMouseListener;
import state.SlotState.StateMouseMotionListener;
import state.State;
import state.StateManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.*;

public class PresentationView extends JPanel implements ISubscriber {

    private Presentation presentation;
    private JPanel main;
    private SlideShowView ssv;
    private JPanel rightSlider;
    private JPanel leftSlider;
    private JScrollPane jScrollPaneR;
    private JScrollPane jScrollPaneL;
    private JLabel author;
    private List<SlideView> childrenView;
    private List<SlideView> childrenViewL;
    private List<SlideView> childrenViewSlideShow;

    private StateManager stateManager;
    private SlotStateManager slotStateManager;
    private StrokeStateManager strokeStateManager;
    private JButton endSlideShowView;
    private JButton addSlot;
    private JButton deleteSlot;
    private JButton dragDropSlot;
    private JButton switchStroke;
    private JButton colorPick;
    private JToolBar myToolBar;

    private float strokeWidth;
    private Stroke stroke;

    ColorPickerView colorPickerView;
    private Color pickedColor;

    int slideSeparationHeight;

    public PresentationView(Presentation presentation)
    {
        stroke = new BasicStroke(strokeWidth);

        colorPickerView = new ColorPickerView();
        pickedColor = new Color(255, 0, 0, 100);
        strokeWidth = 1.0f;

        this.presentation = presentation;
        this.presentation.addSubscriber(this);
        presentation.addSubscriber(this);

        stateManager = new StateManager();
        slotStateManager = new SlotStateManager();
        strokeStateManager = new StrokeStateManager();
        myToolBar = new JToolBar();

        childrenView = new ArrayList<SlideView>();
        childrenViewL = new ArrayList<SlideView>();
        childrenViewSlideShow = new ArrayList<SlideView>();

        slideSeparationHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 65;

        main = new JPanel();
        main.setLayout(new BorderLayout());

        rightSlider = new JPanel();
        rightSlider.setLayout(new BoxLayout(rightSlider, BoxLayout.Y_AXIS));
        rightSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightSlider.setBackground(Color.WHITE);

        leftSlider = new JPanel();
        leftSlider.setLayout(new BoxLayout(leftSlider, BoxLayout.Y_AXIS));
        leftSlider.setAlignmentX(Component.CENTER_ALIGNMENT);

        author = new JLabel(presentation.getAuthor());
        author.setFont(new Font("Aerial", Font.BOLD, 20));
        author.setAlignmentX(Component.CENTER_ALIGNMENT);

        setLayout(new BorderLayout());

        rightSlider.add(author);

        for (int i = 0; i < presentation.getChildren().size(); i++)
        {
            Slide slide = (Slide)presentation.getChildren().get(i);
            SlideView slideView = new SlideView(slide, false);
            slide.addSubscriber(slideView);
            slideView.setBorder(BorderFactory.createLineBorder(Color.white, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 100)));
            slideView.addMouseListener(new StateMouseListener(slideView.getSlide()));
            slideView.addMouseMotionListener(new StateMouseMotionListener(slideView.getSlide()));
            childrenView.add(slideView);
            rightSlider.add(slideView);
            //rightSlider.add(Box.createVerticalStrut(slideSeparationHeight));

            SlideView slideViewSlideShow = new SlideView(slide, false);
            slide.addSubscriber(slideViewSlideShow);
            childrenViewSlideShow.add(slideViewSlideShow);

            SlideView slideViewL = new SlideView(slide, true);
            slide.addSubscriber(slideViewL);
            slideViewL.setMaximumSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10));
            slideViewL.setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10));
            //slideViewL.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 130)));
            childrenViewL.add(slideViewL);
            leftSlider.add(slideViewL);
            leftSlider.add(Box.createVerticalStrut(slideSeparationHeight));
        }

        jScrollPaneR = new JScrollPane(rightSlider);
        jScrollPaneL = new JScrollPane(leftSlider);
        jScrollPaneL.setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 9), (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 9)));

        endSlideShowView = new JButton(MainView.getIntance().getActionManager().getSwitchEditViewStateAction());
        endSlideShowView.setText("");

        addSlot = new JButton(MainView.getIntance().getActionManager().getAddSlotStateAction());
        addSlot.setText("");
        deleteSlot = new JButton(MainView.getIntance().getActionManager().getDeleteSlotStateAction());
        deleteSlot.setText("");
        dragDropSlot = new JButton(MainView.getIntance().getActionManager().getDragDropSlotStateAction());
        dragDropSlot.setText("");
        switchStroke = new JButton(MainView.getIntance().getActionManager().getSelectBorderStrokeAction());
        switchStroke.setText("");
        colorPick = new JButton(MainView.getIntance().getActionManager().getOpenColorPickerAction());
        colorPick.setText("");

        myToolBar.add(endSlideShowView, "North");
        myToolBar.add(addSlot, "North");
        myToolBar.add(deleteSlot, "North");
        myToolBar.add(dragDropSlot, "North");
        myToolBar.add(switchStroke, "North");
        myToolBar.add(colorPick, "North");
        main.add(myToolBar, BorderLayout.NORTH);

        main.add(jScrollPaneR, BorderLayout.CENTER);
        main.add(jScrollPaneL, BorderLayout.WEST);
        add(main);
    }

    @Override
    public void update(Object notification, NotifyType type) {
        if (notification instanceof Slide) {
            if (type == NotifyType.RemoveSlide) {
                Iterator<SlideView> iterator = childrenView.iterator();
                while (iterator.hasNext()) {
                    SlideView curr = (SlideView) iterator.next();
                    if ((curr).compareTo(new SlideView((Slide) notification, false))) {
                        int index = childrenView.indexOf(curr);
                        index = index * 2 + 2;
                        //rightSlider.remove(index);
                        rightSlider.remove(curr);
                        leftSlider.remove(index-1);
                        leftSlider.remove(index-2);
                        if (ssv != null)
                        {
                            ssv.getSlideShow().remove((index - 2) / 2);
                        }
                        childrenViewSlideShow.remove((index-2)/2);
                        childrenViewL.remove((index-2)/2);
                        iterator.remove();
                        break;
                    }
                }
            }

            SwingUtilities.updateComponentTreeUI(MainView.getIntance());

            for (SlideView slideView : childrenView) {
                //update za redne brojeve slajdova na viewu
                int index = childrenView.indexOf(slideView);
                slideView.getSlide().setOrdinalNumber(index+1);
                slideView.setOrdinalNumber(index+1);
                slideView.repaint();
            }

            for (SlideView slideViewL : childrenViewL) {
                slideViewL.setOrdinalNumber(slideViewL.getSlide().getOrdinalNumber());

            }

            for(SlideView slideViewSlideShow : childrenViewSlideShow)
            {
                slideViewSlideShow.setOrdinalNumber(slideViewSlideShow.getSlide().getOrdinalNumber());
            }

            if (ssv!=null)
            {
                ssv.validate();
            }
            validate();
        }
        else if (notification instanceof Presentation)
        {
            if (type == NotifyType.AddSlide)
            {
                int index = ((Presentation) notification).getChildren().size() - 1;
                Slide slide = (Slide) presentation.getChildren().get(index);
                SlideView slideView = new SlideView(slide, false);
                slide.addSubscriber(slideView);
                slideView.setBorder(BorderFactory.createLineBorder(Color.white, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 100)));
                slideView.addMouseListener(new StateMouseListener(slideView.getSlide()));
                slideView.addMouseMotionListener(new StateMouseMotionListener(slideView.getSlide()));
                childrenView.add(slideView);
                rightSlider.add(slideView);
                //rightSlider.add(Box.createVerticalStrut(slideSeparationHeight));

                SlideView slideViewSlideShow = new SlideView(slide, false);
                slide.addSubscriber(slideViewSlideShow);
                childrenViewSlideShow.add(slideViewSlideShow);
                if (ssv != null)
                {
                    ssv.getSlideShow().add(slideViewSlideShow);
                }

                SlideView slideViewL = new SlideView(slide, true);
                slideViewL.setMini(true);
                slide.addSubscriber(slideViewL);
                slideViewL.setMaximumSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10));
                slideViewL.setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10));
                //slideViewL.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 130)));
                childrenViewL.add(slideViewL);
                leftSlider.add(slideViewL);
                leftSlider.add(Box.createVerticalStrut(slideSeparationHeight));
            }
            else if (type == NotifyType.EditPresentation)
            {
                author.setText(((Presentation) notification).getAuthor());
                presentation.setBackgroundImage(((Presentation) notification).getBackgroundImage());
            }

            for (SlideView slideView : childrenView)
            {
                slideView.repaint();
            }

            for (SlideView slideView : childrenViewL) {
                slideView.repaint();
            }

            validate();

            return;
        }
    }

    public boolean compareTo(PresentationView presentationView)
    {
        return presentationView.getPresentation().equals(this.presentation);
    }

    public void startEditProjectState()
    {
        stateManager.setEditProjectState();
    }

    public void startSlideShowState()
    {
        stateManager.setSlideShowState();
    }

    public State getSState()
    {
        return stateManager.getCurrentState();
    }

    public void startAddSlotState()
    {
        slotStateManager.setAddSlotState();
    }

    public void startDeleteSlotState()
    {
        slotStateManager.setDeleteSlotState();
    }

    public void startDragDropSlotState()
    {
        slotStateManager.setDragDropSlotState();
    }

    public void SlotStateMouseClicked(int x, int y, Slide slide)
    {
        slotStateManager.getCurrentState().mouseClicked(x,y,slide);
    }

    public void SlotStateMousePressed(int x, int y,Slide slide)
    {
        slotStateManager.getCurrentState().mousePressed(x,y, slide);
    }

    public void SlotStateMouseDraged(int x, int y, Slide slide)
    {
        slotStateManager.getCurrentState().mouseDraged(x, y, slide);
    }

    public void startFullStrokeState()
    {
        strokeStateManager.setFullStrokeState();
    }

    public void startSplitStrokeState()
    {
        strokeStateManager.setSplitStrokeState();
    }

    public State getStrokeState()
    {
        return strokeStateManager.getCurrentState();
    }

    public void SlotStateMouseReleased(Slide slide)
    {
        slotStateManager.getCurrentState().mouseReleased(slide);
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public List<SlideView> getChildrenView() {
        return childrenView;
    }

    public List<SlideView> getChildrenViewSlideShow() {
        return childrenViewSlideShow;
    }

    public JPanel getMain() {
        return main;
    }

    public SlideShowView getSsv() {
        return ssv;
    }

    public void setSsv(SlideShowView ssv) {
        this.ssv = ssv;
    }

    public void setPickedColor(Color pickedColor) {
        this.pickedColor = pickedColor;
    }

    public ColorPickerView getColorPickerView() {
        return colorPickerView;
    }

    public Color getPickedColor() {
        return pickedColor;
    }

    public float getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }
}
