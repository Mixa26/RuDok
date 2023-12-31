package Controller;

import View.MainView;
import View.PresentationView;
import Model.state.SlotTypeState.TextState;

import java.awt.event.ActionEvent;

public class ChangeSlotTypeState extends AbstractRudokAction{
    public ChangeSlotTypeState() {
        putValue(NAME, "Change slot type");
        putValue(SMALL_ICON, loadIcon("images/text.png"));
        putValue(SHORT_DESCRIPTION, "Changes the type of slot to be created(picture/text).");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PresentationView presentationView = ((PresentationView)MainView.getInstance().getRightWorkArea().getjTabbedPane().getSelectedComponent());
        if (presentationView.getSlotTypeState() instanceof TextState)
        {
            presentationView.startMultimediaState();
            putValue(SMALL_ICON, loadIcon("images/picture.png"));
        }
        else
        {
            presentationView.startTextState();
            putValue(SMALL_ICON, loadIcon("images/text.png"));
        }
    }
}
