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
        super(MainView.getInstance(),"Share a presentation with",true);
        setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 8, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 7));
        setLocationRelativeTo(MainView.getInstance());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setAlwaysOnTop(true);


        scrollProjects = new JPanel();
        scrollProjects.setLayout(new BoxLayout(scrollProjects, BoxLayout.Y_AXIS));
        jScrollPane = new JScrollPane(scrollProjects);

        submit = new JButton(MainView.getInstance().getActionManager().getSubmitSharePresentation());
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(jScrollPane);
        add(submit);
    }

    public void loadProjects()
    {
        scrollProjects.removeAll();
        for (RuNode project : ((RuNodeComposite)((MyTreeNode)MainView.getInstance().getMyTree().getModel().getRoot()).getNode()).getChildren())
        {
            if (!((Project)project == ((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode().getParent()))
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
