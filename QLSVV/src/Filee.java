
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.SyncFailedException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Filee {
    public static List<SinhVien> studentlist;
    SinhVien sv;
    
    public Filee(){
        studentlist = new ArrayList();
    }
    
    public void add(SinhVien sv){
        studentlist.add(sv);
    }
    
    public void write (List<SinhVien> stuList){
        try {
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            fos = new FileOutputStream("data.bin");
            oos = new ObjectOutputStream(fos);
            FileDescriptor fd = null;
            fd = fos.getFD();
            fd.sync();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    public void writetext(List<SinhVien> stList){
        try {
            FileOutputStream fos = null;
            fos = new FileOutputStream("data.txt");
            
            for(SinhVien sv : stList){
                String line = sv.getID() + "," + sv.getName() + "," + sv.getScore() + "\n";
                byte[] data = line.getBytes("utf8");
                fos.write(data);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Filee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Filee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Filee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<SinhVien> read(){
        try {
            studentlist = new ArrayList<>();
            FileInputStream fis = null;
            ObjectInput ois = null;
            
            fis = new FileInputStream("data.bin");
            ois = new ObjectInputStream(fis);
            studentlist = (List<SinhVien>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Filee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Filee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Filee.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return studentlist;
    }
        
        public void readfiletext(){
            
        try {
            FileInputStream fis = null;
            InputStreamReader reader = null;
            BufferedReader buff = null;
            
            fis = new FileInputStream("data.txt");
            reader = new InputStreamReader(fis,StandardCharsets.UTF_8 );
            buff = new BufferedReader(reader);
            
            String line;
            while((line = buff.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
                SinhVien sv = new SinhVien();
                studentlist.add(sv);
            }
        } catch (IOException ex) {
            Logger.getLogger(Filee.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        public void readtext(){
        try {
            FileInputStream fis = null;
            InputStreamReader reader = null;
            BufferedReader buff = null;
            
            fis = new FileInputStream("data.txt");
            reader = new InputStreamReader(fis,StandardCharsets.UTF_8);
            buff = new BufferedReader(reader);
            
            String line;
            
            while((line = buff.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Filee.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        private void closeStream(InputStream is){
            if(is != null){
                try {
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(Filee.class.getName()).log(Level.SEVERE, null, ex);
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

