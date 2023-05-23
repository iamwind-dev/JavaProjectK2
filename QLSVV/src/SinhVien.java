
import java.io.Serializable;

public class SinhVien implements Serializable {

    private static final long serialVersionUID = 1L;
    private String ID;
    private String Name;
    private String score;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public SinhVien() {
    }

    public SinhVien(String ID, String Name, String score) {
        this.ID = ID;
        this.Name = Name;
        this.score = score;
    }

}
