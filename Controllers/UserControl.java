package Controllers;
import java.sql.SQLException;
import java.util.List;

import Models.loginDAO;
import Models.eventsDAO;
import Models.usersDAO;
import Resources.loginDTO;
import Resources.eventsDTO;
import Resources.usersDTO;
import util.Cookie;
public class UserControl {
    public int login(String Email,String Password) throws Exception
    {
        loginDAO login=loginDAO.getInstance();
        loginDTO user=login.getLoginData(Email);
        if(user==null)
        {
            throw new Exception("Invalid user");
        }
        if(!user.getPassword().equals(Password))
        {
            throw new Exception("Invalid Password");
        }
        Cookie.userId=user.getUser_ID();
        if(user.getRole().equals("Member"))
        {
            return 1;
        }
        return 2;
    }
    public int signUp(String User_Name,String Email,String Password,String Contact_no,String Role,String City,String DOB,String Blood_group,String portfolio) throws SQLException

    {
        usersDAO sign=usersDAO.getInstance();
        usersDTO dummy=new usersDTO();

        dummy.setBlood_group(Blood_group);
        dummy.setCity(City);
        dummy.setContact_No(Contact_no);
        dummy.setPotfolio(portfolio);
        dummy.setRole(Role);
        dummy.setDOB(DOB);
        dummy.setUser_Name(User_Name);

        int user1=sign.getsignUp(dummy);

        int j=sign.getId(Contact_no);
        loginDTO tummy =new loginDTO();
        tummy.setEmail(Email);
        tummy.setPassword(Password);

        int go=sign.getsignUp2(tummy,j);
       
        if(go==user1)
        return user1;
        return 2;
    }
    public int Event(String E_Name,String E_Date,String E_Time,String E_Place,String E_Avenue,String E_Description,String E_Chair,Double E_Amount,int Member_ID) throws SQLException
    {
        //int Member_ID=Cookie.userId;
        eventsDAO add=eventsDAO.getInstance();
        eventsDTO p=new eventsDTO();

        p.setE_Name(E_Name);
        p.setE_Date(E_Date);
        p.setE_Time(E_Time);
        p.setE_Place(E_Place);
        p.setE_Avenue(E_Avenue);
        p.setE_Description(E_Description);
        p.setE_Chair(E_Chair);
        p.setE_Amount(E_Amount);
        p.setMember_ID(Member_ID);
        int g=add.adde(p);
        return g;
    }
    public int deleteEvent(int Event_ID) throws Exception
    {
        eventsDAO add=eventsDAO.getInstance();
        int p=add.eventsdelete(Event_ID);
        if(p==0)
        {
            throw new Exception("Invalid Event");
        }
        return p;
    }
    public eventsDTO getEvents(int Event_ID) throws SQLException
    {
        eventsDAO add=eventsDAO.getInstance();
        eventsDTO p=add.getEvents(Event_ID);
        return p;
    }
    public List<eventsDTO> getAllEvents() throws Exception
    {
        eventsDAO add=eventsDAO.getInstance();
        List<eventsDTO> events=add.getAllEvents();
        return events;
    }
    public boolean updateEventName(int p,String n) throws SQLException
    {
        eventsDAO add=eventsDAO.getInstance();
        return add.updateEventName(p,n);
    }
    public boolean updateEventDate(int p,String date) throws SQLException
    {
        eventsDAO add=eventsDAO.getInstance();
        return add.updateEventDate(p,date);
    }
    public boolean updateEventTime(int p,String time) throws SQLException
    {
        eventsDAO add=eventsDAO.getInstance();
        return add.updateEventDate(p,time);
    }
    public boolean updateEventPlace(int p,String place) throws SQLException
    {
        eventsDAO add=eventsDAO.getInstance();
        return add.updateEventPlace(p,place);
    }
    public boolean updateEventAvenue(int p,String avenue) throws SQLException
    {
        eventsDAO add=eventsDAO.getInstance();
        return add.updateEventDate(p,avenue);
    }
    public boolean updateEventDescription(int p,String des) throws SQLException
    {
        eventsDAO add=eventsDAO.getInstance();
        return add.updateEventDescription(p,des);
    }
    public boolean updateEventChair(int p,String chair) throws SQLException
    {
        eventsDAO add=eventsDAO.getInstance();
        return add.updateEventChair(p,chair);
    }
    public boolean updateEventAmount(int p,double Amount) throws SQLException
    {
        eventsDAO add=eventsDAO.getInstance();
        return add.updateEventAmount(p,Amount);
    }
}
