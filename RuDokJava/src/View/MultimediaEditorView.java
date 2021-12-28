package View;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MultimediaEditorView extends JDialog {
    private JButton open;
    private JButton submit;
    private int x;
    private int y;
    private File file;

    public MultimediaEditorView() {
        setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 7, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 4));
        x = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 20;
        y = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10;
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(MainView.getIntance());
        setLayout(new BorderLayout());

        open = new JButton("Open");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                int response = jFileChooser.showOpenDialog(MainView.getIntance().getActionManager().getEditPresentationAction().getEditPresentationView());

                if (response == JFileChooser.APPROVE_OPTION)
                {
                    file = new File(jFileChooser.getSelectedFile().getAbsolutePath());


                }
            }
        });

        submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getSlotSelected().getSlotHandler().setContent(file.toString());
            }
        });

        add(open, BorderLayout.NORTH);

        add(submit, BorderLayout.SOUTH);
    }
}
