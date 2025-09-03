import java.io.File;
import java.io.IOException;
import java.util.*;

public class CreateFile {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name for the File name to create:");
        String name=sc.next();
        sc.close();;
        File file=new File("src/"+name+".txt");
        try{
            boolean isFileCreated=file.createNewFile();
            if(isFileCreated){
                System.out.println("File is created "+file);
            }
        }
        catch (IOException ioException) {
            System.err.println("I/O Exception occurred!");
            System.err.println(ioException.getMessage());
        }
            
    }
}