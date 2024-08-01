package Resources;
//import java.util.Date;
public class usersDTO {
    private int User_ID;
    private String User_Name;
    private String Role;
    private String DOB;
    private String City;
    private String Contact_No;
    private String Blood_group;
    private String Potfolio;
    public usersDTO()
    {

    }
    public usersDTO(int User_ID,String User_Name,String Contact_No,String Role,String City,String DOB,String Blood_group,String Potfolio)
    {
        this.User_ID=User_ID;
        this.User_Name=User_Name;
        this.Role=Role;
        this.DOB=DOB;
        this.Blood_group=Blood_group;
        this.City=City;
        this.Potfolio=Potfolio;
        this.Contact_No=Contact_No;
    }
    

    public int getUser_ID() {
        return this.User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

    public String getUser_Name() {
        return this.User_Name;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public String getRole() {
        return this.Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getDOB() {
        return this.DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getCity() {
        return this.City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getContact_No() {
        return this.Contact_No;
    }

    public void setContact_No(String Contact_No) {
        this.Contact_No = Contact_No;
    }

    public String getBlood_group() {
        return this.Blood_group;
    }

    public void setBlood_group(String Blood_group) {
        this.Blood_group = Blood_group;
    }

    public String getPotfolio() {
        return this.Potfolio;
    }

    public void setPotfolio(String Potfolio) {
        this.Potfolio = Potfolio;
    }
}
       
  