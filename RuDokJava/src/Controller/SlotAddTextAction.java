package Controller;

import Model.treeModel.Presentation;
import View.MainView;
import View.PresentationView;

import javax.swing.text.AttributeSet;
import java.awt.event.ActionEvent;
import java.text.AttributedCharacterIterator;

public class SlotAddTextAction extends AbstractRudokAction{
    public SlotAddTextAction() {
        putValue(NAME, "Submit");
        putValue(SHORT_DESCRIPTION, "Puts text you typed here in a slot.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView)MainView.getIntance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        presentationView.getSlotSelected().getSlotHandler().setContent(presentationView.getTextEditorView().getjTextPane().getText());
        //TODO odradi text sa bold italic...
        presentationView.getTextEditorView().setVisible(false);
    }
}
