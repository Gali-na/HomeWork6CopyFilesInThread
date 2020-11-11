import java.io.File;

public class CopyFiles {
    public static void copyFile(String nameOne, String nameTwo) {
        File DirOne = new File(nameOne);
        File[] fileNameForCopy = DirOne.listFiles();

        File DirTwo = new File(nameTwo);
        String[] nameFileInTwoDir = DirTwo.list();
        for (int i = 0; i < nameFileInTwoDir.length; i++) {
            for (int j = 0; j < fileNameForCopy.length; j++) {
                if (nameFileInTwoDir[i].equals(fileNameForCopy[j].getName())) {
                    System.out.println("Copying was interrupted because a file with   " + fileNameForCopy[j].getName() +
                            "name already exists in the folderCopying was interrupted because a file with  " + fileNameForCopy[j].getName() +
                            "name already exists in the folder  " + nameTwo);
                    return;
                }
            }
        }

        Thread [] threads = new Thread[fileNameForCopy.length];
        for(int i=0; i<threads.length ;i++) {
            threads[i]=new Thread(new ThreadForCopyFile(fileNameForCopy[i],nameTwo));
        }
        for(int i=0; i<threads.length ;i++) {
            threads[i].start();
        }
    }
}
