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

public class OpenWorkSpaceAction extends AbstractRudokAction{
    public OpenWorkSpaceAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        putValue(NAME, "Open");
        putValue(SMALL_ICON, loadIcon("images/editSlot.png"));
        putValue(SHORT_DESCRIPTION, "Open a project from a directory.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
