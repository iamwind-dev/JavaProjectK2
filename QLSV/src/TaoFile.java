import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TaoFile {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("data.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.close();
            fos.close();
            
            System.out.println("Da tao file data.bin thanh cong!");
            
        } catch (IOException ex) {
            System.err.println("Loi khi tao file data.bin: " + ex.getMessage());
        }
    }
}
