package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoadContextView extends JDialog {
    private JButton openWorkSpace;
    private JButton newProject;

    public LoadContextView() {
        super(MainView.getInstance(), "Open", true);
        setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/ 6, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/ 12));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        openWorkSpace = new JButton(MainView.getInstance().getActionManager().getOpenWorkSpaceAction());
        newProject = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        newProject.setText("New project");

        add(openWorkSpace);
        add(newProject);
    }
}
