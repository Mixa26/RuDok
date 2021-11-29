package View;

import Model.treeModel.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlideShowView extends JPanel {

    private Project project;
    private int selectedTab;

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

        for (SlideView slideView : ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getChildrenView())
        {
            slideShow.add(slideView);
        }

        add(previous, BorderLayout.WEST);
        add(slideShow, BorderLayout.CENTER);
        add(next, BorderLayout.EAST);

        endSlideShowView = new JButton(MainView.getIntance().getActionManager().getSwitchEditViewStateAction());
        endSlideShowView.setText("");

        myToolBar.add(endSlideShowView, "North");
        add(myToolBar, BorderLayout.NORTH);
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setSelectedTab(int selectedTab) {
        this.selectedTab = selectedTab;
    }

    public int getSelectedTab() {
        return selectedTab;
    }
}
