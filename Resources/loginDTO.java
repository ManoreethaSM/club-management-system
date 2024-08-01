package Resources;

public class loginDTO
{
    private int User_ID;
    private String Email;
    private String Password;
    private String Role;

    public loginDTO(){
        
    }
    public loginDTO(int User_ID, String Email, String Password, String Role) {
        this.User_ID = User_ID;
        this.Email = Email;
        this.Password = Password;
        this.Role = Role;
    }
    public int getUser_ID() 
        {
        return this.User_ID;
    }

    public void setUser_id(int User_ID) 
    {
        this.User_ID = User_ID;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return this.Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
    
}