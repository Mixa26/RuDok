package Controller;

import View.MainView;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractRudokAction{
    public RedoAction() {
        putValue(NAME, "Redo");
        putValue(SMALL_ICON, loadIcon("images/redo.png"));
        putValue(SHORT_DESCRIPTION, "Redoes the last undone action.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainView.getIntance().getCommandManager().doCommand();
    }
}
