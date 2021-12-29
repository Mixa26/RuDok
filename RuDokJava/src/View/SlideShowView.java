package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlideShowView extends JPanel {

    private JToolBar myToolBar;
    private JButton endSlideShowView;

    private JButton previous;
    private JPanel slideShow;
    private JButton next;

    public SlideShowView() {
        myToolBar = new JToolBar();
        previous = new JButton("<");
        slideShow = new JPanel();
        next = new JButton(">");

        //dodat kod da dugmici budu iste velicine kao end slideshowview dugme
        previous.setMaximumSize(new Dimension(45, 45));
        next.setMaximumSize(new Dimension(45, 45));

        setLayout(new BorderLayout());

        CardLayout crd = new CardLayout();
        slideShow.setLayout(crd);

        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crd.previous(slideShow);
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crd.next(slideShow);
            }
        });

        for (SlideView slideViewSlideShow : ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getChildrenViewSlideShow())
        {
            slideShow.add(slideViewSlideShow);
        }

        //add(previous, BorderLayout.WEST);
        add(slideShow, BorderLayout.CENTER);
        //add(next, BorderLayout.EAST);
        endSlideShowView = new JButton(MainView.getInstance().getActionManager().getSwitchEditViewStateAction());
        endSlideShowView.setText("");

        myToolBar.add(endSlideShowView, "North");
        myToolBar.add(previous);
        myToolBar.add(next);
        myToolBar.setFloatable(false);
        add(myToolBar, BorderLayout.NORTH);
    }

    public JPanel getSlideShow() {
        return slideShow;
    }
}
