package util;

public class FileUtil {
    public static String getFileExtention(String name) {
        int pointIndex = name.lastIndexOf(".");
        if (pointIndex == -1 || pointIndex == name.length()-1) {
            return null;
        }

        return name.substring(pointIndex+1, name.length());
    }
}
