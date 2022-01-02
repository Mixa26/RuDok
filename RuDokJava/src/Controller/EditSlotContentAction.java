package Controller;

import Model.Slot;
import Model.slotHandler.TextSlotHandler;
import View.MainView;
import View.PresentationView;
import Model.userErrorHandler.ErrorFactory;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class EditSlotContentAction extends AbstractRudokAction{
    public EditSlotContentAction() {
        putValue(NAME, "Edit slot content");
        putValue(SMALL_ICON, loadIcon("images/editSlot.png"));
        putValue(SHORT_DESCRIPTION, "Edit content of a slot depending on it's type.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView) MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        if (presentationView.getSlotSelected() != null)
        {
            if (presentationView.getSlotSelected().getType() == Slot.type.Text)
            {
                if (presentationView.getSlotSelected().getSlotHandler().getContent() !=null) {

                    String text = presentationView.getSlotSelected().getContent();
                    Slot slot = presentationView.getSlotSelected();
                    JTextPane jTextPane = ((PresentationView)(MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent())).getTextEditorView().getjTextPane();
                    jTextPane.setText("");
                    Document doc = jTextPane.getStyledDocument();
                    for (int i = 0; i < text.length(); i++)
                    {
                        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
                        if (((TextSlotHandler)slot.getSlotHandler()).getCharStyle().get(i).isBold())
                        {
                            StyleConstants.setBold(attributeSet, true);
                        }
                        if (((TextSlotHandler)slot.getSlotHandler()).getCharStyle().get(i).isItalic())
                        {
                            StyleConstants.setItalic(attributeSet, true);
                        }
                        if (((TextSlotHandler)slot.getSlotHandler()).getCharStyle().get(i).isUnderline())
                        {
                            StyleConstants.setUnderline(attributeSet, true);
                        }

                        jTextPane.setCharacterAttributes(attributeSet,true);
                        try {
                            doc.insertString(doc.getLength(), text.charAt(i) + "", attributeSet);
                        }
                        catch (BadLocationException e1)
                        {
                            e1.printStackTrace();
                        }
                    }

                    //presentationView.getTextEditorView().getjTextPane().setText(presentationView.getSlotSelected().getSlotHandler().getContent());
                }
                else
                {
                    presentationView.getTextEditorView().getjTextPane().setText("");
                }
                presentationView.getTextEditorView().setVisible(true);
            }
            else
            {
                presentationView.getMultimediaEditorView().resetFile();
                presentationView.getMultimediaEditorView().setImagePreview(presentationView.getSlotSelected().getContent());
                presentationView.getMultimediaEditorView().setVisible(true);
//                JFileChooser jFileChooser = new JFileChooser();
//                int response = jFileChooser.showOpenDialog(MainView.getIntance().getActionManager().getEditPresentationAction().getEditPresentationView());
//
//                if (response == JFileChooser.APPROVE_OPTION)
//                {
//                    File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
//
//                    presentationView.getSlotSelected().getSlotHandler().setContent(file.toString());
//                }
            }
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.EditSlotError);
        }
    }
}
