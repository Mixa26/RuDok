package View;

import Model.Slot;
import View.userErrorHandler.ErrorFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MultimediaEditorView extends JDialog {
    private JButton open;
    private JButton submit;
    private File file;
    private JToolBar buttons;
    private JPanel picture;
    private String imagePreview;
    private Slot slot;

    public MultimediaEditorView() {
        setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 5, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 4));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(MainView.getInstance());
        setTitle("Picture selector");
        setLayout(new BorderLayout());

        buttons = new JToolBar();
        buttons.setFloatable(false);
        picture = new JPanel();

        open = new JButton("Open");

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                int response = jFileChooser.showOpenDialog(MainView.getInstance().getActionManager().getEditPresentationAction().getEditPresentationView());

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
                    ((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent()).getSlotSelected().getSlotHandler().setContent(file.toString());
                    setVisible(false);
                }
                else
                {
                    MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.InvalidImageError);
                }
            }
        });

        buttons.add(open);
        buttons.add(submit);
        add(buttons, BorderLayout.NORTH);
        add(picture, BorderLayout.CENTER);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (new ImageIcon(imagePreview).getImage() != null)
        {
            Image image = new ImageIcon(imagePreview).getImage();

            g.drawImage((image), 0, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/17 , getWidth(), getHeight()-(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/17, null);
        }
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void setImagePreview(String imagePreview) {
        this.imagePreview = imagePreview;
    }
}
