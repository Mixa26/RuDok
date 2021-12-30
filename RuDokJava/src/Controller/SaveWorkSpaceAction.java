package Controller;

import Model.serialize.Save;
import Model.serialize.SaveProject;
import Model.serialize.filter.WorkSpaceFileFilter;
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
        putValue(NAME, "Save all");
        putValue(SHORT_DESCRIPTION, "Saves the whole workspace.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new WorkSpaceFileFilter());

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
            fw = new FileWriter(workSpaceFile,false);
            for (RuNode project : workSpace.getChildren())
            {
                SaveProject saveProject = new SaveProject((Project) project);
                saveProject.save();
                fw.write(String.valueOf(((Project)project).getProjectFile()));
                fw.write('\n');
            }
            fw.close();
            workSpace.setWorkSpaceFile(workSpaceFile);
            workSpace.setChanged(false);
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
