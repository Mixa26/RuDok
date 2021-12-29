package Controller;

import View.MainView;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractRudokAction{
    public UndoAction() {
        putValue(NAME, "Undo");
        putValue(SMALL_ICON, loadIcon("images/undo.png"));
        putValue(SHORT_DESCRIPTION, "Undoes the last action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainView.getInstance().getCommandManager().undoCommand();
    }
}
