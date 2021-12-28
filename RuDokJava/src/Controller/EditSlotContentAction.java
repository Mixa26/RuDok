package Controller;

import Model.Slot;
import View.MainView;
import View.PresentationView;
import View.TextEditorView;
import View.userErrorHandler.ErrorFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class EditSlotContentAction extends AbstractRudokAction{
    public EditSlotContentAction() {
        putValue(NAME, "Edit slot content");
        putValue(SMALL_ICON, loadIcon("images/editPresentation.png"));
        putValue(SHORT_DESCRIPTION, "Edit content of a slot depending on it's type.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView) MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        if (presentationView.getSlotSelected() != null)
        {
            if (presentationView.getSlotSelected().getType() == Slot.type.Text)
            {
                if (presentationView.getSlotSelected().getSlotHandler().getContent() !=null) {
                    presentationView.getTextEditorView().getjTextPane().setText(presentationView.getSlotSelected().getSlotHandler().getContent());
                }
                else
                {
                    presentationView.getTextEditorView().getjTextPane().setText("");
                }
                presentationView.getTextEditorView().setVisible(true);
                //TODO edit teksta ovde uz oslonac na JTEXTPANE
            }
            else
            {
                JFileChooser jFileChooser = new JFileChooser();
                int response = jFileChooser.showOpenDialog(MainView.getIntance().getActionManager().getEditPresentationAction().getEditPresentationView());

                if (response == JFileChooser.APPROVE_OPTION)
                {
                    File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());

                    presentationView.getSlotSelected().getSlotHandler().setContent(file.toString());
                }
            }
        }
        else
        {
            MainView.getIntance().getErrorFactory().createError(ErrorFactory.ErrorType.EditSlotError);
        }
    }
}
