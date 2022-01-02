package Controller;

import Model.serialize.SaveProject;
import Model.treeModel.Project;
import View.MainView;
import View.treeSwingGUI.model.MyTreeNode;
import Model.userErrorHandler.ErrorFactory;

import java.awt.event.ActionEvent;

public class SaveProjectAction extends AbstractRudokAction{
    public SaveProjectAction() {
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Saves the currently open project.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainView.getInstance().getMyTree().getSelectionPath() != null)
        {
            if (((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode() instanceof Project)
            {
                Project project = (Project) ((MyTreeNode)MainView.getInstance().getMyTree().getSelectionPath().getLastPathComponent()).getNode();

                SaveProject saveProject = new SaveProject(project);
                saveProject.save();
//                JFileChooser jfc = new JFileChooser();
//                jfc.setFileFilter(new ProjectFileFilter());
//
//                Project project = MainView.getInstance().getRightWorkArea().getProject();
//
//                File projectFile = project.getProjectFile();
//
//                if (!project.isChanged()) {
//                    return;
//                }
//
//                if (project.getProjectFile() == null) {
//                    if (jfc.showSaveDialog(MainView.getInstance()) == JFileChooser.APPROVE_OPTION) {
//                        projectFile = jfc.getSelectedFile();
//                    } else {
//                        return;
//                    }
//                }
//
//                ObjectOutputStream oos;
//                try {
//                    oos = new ObjectOutputStream(new FileOutputStream(projectFile));
//                    oos.writeObject(project);
//                    project.setProjectFile(projectFile);
//                    ((RuNode) project).setChanged(false);
//                } catch (FileNotFoundException e1) {
//                    e1.printStackTrace();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
            }
            else
            {
                MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.NoProjectSelected);
            }
        }
        else
        {
            MainView.getInstance().getErrorFactory().createError(ErrorFactory.ErrorType.NoProjectSelected);
        }
    }
}
