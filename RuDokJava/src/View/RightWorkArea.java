package View;

import Model.treeModel.*;
import observer.ISubscriber;
import observer.NotifyType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RightWorkArea extends JPanel implements ISubscriber {

    private Project project;

    private Label projectName;
    private JTabbedPane jTabbedPane;

    private List<PresentationView> childrenView;

    public RightWorkArea()
    {
        childrenView = new ArrayList<PresentationView>();
        setLayout(new BorderLayout());
        projectName = new Label();
        projectName.setFont(new Font("Aerial", Font.BOLD, 20));

        jTabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    public void openProject(Project project) {
        ((WorkSpace)project.getParent()).addSubscriber(this);
        this.project = project;
        this.project.addSubscriber(this);
        project.addSubscriber(this);

        projectName.setText(project.getName());

        add(projectName, BorderLayout.NORTH);
        add(jTabbedPane, BorderLayout.CENTER);
        jTabbedPane.removeAll();

        for (int i = 0; i < project.getChildren().size(); i++)
        {
            PresentationView presentationView = new PresentationView((Presentation)project.getChildren().get(i));
            childrenView.add(presentationView);
            ((Presentation) project.getChildren().get(i)).addSubscriber(presentationView);
            ((Presentation) project.getChildren().get(i)).addSubscriber(this);
            jTabbedPane.addTab(project.getChildren().get(i).getName(), presentationView);
        }

        validate();
    }

    @Override
    public void update(Object notification, NotifyType type) {

        if (notification instanceof Project)
        {
            if (type == NotifyType.AddPresentation)
            {
                int index = ((Project) notification).getChildren().size() - 1;
                PresentationView presentationView = new PresentationView((Presentation) ((Project) notification).getChildren().get(index));
                childrenView.add(presentationView);
                //((Presentation) ((Project) notification).getChildren().get(index)).addSubscriber(presentationView);
                ((Presentation) ((Project) notification).getChildren().get(index)).addSubscriber(this);
                jTabbedPane.addTab(((Project) notification).getChildren().get(index).getName(), presentationView);
            }
            else if (type == NotifyType.RenameProject)
            {
                projectName.setText(((Project) notification).getName());
            }
            else if (type == NotifyType.DeleteProject)
            {
                if (project.equals((Project)notification))
                {
                    removeAll();
                }
            }
            validate();

            return;
        }
        else if (notification instanceof Presentation)
        {
            if (type == NotifyType.RemovePresentation)
            {
                Iterator<PresentationView> iterator = childrenView.iterator();
                while(iterator.hasNext())
                {
                    PresentationView curr = iterator.next();
                    if (curr.compareTo(new PresentationView((Presentation) notification)))
                    {
                        jTabbedPane.remove(curr);
                        iterator.remove();
                        break;
                    }
                }
                validate();
            }
            else if (type == NotifyType.RenamePresentation)
            {
                int index = ((Project) ((Presentation) notification).getParent()).getChildren().indexOf(notification);
                jTabbedPane.setTabComponentAt(index, new JLabel(((Presentation) notification).getName()));
            }
            validate();

            return;
        }
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }
}
