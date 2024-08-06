package Controllers;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import Models.paymentsDAO;
import Models.forvolunteersDAO; 
import Resources.eventsDTO;
import Resources.ForVolunteersDTO;
import Resources.usersDTO;

public class VolunteerControl {
    public int bookEvents(int Event_ID,Double Amount_donated,String Feedbacks,String Suggestions) throws SQLException{
        forvolunteersDAO dao =forvolunteersDAO.getInstance();
        //eventsDTO event=dao.getEvents(Event_ID);
        //VolunteerControl u=new VolunteerControl();
        int insertResult =dao.insertForVolunteers(Event_ID, Amount_donated, Feedbacks, Suggestions);
        if(insertResult != 1)
        {
            return -3;
        }
        return 1;
    }
    public List<eventsDTO> getAllEvents() throws SQLException
    {
        forvolunteersDAO dao =forvolunteersDAO.getInstance();
        List<eventsDTO> events=dao.getAllEvents();
        return events;
    }

        public List<usersDTO> getAllBookedVolunteers() throws SQLException
        {
         forvolunteersDAO dao=forvolunteersDAO.getInstance();
         return dao.getAllBookedVolunteers();
        }
        public boolean makePayment(int Volunteer_ID,int Member_ID,int Event_ID,Date P_date) throws SQLException
        {
            //forvolunteersDAO dao=forvolunteersDAO.getInstance();
            paymentsDAO paymentsDao =paymentsDAO.getInstance();
            return paymentsDao.insertPayment(Member_ID,Event_ID,P_date);

        }
        public List<ForVolunteersDTO> getAllForVolunteers() throws SQLException{
            forvolunteersDAO dao=forvolunteersDAO.getInstance();
            return dao.getAllForVolunteers();
        }
}
