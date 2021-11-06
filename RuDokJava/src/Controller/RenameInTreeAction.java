package Controller;

import Model.treeModel.*;
import View.MainView;
import View.RenameInTreeView;
import View.treeSwingGUI.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class RenameInTreeAction extends AbstractRudokAction{

    private RenameInTreeView renameInTreeView = new RenameInTreeView(MainView.getIntance(), "Rename", true);

    public RenameInTreeAction()
    {
        putValue(NAME, "Rename");
        putValue(SMALL_ICON, loadIcon("images/rename.png"));
        putValue(SHORT_DESCRIPTION, "Rename a selected component");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((MainView.getIntance().getMyTree().getSelectionPath()) == null)
        {
            return;
        }

        RuNode selection = ((MyTreeNode) Objects.requireNonNull(MainView.getIntance().getMyTree().getSelectionPath()).getLastPathComponent()).getNode();
        if (selection != null)
        {
            renameInTreeView.setVisible();
        }
    }

    public RenameInTreeView getRenameInTreeView() {
        return renameInTreeView;
    }
}
