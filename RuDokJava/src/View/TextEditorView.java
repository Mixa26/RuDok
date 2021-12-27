package View;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditorView extends JDialog {

    private JToolBar jToolBar;
    private JButton bold;
    private JButton italic;
    private JButton underline;

    private boolean boldEnabled;
    private boolean italicEnabled;
    private boolean underlineEnabled;

    private SimpleAttributeSet attributeSet;

    private JTextPane jTextPane;
    private JButton submitText;

    public TextEditorView() {
        setSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/ 8, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/ 8));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(MainView.getIntance());

        jToolBar = new JToolBar();

        attributeSet = new SimpleAttributeSet();

        bold = new JButton();
        bold.setIcon(new ImageIcon("RuDokJava/src/Controller/images/bold.png"));
        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boldEnabled)
                {
                    boldEnabled = false;
                    StyleConstants.setBold(attributeSet, true);
                    jTextPane.setCharacterAttributes(attributeSet,true);
                    bold.setIcon(new ImageIcon("RuDokJava/src/Controller/images/bold.png"));
                }
                else
                {
                    boldEnabled = true;
                    StyleConstants.setBold(attributeSet, false);
                    jTextPane.setCharacterAttributes(attributeSet,true);
                    bold.setIcon(new ImageIcon("RuDokJava/src/Controller/images/boldEnabled.png"));
                }
            }
        });

        italic = new JButton();
        italic.setIcon(new ImageIcon("RuDokJava/src/Controller/images/italic.png"));
        italic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (italicEnabled)
                {
                    italicEnabled = false;
                    StyleConstants.setItalic(attributeSet, true);
                    jTextPane.setCharacterAttributes(attributeSet,true);
                    italic.setIcon(new ImageIcon("RuDokJava/src/Controller/images/italic.png"));
                }
                else
                {
                    italicEnabled = true;
                    StyleConstants.setItalic(attributeSet, false);
                    jTextPane.setCharacterAttributes(attributeSet,true);
                    italic.setIcon(new ImageIcon("RuDokJava/src/Controller/images/italicEnabled.png"));
                }
            }
        });

        underline = new JButton();
        underline.setIcon(new ImageIcon("RuDokJava/src/Controller/images/underline.png"));
        underline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (underlineEnabled)
                {
                    underlineEnabled = false;
                    StyleConstants.setUnderline(attributeSet, true);
                    jTextPane.setCharacterAttributes(attributeSet,true);
                    underline.setIcon(new ImageIcon("RuDokJava/src/Controller/images/underline.png"));
                }
                else
                {
                    underlineEnabled = true;
                    StyleConstants.setUnderline(attributeSet, false);
                    jTextPane.setCharacterAttributes(attributeSet,true);
                    underline.setIcon(new ImageIcon("RuDokJava/src/Controller/images/underlineEnabled.png"));
                }
            }
        });

        boldEnabled = false;
        italicEnabled = false;
        underlineEnabled = false;

        jToolBar.add(bold);
        jToolBar.add(italic);
        jToolBar.add(underline);
        jToolBar.setFloatable(false);

        jTextPane = new JTextPane();
        submitText = new JButton(MainView.getIntance().getActionManager().getSlotAddTextAction());

        setLayout(new BorderLayout());

        add(jToolBar, BorderLayout.NORTH);
        add(jTextPane, BorderLayout.CENTER);
        add(submitText, BorderLayout.SOUTH);
    }

    public JTextPane getjTextPane() {
        return jTextPane;
    }
}
