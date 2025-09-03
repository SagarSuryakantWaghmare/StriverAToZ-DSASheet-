import java.io.File;
import java.util.*;
public class FileOrDirectory {

    public static void main(String[] args) {
        String text="dream.txt";
        String resume="Resume.pdf";

        checkFileOrDirectory(text);
        checkFileOrDirectory(resume);
        
    }
    public static void checkFileOrDirectory(String path){
        File file=new File(path);
        if(file.exists()){
            System.out.println("Get the absolute paht"+file.getAbsolutePath());
            if(file.isFile()){
                System.out.println("Given path is file");
            }
            if(file.isDirectory()){
                System.out.println("Given path is isDirectory");
            }
        }
    }
}