package Controller;

import Model.treeModel.RuNode;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class SubmitRenameIntialsAction extends AbstractRudokAction{

    public SubmitRenameIntialsAction() {
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename a selected component");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((MainView.getIntance().getMyTree().getSelectionPath()) == null)
        {
            return;
        }

        RuNode selection = ((MyTreeNode) Objects.requireNonNull(MainView.getIntance().getMyTree().getSelectionPath()).getLastPathComponent()).getNode();
        if (selection != null) {
            String nameField = MainView.getIntance().getActionManager().getRenameInTreeAction().getRenameInTreeView().getNameField().getText();
            if (!nameField.equals(""))
            {
                selection.setName(nameField);
            }

            MainView.getIntance().getActionManager().getRenameInTreeAction().getRenameInTreeView().setVisible(false);

            MainView.getIntance().getMyTree().refresh();
        }
    }
}
