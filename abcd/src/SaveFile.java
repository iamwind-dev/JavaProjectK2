
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class SaveFile {

    public static List<SInhVien> studentList;
    SInhVien sv;

    public SaveFile() {
        studentList = new ArrayList();
    }

    public void add(SInhVien sv) {
        studentList.add(sv);
    }

    public void write(List<SInhVien> studentList) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("data.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            FileDescriptor fd = null;
            fd = fos.getFD();
            fd.sync();
        } catch (FileNotFoundException e) {
            new TaoFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<SInhVien> read() {
        studentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("data.bin");
            ois = new ObjectInputStream(fis);
            studentList = (List<SInhVien>) ois.readObject();
        } catch (FileNotFoundException e) {
            new TaoFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return studentList;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
