package Controller;

import View.MainView;
import View.PresentationView;

import java.awt.event.ActionEvent;

public class SlotAddTextAction extends AbstractRudokAction{
    public SlotAddTextAction() {
        putValue(NAME, "Submit");
        putValue(SHORT_DESCRIPTION, "Puts text you typed here in a slot.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        presentationView.getSlotSelected().getSlotHandler().setContent(presentationView.getTextEditorView().getjTextPane().getText());
        presentationView.getTextEditorView().setVisible(false);
    }
}
