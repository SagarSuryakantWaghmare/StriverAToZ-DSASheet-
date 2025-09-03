import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {

    public static void main(String[] args) {
        String path="dream.txt";
        File file=new File(path);
        try(FileInputStream input=new FileInputStream(file)){
           byte[] fileBytes=input.readAllBytes();
           for(int i=0;i<fileBytes.length;i++){
            System.out.print((char)fileBytes[i]);
           }
        }  
        catch(FileNotFoundException fileNotFoundException){
         System.out.println("File not found exception");
        }
        catch(IOException ioException){
            System.out.println("Input stream exception");
        }
    }
}