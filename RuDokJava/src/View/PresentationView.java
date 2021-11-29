package View;

import Model.treeModel.Presentation;
import Model.treeModel.Slide;
import observer.ISubscriber;
import observer.NotifyType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.*;

public class PresentationView extends JPanel implements ISubscriber {

    private Presentation presentation;
    private JPanel rightSlider;
    private JPanel leftSlider;
    private JScrollPane jScrollPaneR;
    private JScrollPane jScrollPaneL;
    private JLabel author;
    private List<SlideView> childrenView;
    private List<SlideView> childrenViewL;

    int slideSeparationHeight;

    public PresentationView(Presentation presentation)
    {
        this.presentation = presentation;
        this.presentation.addSubscriber(this);
        presentation.addSubscriber(this);

        childrenView = new ArrayList<SlideView>();
        childrenViewL = new ArrayList<SlideView>();

        slideSeparationHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 65;

        rightSlider = new JPanel();
        rightSlider.setLayout(new BoxLayout(rightSlider, BoxLayout.Y_AXIS));
        rightSlider.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftSlider = new JPanel();
        leftSlider.setLayout(new BoxLayout(leftSlider, BoxLayout.Y_AXIS));
        leftSlider.setAlignmentX(Component.CENTER_ALIGNMENT);

        author = new JLabel(presentation.getAuthor());
        author.setFont(new Font("Aerial", Font.BOLD, 20));
        author.setAlignmentX(Component.CENTER_ALIGNMENT);

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new BorderLayout());

        rightSlider.add(author);

        for (int i = 0; i < presentation.getChildren().size(); i++)
        {
            SlideView slideView = new SlideView((Slide)presentation.getChildren().get(i));
            childrenView.add(slideView);
            rightSlider.add(slideView);
            rightSlider.add(Box.createVerticalStrut(slideSeparationHeight));

            SlideView slideViewL = new SlideView((Slide)presentation.getChildren().get(i));
            slideViewL.setMaximumSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10));
            slideViewL.setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10));
            childrenViewL.add(slideViewL);
            leftSlider.add(slideViewL);
            leftSlider.add(Box.createVerticalStrut(slideSeparationHeight));
        }

        jScrollPaneR = new JScrollPane(rightSlider);
        jScrollPaneL = new JScrollPane(leftSlider);
        jScrollPaneL.setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 9), (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 9)));
        add(jScrollPaneR, BorderLayout.CENTER);
        add(jScrollPaneL, BorderLayout.WEST);
    }

    @Override
    public void update(Object notification, NotifyType type) {
        if (notification instanceof Slide) {
            if (type == NotifyType.RemoveSlide) {
                Iterator<SlideView> iterator = childrenView.iterator();
                while (iterator.hasNext()) {
                    SlideView curr = (SlideView) iterator.next();
                    if ((curr).compareTo(new SlideView((Slide) notification))) {
                        int index = childrenView.indexOf(curr);
                        index = index * 2 + 2;
                        rightSlider.remove(index);
                        rightSlider.remove(curr);
                        leftSlider.remove(index-1);
                        leftSlider.remove(index-2);
                        iterator.remove();
                        break;
                    }

                }
            }

            SwingUtilities.updateComponentTreeUI(MainView.getIntance());

            for (SlideView slideView : childrenView) {
                slideView.repaint();
            }

            for (SlideView slideView : childrenViewL) {
                slideView.repaint();
            }
            /*
            int i = 1;
            for (Component component : rightSlider.getComponents())
            {
                if (component instanceof SlideView)
                {
                    if ((SlideView)component == (childrenView.get(i)))
                    {
                        (SlideView)((SlideView) component).getSlide().setOrdinalNumber();
                    }
                }
            }
            */
            validate();
        }
        else if (notification instanceof Presentation)
        {
            if (type == NotifyType.AddSlide)
            {
                int index = ((Presentation) notification).getChildren().size() - 1;
                SlideView slideView = new SlideView((Slide) presentation.getChildren().get(index));
                childrenView.add(slideView);
                rightSlider.add(slideView);
                rightSlider.add(Box.createVerticalStrut(slideSeparationHeight));

                SlideView slideViewL = new SlideView((Slide) presentation.getChildren().get(index));
                slideViewL.setMaximumSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10));
                slideViewL.setPreferredSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 10));
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

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public List<SlideView> getChildrenView() {
        return childrenView;
    }
}
