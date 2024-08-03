package Models;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Resources.eventsDTO;
import Resources.ForVolunteersDTO;
import Resources.usersDTO;
import util.Cookie;

public class forvolunteersDAO  extends Connect{
    private static forvolunteersDAO instance;
    PreparedStatement view,getEvents,insertForVolunteers,bookedvolunteers,date,dt;
    private forvolunteersDAO() throws SQLException{
        view=con.prepareStatement("SELECT * FROM events");
        getEvents=con.prepareStatement("SELECT * FROM events WHERE Event_ID = ?");
        insertForVolunteers=con.prepareStatement("INSERT INTO forvolunteers (Amount_donated,Feedbacks,Suggestions,Event_ID,Volunteer_ID) values(?,?,?,?,?)");
        // bookedvolunteers=con.prepareStatement("SELECT *  FROM users u JOIN forvolunteers f ON User_ID = f.Volunteer_ID");
        bookedvolunteers=con.prepareStatement("SELECT * FROM users where Role='Volunteer'");
        date=con.prepareStatement("SELECT * FROM forvolunteers");
        
    } 
public static forvolunteersDAO getInstance() throws SQLException{
    if(instance==null)
    {
        instance=new forvolunteersDAO();
    }
    return instance;
}

    public List<eventsDTO> getAllEvents() throws SQLException
    {
        ResultSet rs=view.executeQuery();
        List<eventsDTO> eventsList = new ArrayList<>();
        while(rs.next())
        {
            eventsDTO event=new eventsDTO();
            event.setEvent_ID(rs.getInt("Event_ID"));
            event.setE_Name(rs.getString("E_Name"));
            event.setE_Date(rs.getString("E_Date"));
            event.setE_Time(rs.getString("E_Time"));
            event.setE_Place(rs.getString("E_Place"));
            event.setE_Avenue(rs.getString("E_Avenue"));
            event.setE_Description(rs.getString("E_Description"));
            event.setE_Chair(rs.getString("E_Chair"));
            event.setE_Amount(rs.getDouble("E_Amount"));
            event.setMember_ID(rs.getInt("Member_ID"));
            eventsList.add(event);
        }
       return eventsList;
    }
    public eventsDTO getEvents(int eventId) throws SQLException{
        getEvents.setInt(1,eventId);
        ResultSet rs=getEvents.executeQuery();
        if(rs.next())
        {
            eventsDTO event=new eventsDTO();
            event.setEvent_ID(rs.getInt("Event_ID"));
            event.setE_Name(rs.getString("E_Name"));
            event.setE_Date(rs.getString("E_Date"));
            event.setE_Time(rs.getString("E_Time"));
            event.setE_Place(rs.getString("E_Place"));
            event.setE_Avenue(rs.getString("E_Avenue"));
            event.setE_Description(rs.getString("E_Description"));
            event.setE_Chair(rs.getString("E_Chair"));
            event.setE_Amount(rs.getDouble("E_Amount"));
            event.setMember_ID(rs.getInt("Member_ID"));
           return event;
        }
        return null;
    }
    public int insertForVolunteers(int eventID,double amountDonated,String feedbacks,String suggestions) throws SQLException
    {
        // INSERT INTO forvolunteers (Amount_donated,Feedbacks,Suggestions,Event_ID,Volunteer_ID) values(?,?,?,?,?)
        int Volunteer_ID=Cookie.userId;
        insertForVolunteers.setInt(4,eventID);
        insertForVolunteers.setDouble(1,amountDonated);
        insertForVolunteers.setString(2,feedbacks);
        insertForVolunteers.setString(3,suggestions);
        insertForVolunteers.setInt(5,Volunteer_ID);
        
        return insertForVolunteers.executeUpdate();
    }

    public List<usersDTO> getAllBookedVolunteers() throws SQLException{
        List<usersDTO> bookedVolunteers =new ArrayList<>();

        ResultSet rs= bookedvolunteers.executeQuery();
        while(rs.next())
        {
            usersDTO volunteer =new usersDTO();
           // ForVolunteersDTO t=new ForVolunteersDTO();
            volunteer.setUser_ID(rs.getInt("User_ID"));
            volunteer.setUser_Name(rs.getString("User_Name"));
            volunteer.setContact_No(rs.getString("Contact_no"));
            volunteer.setRole(rs.getString("Role"));
            volunteer.setCity(rs.getString("City"));
            volunteer.setDOB(rs.getString("DOB"));
            volunteer.setBlood_group(rs.getString("Blood_group"));
            volunteer.setPotfolio(rs.getString("Potfolio"));
            bookedVolunteers.add(volunteer);
        }
        return bookedVolunteers;
    }
    public List<ForVolunteersDTO> getBookingsForEvent(int eventID) throws SQLException
    {
        date.setInt(1,eventID);
        ResultSet resultSet=date.executeQuery();

        List<ForVolunteersDTO> bookings =new ArrayList<>();
        while(resultSet.next())
        {
            ForVolunteersDTO booking=new ForVolunteersDTO();
            booking.setFV_ID(resultSet.getInt("FV_ID"));
            booking.setAmount_donated(resultSet.getInt("Amount_donated"));
            booking.setFeedbacks(resultSet.getString("Feedbacks"));
            booking.setSuggestions(resultSet.getString("Suggestions"));
            booking.setVolunteer_ID(resultSet.getInt("Volunteer_ID"));
            bookings.add(booking);
        }
        return bookings;
    }
    public List<ForVolunteersDTO> getAllForVolunteers() throws SQLException
    {
        List<ForVolunteersDTO> bookings =new ArrayList<>();
        ResultSet resultSet=date.executeQuery();
        while(resultSet.next())
        {
    ForVolunteersDTO booking = new ForVolunteersDTO();
    booking.setEvent_ID(resultSet.getInt("Event_ID"));
    booking.setFV_ID(resultSet.getInt("FV_ID"));
    booking.setAmount_donated(resultSet.getInt("Amount_donated"));
    booking.setFeedbacks(resultSet.getString("Feedbacks"));
    booking.setSuggestions(resultSet.getString("Suggestions"));
    booking.setVolunteer_ID(resultSet.getInt("Volunteer_ID"));
    bookings.add(booking);
    }
    return bookings;
}
}
