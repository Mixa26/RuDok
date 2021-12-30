package Model.serialize;

import Model.serialize.filter.ProjectFileFilter;
import Model.treeModel.Project;
import Model.treeModel.RuNode;
import View.MainView;

import javax.swing.*;
import java.io.*;

public class SaveProject implements Save{
    private Project project;

    public SaveProject(Project project) {
        this.project = project;
    }

    public void save()
    {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ProjectFileFilter());

//                Project project = MainView.getInstance().getRightWorkArea().getProject();

        File projectFile = project.getProjectFile();

        if (!project.isChanged()) {
            return;
        }

        if (project.getProjectFile() == null) {
            if (jfc.showSaveDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) {
                projectFile = jfc.getSelectedFile();
            } else {
                return;
            }
        }

        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(projectFile));
            oos.writeObject(project);
            project.setProjectFile(projectFile);
            ((RuNode) project).setChanged(false);
            project.setChanged(false);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
