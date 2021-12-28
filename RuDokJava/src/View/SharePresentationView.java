package View;

import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.RuNodeComposite;
import View.treeSwingGUI.model.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SharePresentationView extends JDialog {
    private JPanel scrollProjects;
    private JScrollPane jScrollPane;
    private JButton submit;
    public Project sharedProject;

    public SharePresentationView() {
        setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 8, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 7));
        setLocationRelativeTo(MainView.getIntance());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Share a presentation with");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        scrollProjects = new JPanel();
        scrollProjects.setLayout(new BoxLayout(scrollProjects, BoxLayout.Y_AXIS));
        jScrollPane = new JScrollPane(scrollProjects);

        submit = new JButton(MainView.getIntance().getActionManager().getSubmitSharePresentation());
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(jScrollPane);
        add(submit);
    }

    public void loadProjects()
    {
        for (RuNode project : ((RuNodeComposite)((MyTreeNode)MainView.getIntance().getMyTree().getModel().getRoot()).getNode()).getChildren())
        {
            if (!((Project)project == ((MyTreeNode)MainView.getIntance().getMyTree().getSelectionPath().getLastPathComponent()).getNode().getParent()))
            {
                ClickableProjectButton proj = new ClickableProjectButton((Project) project);
                ((JButton)proj).setText(project.getName());
                proj.setAlignmentX(Component.CENTER_ALIGNMENT);
                proj.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sharedProject = proj.getProject();
                    }
                });
                scrollProjects.add(proj);
            }
        }

    }
}
