package Controller;

import Model.treeModel.RuNode;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import View.userErrorHandler.ErrorFactory;
import command.RenameTreeCommand;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class SubmitRenameIntialsAction extends AbstractRudokAction{

    public SubmitRenameIntialsAction() {
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename a selected component");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((MainView.getInstance().getMyTree().getSelectionPath()) == null)
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.RenameInTreeError);
            return;
        }

        RuNode selection = ((MyTreeNode) Objects.requireNonNull(MainView.getInstance().getMyTree().getSelectionPath()).getLastPathComponent()).getNode();
        if (selection != null) {
            String nameField = MainView.getInstance().getMyToolBar().getRenameInTreeView().getNameField().getText();
            //String nameField = MainView.getInstance().getActionManager().getRenameInTreeAction().getRenameInTreeView().getNameField().getText();
            if (!nameField.equals(""))
            {
                MainView.getInstance().getCommandManager().addComand(new RenameTreeCommand(selection, nameField));
                //selection.setName(nameField);
            }
            else
            {
                MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.NameEmptyError);

            }

            MainView.getInstance().getMyToolBar().getRenameInTreeView().setVisible(false);
            //MainView.getInstance().getActionManager().getRenameInTreeAction().getRenameInTreeView().setVisible(false);

            //MainView.getIntance().getMyTree().refresh();
        }
    }
}
