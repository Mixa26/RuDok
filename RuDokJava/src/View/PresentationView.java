package View;

import Model.Main;
import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.Slide;
import View.treeSwingGUI.model.MyTreeNode;
import observer.ISubscriber;
import observer.NotifyType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.*;

public class PresentationView extends JPanel implements ISubscriber {

    private Presentation presentation;
    private JPanel panel;
    private JScrollPane jScrollPane;
    private JLabel author;
    private List<SlideView> childrenView;

    int slideSeparationHeight;

    public PresentationView(Presentation presentation)
    {
        this.presentation = presentation;
        this.presentation.addSubscriber(this);
        presentation.addSubscriber(this);

        childrenView = new ArrayList<SlideView>();

        slideSeparationHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 65;

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        author = new JLabel(presentation.getAuthor());
        author.setFont(new Font("Aerial", Font.BOLD, 20));
        author.setAlignmentX(Component.CENTER_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        panel.add(author);

        for (int i = 0; i < presentation.getChildren().size(); i++)
        {
            SlideView slideView = new SlideView((Slide)presentation.getChildren().get(i));
            childrenView.add(slideView);
            panel.add(slideView);
            panel.add(Box.createVerticalStrut(slideSeparationHeight));
        }

        jScrollPane = new JScrollPane(panel);
        add(jScrollPane);
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
                        panel.remove(index);
                        panel.remove(curr);
                        iterator.remove();
                        break;
                    }

                }
            }

            SwingUtilities.updateComponentTreeUI(MainView.getIntance());

            for (SlideView slideView : childrenView) {
                slideView.repaint();
            }
            /*
            int i = 1;
            for (Component component : panel.getComponents())
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
                panel.add(slideView);
                panel.add(Box.createVerticalStrut(slideSeparationHeight));
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
