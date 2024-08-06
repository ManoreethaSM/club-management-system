package Views;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import Controllers.VolunteerControl;
import Resources.eventsDTO;
import Resources.ForVolunteersDTO;
import util.Cookie;
import util.Input;
public class volunteerView extends Input{
    public void bookEvent() throws SQLException{
        boolean m=true;
        while(m)
        {
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println("                                 1.View All Events                                              ");
            System.out.println("                                 2.View the details of the booked event                         ");
            System.out.println("                                 3.Provide feedbacks for an event                               ");
            System.out.println("                                 4.Make Payment                                                 ");
            System.out.println("                                 5.Logout                                                       ");
            System.out.println("------------------------------------------------------------------------------------------------");
            int choice=sc.nextInt();
        if(choice==1)
        {
            viewAllEvents();
        }
        else if(choice==2)
        {
            viewAllForVolunteers();
        }
        else if(choice==3)
        {
            bookEvents();
        }
        else if(choice==4)
        {
            makePayment();
        }
        else if(choice==5)
        {
            System.out.println("Thank you for visiting");
            m=false;
        }
        else
        {
            System.out.println("Invalid choice");
        }
    }
    }
    
    private void viewAllEvents() throws SQLException{
        VolunteerControl volunteerControl=new VolunteerControl();
        List<eventsDTO> events =volunteerControl.getAllEvents();
            if(!events.isEmpty())
            {
                System.out.println("Displaying all events :");
                System.out.println("------------------------------------------------------");
                for(eventsDTO event: events)
                {
                    System.out.println("Here is what you asked for ;) ");
                    System.out.println("Event Number :"+event.getEvent_ID());
                    System.out.println("Event Name :"+event.getE_Name());
                    System.out.println("Event Date :"+event.getE_Date());
                    System.out.println("Event Time :"+event.getE_Time());
                    System.out.println("Event Place :"+event.getE_Place());
                    System.out.println("Event Avenue :"+event.getE_Avenue());
                    System.out.println("Event Description :"+event.getE_Description());
                    System.out.println("Event Chair :"+event.getE_Chair());
                    System.out.println("Event Amount :"+event.getE_Amount());
                    System.out.println("Event Manager :"+event.getMember_ID());
                    System.out.println("------------------------------------------------------");
                }
            }
            else{
                System.out.println("No events found");
            }
        }
    public void bookEvents() throws SQLException{
    System.out.println("Enter event ID to register");
    int eventId=sc.nextInt();
    System.out.println("Amount you donated:");
    double amount=sc.nextDouble();
    System.out.println("Drop your feedbacks :");
    sc.next();
    String feedback=sc.nextLine();
    System.out.println("Any suggestions for us?");
    String suggestions=sc.nextLine();
    VolunteerControl volunteerControl =new VolunteerControl();
    int result =volunteerControl.bookEvents(eventId,amount,feedback,suggestions);
    if(result == 1)
    {
        System.out.println("Event reports provided successfully");
    }
    else if(result ==0)
{
    System.out.println("Failed to give reports");
}
    }

    private void makePayment() throws SQLException{
        System.out.println("Enter Member ID : ");
        int memberId=sc.nextInt();

        System.out.println("Enter Event ID : ");
        int eventId=sc.nextInt();

        System.out.println("Enter payment date (YYYY-MM-DD): ");
        String dateStr=sc.next();
        Date date =Date.valueOf(dateStr);
        int volunteerID =Cookie.userId;

        VolunteerControl volunteerControl =new VolunteerControl();
        boolean success =volunteerControl.makePayment(volunteerID, memberId, eventId,date);
        if(success)
        {
            System.out.println("Payment made Successfully");
        }
        else{
            System.out.println("Failed to make Payment .Please select the event and make the payment");
        }
    }
    private void viewAllForVolunteers() throws SQLException
    {
        VolunteerControl volunteerControl =new VolunteerControl();
        List<ForVolunteersDTO> t=volunteerControl.getAllForVolunteers();
        if(!t.isEmpty())
        {
            System.out.println("Volunteers reports:");
            for(ForVolunteersDTO volunteer : t){
                System.out.println("Event_ID :"+volunteer.getEvent_ID());
                System.out.println("FV_ID : "+volunteer.getFV_ID());
                System.out.println("Amount donated :"+volunteer.getAmount_donated());
                System.out.println("Feedback :"+volunteer.getFeedbacks());
                System.out.println("Suggestions :"+volunteer.getSuggestions());
            }
        }
        else{
            System.out.println("Not filled yet");
        }
            }
        }


