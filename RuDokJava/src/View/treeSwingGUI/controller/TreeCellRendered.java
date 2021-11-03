package View.treeSwingGUI.controller;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class TreeCellRendered extends DefaultTreeCellRenderer {
    public TreeCellRendered()
    {

    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        //TODO dodati ifove koji ce menjati ikonice u stablu
        /*
        if (value instanceof NEKAKLASA)
        {
            URL imageURL = getClass().getResouce(URL SLIKE);
            Icon icon = null;
            if (imageURL != null)
            {
                icon = new ImageIcon(imageURL);
            }
            setIcon(icon);
        }
         */
    }
}
