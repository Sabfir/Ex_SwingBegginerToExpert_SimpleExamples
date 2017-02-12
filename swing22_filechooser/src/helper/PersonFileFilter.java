package helper;

import util.FileUtil;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PersonFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        String extention = FileUtil.getFileExtention(file.getName());
        return extention != null && extention.equals("per");
    }

    @Override
    public String getDescription() {
        return "Person DB files (*.per)";
    }
}
