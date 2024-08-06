package Views;

import Controllers.UserControl;
import util.Input;
public class UserView  extends Input{
    public void tosignUpLogin() throws Exception
    {
        boolean f=true;
        while(f)
        {
            try{
        System.out.println(" -------------Hey Good Soul ! Long time no see ------------ ");
        System.out.println("--------------Welcome to our club's data centre-------------");
        System.out.println("                                                            ");
        System.out.println("              Please follow the commands below"              );
        System.out.println("                                                            ");
        System.out.println("              Press 1 to Login                              ");
        System.out.println("              Press 2 to SignUp if you're new               ");
        System.out.println("              Press 3 to exit                               ");
        int choice =sc.nextInt();
        sc.nextLine();
        switch(choice)
        {
            case 1:
            getLogin();
            break;
            
            case 2:
            toSignUp();
            break;

            case 3:
            System.out.println("Thanks for coming !");
            System.out.println("Will catch you Later ;) ");
            break;
        }
    }
    catch(Exception err)
    {
        System.out.println(err.getMessage());
        break;
    }
}
}
public void getLogin() throws Exception{
    System.out.print("Enter Email : ");
    String email=sc.nextLine();
    System.out.print("Enter password : ");
    String password=sc.nextLine();
    UserControl us=new UserControl();
    int check=us.login(email,password);
    if(check==1)
    {
        System.out.println("Member");
        memberView U=new memberView();
        U.addEvent();
    }
    else{
        System.out.println("Volunteer");
        volunteerView U=new volunteerView();
        U.bookEvent();
    }
}
public void toSignUp() throws Exception
{
    System.out.println("Please enter the  details asked ");
    System.out.print("Set your User_Name :");
    String name=sc.next();
    System.out.print("Enter your Email Id :");
    String email=sc.next();
    System.out.print("Set your User_Password :");
    String password=sc.next();
    System.out.print("Enter Contact Number :");
    String contact=sc.next();
    System.out.print("Enter Date Of Birth :");
    String dob=sc.next();
    System.out.print("Enter your City :");
    String city=sc.next();
    System.out.print("Enter your Blood group :");
    String bloodgroup=sc.next();
    System.out.print("Enter your portfolio :");
    String portfolio=sc.next();
 
    UserControl us=new UserControl();
    int check =us.signUp(name,email,password,contact,"Volunteer",city,dob,bloodgroup,portfolio);
    if(check==1)
    {
        System.out.println("Signup Successful");
        tosignUpLogin();
    }
    else{
        System.out.println("Signup failed");
    }
}
}