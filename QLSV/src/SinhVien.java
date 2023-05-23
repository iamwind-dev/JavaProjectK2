import java.io.Serializable;
import java.util.ArrayList;

public class SinhVien implements Serializable {
    private String hoTen;
    private String mssv;
    private float diem;
    ArrayList<SinhVien> mylist = new ArrayList<>();

    public ArrayList<SinhVien> getMylist() {
        return mylist;
    }

    public SinhVien() {
    }

    public SinhVien(String hoTen, String mssv, float diem) {
        this.hoTen = hoTen;
        this.mssv = mssv;
        this.diem = diem;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public String getMssv() {
        return mssv;
    }

    public float getDiem() {
        return diem;
    }
    
    public Object[] toArray() {
        return new Object[]{hoTen,mssv,diem};
    }
    
    

    @Override
    public String toString() {
        return "SinhVien{" +
                "hoTen='" + hoTen + '\'' +
                ", mssv='" + mssv + '\'' +
                ", diem=" + diem +
                '}';
    }
}
