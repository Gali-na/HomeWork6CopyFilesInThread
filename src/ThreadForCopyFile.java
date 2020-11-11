import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadForCopyFile implements Runnable{
    private File file;
    String nameDirectory;

    public ThreadForCopyFile() {
    }

    public ThreadForCopyFile(File file, String nameDirectory) {
        this.file = file;
        this.nameDirectory = nameDirectory;
    }

    public void setFile(File file, String nameDirectory) {
        this.file = file;
        this.nameDirectory=nameDirectory;
    }

    private void copyFile(File file,String nameDirectory) {
        File newFile = new File(nameDirectory, file.getName());
        try {
            newFile.createNewFile();
            byte[] buffer = new byte[1024];
            int byteread = 0;
            try (FileInputStream fileFrom = new FileInputStream(file);
                 FileOutputStream whereСopy = new FileOutputStream(newFile)) {
                for (; (byteread = fileFrom.read(buffer)) > 0; ) {
                    whereСopy.write(buffer, 0, byteread);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void run() {
        copyFile(this.file, this.nameDirectory);
    }
}
