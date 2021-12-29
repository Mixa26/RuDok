package Controller;

import Model.serialize.ProjectFileFilter;
import Model.serialize.WorkSpaceFileFilter;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.WorkSpace;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class SaveWorkSpaceAction extends AbstractRudokAction{
    public SaveWorkSpaceAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(NAME, "Save");
        putValue(SMALL_ICON, loadIcon("images/editSlot.png"));
        putValue(SHORT_DESCRIPTION, "Saves the currently open project.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        WorkSpace workSpace = (WorkSpace) ((MyTreeNode)MainView.getInstance().getMyTree().getModel().getRoot()).getNode();
        File workSpaceFile = workSpace.getWorkSpaceFile();

        if (!workSpace.isChanged())
        {
            return;
        }

        if (workSpace.getWorkSpaceFile() == null)
        {
            if (jfc.showSaveDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION)
            {
                workSpaceFile = jfc.getSelectedFile();
            }
            else
            {
                return;
            }
        }

        FileWriter fw;
        try
        {
            fw = new FileWriter(workSpaceFile);
            for (RuNode project : workSpace.getChildren())
            {
                //(Project)project
            }
        }
        catch(FileNotFoundException e1)
        {
            e1.printStackTrace();
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
    }
}
