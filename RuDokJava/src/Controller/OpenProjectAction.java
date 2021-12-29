package Controller;

import Model.serialize.ProjectFileFilter;
import Model.treeModel.Project;
import Model.treeModel.WorkSpace;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenProjectAction extends AbstractRudokAction{
    public OpenProjectAction() {
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open a project from a directory.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ProjectFileFilter());

        if (jfc.showOpenDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION)
        {
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

                Project project = null;
                try
                {
                    project = (Project) ois.readObject();
                }
                catch (ClassNotFoundException e1)
                {
                    e1.printStackTrace();
                }

                ((WorkSpace) ((MyTreeNode)MainView.getInstance().getMyTree().getModel().getRoot()).getNode()).addChild(project);

                MainView.getInstance().getRightWorkArea().openProject(project);
                MainView.getInstance().getMyTree().refresh();
            }
            catch (FileNotFoundException e1)
            {
                e1.printStackTrace();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
    }
}
