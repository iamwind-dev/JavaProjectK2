
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

    public static List<SinhVien> studentList;
    SinhVien sv;

    public SaveFile() {
        studentList = new ArrayList();
    }

    public void add(SinhVien sv) {
        studentList.add(sv);
    }

    public void write(List<SinhVien> studentList) {

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

    public void writetext(List<SinhVien> studentList) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("data.txt");

            for (SinhVien sv : studentList) {
                String line = sv.getStuID() + "," + sv.getName() + "," + sv.getAdress() + "\n";
                byte[] data = line.getBytes("utf8");
                fos.write(data);

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "?", "Tao file", JOptionPane.YES_OPTION);
            new TaoFile();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeStream(fos);
        }

    }

    /**
     * read list student from file
     *
     * @return list student
     */
    public List<SinhVien> read() {
        studentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("data.bin");
            ois = new ObjectInputStream(fis);
            studentList = (List<SinhVien>) ois.readObject();
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

    public void readfiletext() {

        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader buff = null;

        try {
            fis = new FileInputStream("data.txt");

            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            buff = new BufferedReader(reader);

            String line;
            while ((line = buff.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                SinhVien sv = new SinhVien();
                sv.parseline(line);
                studentList.add(sv);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "?", "Tao file", JOptionPane.YES_OPTION);
            new TaoFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
