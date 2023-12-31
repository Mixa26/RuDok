package View;

import Model.Slot;
import Model.treeModel.Presentation;
import Model.treeModel.Slide;
import Model.observer.ISubscriber;
import Model.observer.NotifyType;
import Model.state.SlotBorderStrokeState.StrokeStateManager;
import Model.state.SlotBorderWidth.BorderWidthStateManager;
import Model.state.SlotState.SlotStateManager;
import Model.state.SlotState.StateMouseListener;
import Model.state.SlotState.StateMouseMotionListener;
import Model.state.SlotTypeState.SlotTypeStateManager;
import Model.state.WorkModeState.State;
import Model.state.WorkModeState.StateManager;

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
    private BorderWidthStateManager borderWidthStateManager;
    private SlotTypeStateManager slotTypeStateManager;

    private JButton endSlideShowView;
    private JButton addSlot;
    private JButton deleteSlot;
    private JButton dragDropSlot;
    private JButton switchStroke;
    private JButton switchBorder;
    private JButton colorPick;
    private JButton changeSlotType;
    private JButton editSlotContent;
    private JToolBar myToolBar;

    private float strokeWidth;
    private Stroke stroke;

    ColorPickerView colorPickerView;
    private Color pickedColor;
    private Slot.type slotType;
    private Slot slotSelected;
    TextEditorView textEditorView;
    MultimediaEditorView multimediaEditorView;

    int slideSeparationHeight;

    public PresentationView(Presentation presentation)
    {
        stroke = new BasicStroke(strokeWidth);

        colorPickerView = new ColorPickerView();
        pickedColor = new Color(255, 255, 255, 100);
        strokeWidth = 1.0f;
        slotType = Slot.type.Text;
        textEditorView = new TextEditorView();
        multimediaEditorView = new MultimediaEditorView();

        this.presentation = presentation;
        this.presentation.addSubscriber(this);
        presentation.addSubscriber(this);

        stateManager = new StateManager();
        slotStateManager = new SlotStateManager();
        strokeStateManager = new StrokeStateManager();
        borderWidthStateManager = new BorderWidthStateManager();
        slotTypeStateManager = new SlotTypeStateManager();

        myToolBar = new JToolBar();
        myToolBar.setFloatable(false);

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
            SlideView slideView = new SlideView(slide, false, false);
            slide.addSubscriber(slideView);
            slideView.setBorder(BorderFactory.createLineBorder(Color.white, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 100)));
            slideView.addMouseListener(new StateMouseListener(slideView.getSlide()));
            slideView.addMouseMotionListener(new StateMouseMotionListener(slideView.getSlide()));
            childrenView.add(slideView);
            rightSlider.add(slideView);
            //rightSlider.add(Box.createVerticalStrut(slideSeparationHeight));

            SlideView slideViewSlideShow = new SlideView(slide, false, true);
            slideViewSlideShow.setSlideShow(true);
            slide.addSubscriber(slideViewSlideShow);
            childrenViewSlideShow.add(slideViewSlideShow);

            SlideView slideViewL = new SlideView(slide, true, false);
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

        endSlideShowView = new JButton(MainView.getInstance().getActionManager().getSwitchEditViewStateAction());
        endSlideShowView.setText("");

        addSlot = new JButton(MainView.getInstance().getActionManager().getAddSlotStateAction());
        addSlot.setText("");
        deleteSlot = new JButton(MainView.getInstance().getActionManager().getDeleteSlotStateAction());
        deleteSlot.setText("");
        dragDropSlot = new JButton(MainView.getInstance().getActionManager().getDragDropSlotStateAction());
        dragDropSlot.setText("");
        switchStroke = new JButton(MainView.getInstance().getActionManager().getSelectBorderStrokeAction());
        switchStroke.setText("");
        switchBorder = new JButton(MainView.getInstance().getActionManager().getSwitchSlotWidthAction());
        switchBorder.setText("");
        colorPick = new JButton(MainView.getInstance().getActionManager().getOpenColorPickerAction());
        colorPick.setText("");
        changeSlotType = new JButton(MainView.getInstance().getActionManager().getChangeSlotTypeState());
        changeSlotType.setText("");
        editSlotContent = new JButton(MainView.getInstance().getActionManager().getEditSlotContent());
        editSlotContent.setText("");

        myToolBar.add(endSlideShowView, "North");
        myToolBar.add(addSlot, "North");
        myToolBar.add(deleteSlot, "North");
        myToolBar.add(dragDropSlot, "North");
        myToolBar.add(switchStroke, "North");
        myToolBar.add(switchBorder, "North");
        myToolBar.add(colorPick, "North");
        myToolBar.add(changeSlotType, "North");
        myToolBar.add(editSlotContent, "North");
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
                    if ((curr).compareTo(new SlideView((Slide) notification, false, false))) {
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

            SwingUtilities.updateComponentTreeUI(MainView.getInstance());

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
                SlideView slideView = new SlideView(slide, false, false);
                slide.addSubscriber(slideView);
                slideView.setBorder(BorderFactory.createLineBorder(Color.white, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 100)));
                slideView.addMouseListener(new StateMouseListener(slideView.getSlide()));
                slideView.addMouseMotionListener(new StateMouseMotionListener(slideView.getSlide()));
                childrenView.add(slideView);
                rightSlider.add(slideView);
                //rightSlider.add(Box.createVerticalStrut(slideSeparationHeight));

                SlideView slideViewSlideShow = new SlideView(slide, false, true);
                slideViewSlideShow.setSlideShow(true);
                slide.addSubscriber(slideViewSlideShow);
                childrenViewSlideShow.add(slideViewSlideShow);
                if (ssv != null)
                {
                    ssv.getSlideShow().add(slideViewSlideShow);
                }

                SlideView slideViewL = new SlideView(slide, true, false);
                slideViewL.setMini(true);
                slide.addSubscriber(slideViewL);
                slideViewL.setMaximumSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10));
                slideViewL.setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10));
                //slideViewL.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 130)));
                childrenViewL.add(slideViewL);
                leftSlider.add(slideViewL);
                leftSlider.add(Box.createVerticalStrut(slideSeparationHeight));

                for (SlideView slideViewa : childrenView) {
                    //update za redne brojeve slajdova na viewu
                    int indexa = childrenView.indexOf(slideViewa);
                    slideViewa.getSlide().setOrdinalNumber(indexa+1);
                    slideViewa.setOrdinalNumber(indexa+1);
                    slideViewa.repaint();
                }

                for (SlideView slideViewLa : childrenViewL) {
                    slideViewLa.setOrdinalNumber(slideViewLa.getSlide().getOrdinalNumber());

                }

                for(SlideView slideViewSlideShowa : childrenViewSlideShow)
                {
                    slideViewSlideShowa.setOrdinalNumber(slideViewSlideShowa.getSlide().getOrdinalNumber());
                }

                if (ssv!=null)
                {
                    ssv.validate();
                }
                validate();
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

    public void refreshSlotStateIcons()
    {
        slotStateManager.refreshIcons();
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

    public void SlotStateMouseReleased(Slide slide)
    {
        slotStateManager.getCurrentState().mouseReleased(slide);
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

    public void startSmallBorderState()
    {
        borderWidthStateManager.setSmallBorderState();
    }

    public void startMediumBorderState()
    {
        borderWidthStateManager.setMediumBorderState();
    }

    public void startBigBorderState()
    {
        borderWidthStateManager.setBigBorderState();
    }

    public State getBorderState()
    {
        return borderWidthStateManager.getCurrentState();
    }

    public void startMultimediaState()
    {
        slotTypeStateManager.setMultimediaState();
    }

    public void startTextState()
    {
        slotTypeStateManager.setTextState();
    }

    public State getSlotTypeState()
    {
        return slotTypeStateManager.getCurrentState();
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

    public Slot.type getSlotType() {
        return slotType;
    }

    public void setSlotType(Slot.type slotType) {
        this.slotType = slotType;
    }

    public Slot getSlotSelected() {
        return slotSelected;
    }

    public void setSlotSelected(Slot slotSelected) {
        this.slotSelected = slotSelected;
    }

    public TextEditorView getTextEditorView() {
        return textEditorView;
    }

    public MultimediaEditorView getMultimediaEditorView() {
        return multimediaEditorView;
    }
}
