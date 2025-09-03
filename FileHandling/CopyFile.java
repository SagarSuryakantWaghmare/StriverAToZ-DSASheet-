import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile {
    public static void characterStream(){
        try(FileReader file=new FileReader("dream.txt")) {
            FileWriter f=new FileWriter("CopyOfDream.txt");
            int charData;
            while ((charData=file.read())!=-1) {
                f.write(charData);
            }
            System.out.println("File write successfully");
        } catch (Exception e) {
            System.out.println("Input output exception");
        }
    }

    public static void main(String[] args) {
        characterStream();
    }
}