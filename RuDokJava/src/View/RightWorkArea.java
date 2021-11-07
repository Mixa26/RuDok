package View;

import Model.treeModel.Presentation;
import Model.treeModel.Project;
import Model.treeModel.Slide;

import javax.swing.*;
import java.awt.*;

public class RightWorkArea extends JPanel {

    private Project project;

    private Label projectName;
    private JTabbedPane jTabbedPane;

    public RightWorkArea()
    {
        setLayout(new BorderLayout());
        projectName = new Label();
        projectName.setFont(new Font("Aerial", Font.BOLD, 20));

        jTabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    public void openProject(Project project) {
        this.project = project;
        projectName.setText(project.getName());

        add(projectName, BorderLayout.NORTH);
        add(jTabbedPane, BorderLayout.CENTER);
        jTabbedPane.removeAll();

        for (int i = 0; i < project.getChildren().size(); i++)
        {
            PresentationView presentationView = new PresentationView((Presentation)project.getChildren().get(i));
            jTabbedPane.addTab(project.getChildren().get(i).getName(), presentationView);
        }

        validate();
    }

}
