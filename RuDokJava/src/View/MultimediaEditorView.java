package View;

import Model.Slot;
import View.userErrorHandler.ErrorFactory;
import View.userErrorHandler.InvalidImageError;

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
    private JPanel buttons;
    private JPanel picture;
    private String imagePreview;
    private Slot slot;

    public MultimediaEditorView() {
        setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 7, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 4));
        x = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 50;
        y = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 50;
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(MainView.getIntance());
        setLayout(new BorderLayout());

        buttons = new JPanel();
        picture = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        open = new JButton("Open");

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                int response = jFileChooser.showOpenDialog(MainView.getIntance().getActionManager().getEditPresentationAction().getEditPresentationView());

                if (response == JFileChooser.APPROVE_OPTION)
                {
                    file = new File(jFileChooser.getSelectedFile().getAbsolutePath());

                    imagePreview = file.toString();
                    repaint();
                }
            }
        });

        submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (file != null)
                {
                    ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getSlotSelected().getSlotHandler().setContent(file.toString());
                    setVisible(false);
                }
                else
                {
                    MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.InvalidImageError);
                }
            }
        });

        buttons.add(open);
        buttons.add(submit);

        add(picture, BorderLayout.WEST);

        add(buttons, BorderLayout.EAST);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (new ImageIcon(imagePreview).getImage() != null)
        {
            Image image = new ImageIcon(imagePreview).getImage();

            g.drawImage((image), x, y, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 13, (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 13, null);
        }
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void setImagePreview(String imagePreview) {
        this.imagePreview = imagePreview;
    }
}
