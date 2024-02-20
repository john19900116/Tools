package _Tools.folderTools;

import java.io.File;
/**
 * 此物件在作，如果從Dimensions GET的程式會有一個影隱藏資料夾.dm的問題，可以刪除他
 */
public class DeleteDmFolders {

    public static void main(String[] args) {
        String folderPath = "D:\\Dimensions\\GW2EW\\IVam修補\\";
        deleteDmFolders(folderPath);
    }

    public static void deleteDmFolders(String folderPath) {
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        if (".dm".equals(file.getName())) {
                            deleteDirectory(file);
                        } else {
                            deleteDmFolders(file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    public static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        directory.delete();
    }
}