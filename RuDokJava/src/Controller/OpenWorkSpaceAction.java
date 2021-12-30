package Controller;

import Model.serialize.filter.ProjectFileFilter;
import Model.serialize.filter.WorkSpaceFileFilter;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import Model.treeModel.WorkSpace;
import View.MainView;
import View.treeSwingGUI.model.MyTreeModel;
import View.treeSwingGUI.model.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;
import java.util.jar.Manifest;

public class OpenWorkSpaceAction extends AbstractRudokAction{
    public OpenWorkSpaceAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        putValue(NAME, "Open WorkSpace");
        putValue(SHORT_DESCRIPTION, "Open a workspace from a directory.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new WorkSpaceFileFilter());

        if (jfc.showOpenDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION)
        {
            Project project;

            try{
                Scanner scanner = new Scanner(jfc.getSelectedFile());
                MainView.getInstance().getRightWorkArea().setProject(null);
                MainView.getInstance().getRightWorkArea().removeAll();
                MainView.getInstance().getMyTree().setModel(new MyTreeModel());
                MainView.getInstance().getMyTree().refresh();
                while (scanner.hasNextLine())
                {
                    String directories = scanner.nextLine();
                    File file = new File(directories);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fileInputStream);

                    try
                    {
                        project = (Project) ois.readObject();
                        project.setProjectFile(new File(directories));
                        project.setParent(((MyTreeNode)MainView.getInstance().getMyTree().getModel().getRoot()).getNode());
                        project.setChanged(false);
                        ((WorkSpace) ((MyTreeNode)MainView.getInstance().getMyTree().getModel().getRoot()).getNode()).addChild(project);
                    }
                    catch (ClassNotFoundException e2)
                    {
                        e2.printStackTrace();
                    }
                }
                ((WorkSpace) ((MyTreeNode)MainView.getInstance().getMyTree().getModel().getRoot()).getNode()).setChanged(false);
                ((WorkSpace) ((MyTreeNode)MainView.getInstance().getMyTree().getModel().getRoot()).getNode()).setWorkSpaceFile(jfc.getSelectedFile());

                scanner.close();
                MainView.getInstance().getMyTree().refresh();
                MainView.getInstance().getLoadContextView().setVisible(false);
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
