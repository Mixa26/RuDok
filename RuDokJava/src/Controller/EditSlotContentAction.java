package Controller;

import Model.Slot;
import View.MainView;
import View.PresentationView;
import View.userErrorHandler.ErrorFactory;

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
                    presentationView.getTextEditorView().getjTextPane().setText(presentationView.getSlotSelected().getSlotHandler().getContent());
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
