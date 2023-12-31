package Model.serialize.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class WorkSpaceFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
    }

    @Override
    public String getDescription() {
        return "RuDok workspace file (.txt)";
    }
}
