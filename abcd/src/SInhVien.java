import java.io.Serializable;

public class SInhVien implements Serializable {
	private static final long serialVersionUID=1L;
	private String StuID;
	private String Name;
        private String Phone;
	private String Adress;

    public SInhVien(String StuID, String Name, String Phone, String Adress) {
        this.StuID = StuID;
        this.Name = Name;
        this.Phone = Phone;
        this.Adress = Adress;
    }
	
	public SInhVien() {	
	}
	public String getStuID() {
		return StuID;
	}
	public void setStuID(String stuID) {
		StuID = stuID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
    

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

}
