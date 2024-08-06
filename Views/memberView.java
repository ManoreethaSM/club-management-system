package Views;
import java.sql.SQLException;
import java.util.List;

import Controllers.VolunteerControl;
import Controllers.UserControl;

import Resources.eventsDTO;
import Resources.ForVolunteersDTO;
import Resources.usersDTO;
import util.Input;

public class memberView extends Input
    {
        public void addEvent() throws Exception
        {
            boolean y=true;
            while(y)
            {
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.println("                     ------  HEY GOOD SOUL ;)  ------                                           ");
                System.out.println("                     Welcome to the rotaract club of SIET                                       ");
                System.out.println("                     Press 1 to Add a new Event                                                 ");
                System.out.println("                     Press 2 to Delete an Event                                                 ");
                System.out.println("                     Press 3 to View a Specific Event                                           ");
                System.out.println("                     Press 4 to Show all events                                                 ");
                System.out.println("                     Press 5 to Show the details of volunteers who have booked for the event    ");
                System.out.println("                     Press 6 to Update details of an Event                                      ");
                System.out.println("                     Press 7 to Show for Volunteers                                             ");
                System.out.println("                     Press 8 to Logout                                                          ");
                System.out.println("------------------------------------------------------------------------------------------------");

                int choice=sc.nextInt();
                sc.nextLine();
                if(choice==1)
                {
                   getEvent();
                }
                 else if(choice==2)
                {
                     delEvent();
                }
                 else if(choice==3)
                {
                     showEvent();
                }
                 else if(choice==4)
                {
                     showAll();
                }
                 else if(choice==5)
                {
                    viewAllBookedVolunteers();
                }
                 else if(choice==6)
                {
                 update();
                }
                else if(choice==7)
                {
                  viewAllForVolunteers();
                }
                else if(choice==8)
                {
                 System.out.println("Thank You for visiting");
                 y=false;
                }
                else
                {
                 System.out.println("Invalid choice");
                }
                
             }
         
             }
             public void getEvent() throws Exception{
                System.out.println("-- Please fill the below details --");
                System.out.println("Event Name :");
                String E_Name=sc.nextLine();
                System.out.println("Event Date :");
                String E_Date=sc.nextLine();
                System.out.println("Event Time :");
                String E_Time=sc.nextLine();
                System.out.println("Event Place :");
                String E_Place=sc.nextLine();
                System.out.println("Event Avenue :");
                String E_Avenue=sc.nextLine();
                System.out.println("Event Description (Name of the portfolio) :");
                String E_Description=sc.nextLine();
                System.out.println("Event Chair :");
                String E_Chair=sc.nextLine();
                System.out.println("Amount spent in Event :");
                double E_Amount=sc.nextDouble();
                System.out.println("Enter Member ID :");
                int Member_ID=sc.nextInt();
                UserControl us=new UserControl();
                int check=us.Event(E_Name,E_Date,E_Time,E_Place,E_Avenue,E_Description,E_Chair,E_Amount,Member_ID);
                if(check==1)
                {
                    System.out.println("Event added Successfully");
                }
                else
                {
                    System.out.println("Adding the event failed :( ");
                    System.out.println("Check the Details once again please");
                }
            }
            public void delEvent() throws Exception
            {
               System.out.println("Enter the Event ID Number of the Event to delete");
               int Event_ID=sc.nextInt();
               UserControl us=new UserControl();
               int check=us.deleteEvent(Event_ID);
               if(check==1)
               {
                System.out.println("Event deleted successfully");
               }
               else{
                System.out.println("The process failed");
               }
            }

            private void showEvent() throws Exception
            {
             System.out.println("Enter the Event number that you want to view");
             int Event_ID=sc.nextInt();
             UserControl us=new UserControl();
             eventsDTO event=us.getEvents(Event_ID);
             if(event!=null)
             {
                System.out.println("Here is what you asked for ;) ");
                System.out.println("Event Number :"+Event_ID);
                System.out.println("Event Name :"+event.getE_Name());
                System.out.println("Event Date :"+event.getE_Date());
                System.out.println("Event Time :"+event.getE_Time());
                System.out.println("Event Place :"+event.getE_Place());
                System.out.println("Event Avenue :"+event.getE_Avenue());
                System.out.println("Event Description :"+event.getE_Description());
                System.out.println("Event Chair :"+event.getE_Chair());
                System.out.println("Event Amount :"+event.getE_Amount());
                System.out.println("Event Manager :"+event.getMember_ID());
             }
             else
             {
                System.out.println("Oops! No Event Found");
             }
            }
            private void showAll() throws Exception
            {
             System.out.println("Enter the Event number that you want to view");
             int Event_ID=sc.nextInt();
             UserControl us=new UserControl();
             eventsDTO event=us.getEvents(Event_ID);
             if(event!=null)
             {
                System.out.println("Here is what you asked for ;) ");
                System.out.println("Event Number :"+Event_ID);
                System.out.println("Event Name :"+event.getE_Name());
                System.out.println("Event Date :"+event.getE_Date());
                System.out.println("Event Time :"+event.getE_Time());
                System.out.println("Event Place :"+event.getE_Place());
                System.out.println("Event Avenue :"+event.getE_Avenue());
                System.out.println("Event Description :"+event.getE_Description());
                System.out.println("Event Chair :"+event.getE_Chair());
                System.out.println("Event Amount :"+event.getE_Amount());
                System.out.println("Event Manager :"+event.getMember_ID());
             }
             else
             {
                System.out.println("Oops! No Event Found");
             }
            }
            private void update() throws SQLException{
                System.out.println("Enter the event number that you need to update");
                int p=sc.nextInt();
                UserControl us=new UserControl();
                eventsDTO check=us.getEvents(p);
                if(check==null)
                {
                    System.out.println("Event you entered does not exist");
                }
                else{
                    boolean updating=true;
                    while(updating)
                    {
                        System.out.println("Press the specific number to update");
                        System.out.println(" 1 for Event Name");
                        System.out.println(" 2 for Event Date");
                        System.out.println(" 3 for Event Time");
                        System.out.println(" 4 for Event Place");
                        System.out.println(" 5 for Event Avenue");
                        System.out.println(" 6 for Event Description");
                        System.out.println(" 7 for Event Chair");
                        System.out.println(" 8 for Event Amount");
                        System.out.println(" 9 for Done Updating");
                        int upc=sc.nextInt();
                        switch(upc)
                        {
                            case 1:
                            System.out.println("Existing Name of the event :"+check.getE_Name());
                            System.out.println("Enter the new name");
                            String n=sc.next();
                            boolean updated=us.updateEventName(p,n);
                            if(updated)
                            {
                                System.out.println("New Event Name updation successful");
                            }
                            else
                            {
                                System.out.println("Failed to update the event name");
                            }
                            break;
                            case 2:
                            System.out.println("Existing Date of the event :"+check.getE_Date());
                            System.out.println("Enter the new name");
                            String date=sc.next();
                            boolean dateupdated=us.updateEventDate(p,date);
                            if(dateupdated)
                            {
                                System.out.println("New Event Date updation successful");
                            }
                            else
                            {
                                System.out.println("Failed to update the event Date");
                            }
                            break;
                            case 3:
                            System.out.println("Existing Time of the event :"+check.getE_Time());
                            System.out.println("Enter the new time");
                            String time=sc.next();
                            boolean timeupdated=us.updateEventTime(p,time);
                            if(timeupdated)
                            {
                                System.out.println("New Event Time updation successful");
                            }
                            else
                            {
                                System.out.println("Failed to update the event time");
                            }
                            break;
                            case 4:
                            System.out.println("Existing Place of the event :"+check.getE_Place());
                            System.out.println("Enter the new place");
                            String place=sc.next();
                            boolean placeupdated=us.updateEventPlace(p,place);
                            if(placeupdated)
                            {
                                System.out.println("New Event Place updation successful");
                            }
                            else
                            {
                                System.out.println("Failed to update the event place");
                            }
                            break;
                            case 5:
                            System.out.println("Existing Place of the event :"+check.getE_Avenue());
                            System.out.println("Enter the new place");
                            String avenue=sc.next();
                            boolean avenueupdated=us.updateEventAvenue(p,avenue);
                            if(avenueupdated)
                            {
                                System.out.println("New Event Avenue updation successful");
                            }
                            else
                            {
                                System.out.println("Failed to update the event avenue");
                            }
                            break;
                            case 6:
                            System.out.println("Existing Description of the event :"+check.getE_Description());
                            System.out.println("Enter the new description");
                            String des=sc.next();
                            boolean desupdated=us.updateEventDescription(p,des);
                            if(desupdated)
                            {
                                System.out.println("New Event Description updation successful");
                            }
                            else
                            {
                                System.out.println("Failed to update the event description");
                            }
                            break;
                            case 7:
                            System.out.println("Existing Chair of the event :"+check.getE_Chair());
                            System.out.println("Enter the new chair");
                            String chair=sc.next();
                            boolean chairupdated=us.updateEventChair(p,chair);
                            if(chairupdated)
                            {
                                System.out.println("New Event Chair updation successful");
                            }
                            else
                            {
                                System.out.println("Failed to update the event chair");
                            }
                            break;
                            case 8:
                            System.out.println("Existing amount  of the event :"+check.getE_Amount());
                            System.out.println("Enter the new amount");
                            double amount=sc.nextDouble();
                            boolean amountupdated=us.updateEventAmount(p,amount);
                            if(amountupdated)
                            {
                                System.out.println("New Event Amount updation successful");
                            }
                            else
                            {
                                System.out.println("Failed to update the event amount");
                            }
                            break;
                            case 9:
                            updating=false;
                            break;
                            default:
                            System.out.println("Invalid Choice");
                            break;
                        }
                    }
                }
            }


            public void viewAllBookedVolunteers() throws SQLException
            {
               
                VolunteerControl volunteerControl =new VolunteerControl();
                
                List<usersDTO> bookedVolunteers=volunteerControl.getAllBookedVolunteers();
                
                if(!bookedVolunteers.isEmpty())
                {
                    System.out.println("Booked Volunteers : ");
                    for(usersDTO volunteer : bookedVolunteers)
                    {
                        System.out.println("Volunteer ID: "+volunteer.getUser_ID());
                        System.out.println("Volunteer name :"+volunteer.getUser_Name());
                        System.out.println("Volunteer Contact :"+volunteer.getContact_No());
                        System.out.println("Volunteer Contact :"+volunteer.getRole());
                        System.out.println("Volunteer City: "+volunteer.getCity());
                        System.out.println("Volunteer DOB : "+volunteer.getDOB());
                        System.out.println("Volunteer Blood Group : "+volunteer.getBlood_group());
                        System.out.println("Volunteer Portfolio : "+volunteer.getPotfolio());
                    }
                }
                else
                {
                    System.out.println("No Volunteers currenty booked the event");
                }
            }
            private void viewAllForVolunteers() throws SQLException
            {
               
                VolunteerControl volunteerControl =new VolunteerControl();
                
                List<ForVolunteersDTO> t=volunteerControl.getAllForVolunteers();
                
                if(!t.isEmpty())
                {
                    System.out.println("Booked Events :");
                    for(ForVolunteersDTO volunteer : t)
                    {
                        System.out.println("Event_ID :"+volunteer.getEvent_ID());
                        System.out.println("FV_ID : "+volunteer.getFV_ID());
                        System.out.println("Amount donated :"+volunteer.getAmount_donated());
                        System.out.println("Feedback :"+volunteer.getFeedbacks());
                        System.out.println("Suggestions :"+volunteer.getSuggestions());
                    }
                }
                else{
                    System.out.println("No Volunteers filled yet");
                }
            }
        }

