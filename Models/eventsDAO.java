
package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Resources.eventsDTO;
public class eventsDAO extends Connect{
    private static eventsDAO instance;
    PreparedStatement adde,de,se,sa;
    PreparedStatement up,upd,upt,upp,updes,upc,upa,upav;
    private eventsDAO() throws SQLException
    {
     adde=con.prepareStatement("INSERT INTO Events(E_Name,E_Date,E_Time,E_Place,E_Avenue,E_Description,E_Chair,E_Amount,Member_ID)Values(?,?,?,?,?,?,?,?,?)");
     de=con.prepareStatement("DELETE FROM Events WHERE Event_ID=?");
     se=con.prepareStatement("SELECT * FROM Events WHERE Event_ID=?");
     sa=con.prepareStatement("SELECT * FROM Events");
     up=con.prepareStatement("UPDATE Events SET E_Name = ? WHERE Event_ID=?");
     upd=con.prepareStatement("UPDATE Events SET E_Date = ? WHERE Event_ID=?");
     upt=con.prepareStatement("UPDATE Events SET E_Time = ? WHERE Event_ID=?");
     upp=con.prepareStatement("UPDATE Events SET E_Place = ? WHERE Event_ID=?");
     updes=con.prepareStatement("UPDATE Events SET E_Description = ? WHERE Event_ID=?");
     upa=con.prepareStatement("UPDATE Events SET E_Amount = ? WHERE Event_ID=?");
     upav=con.prepareStatement("UPDATE Events SET E_Avenue = ? WHERE Event_ID=?");
    }
    public static eventsDAO getInstance() throws SQLException{
        if(instance==null)
        {
            instance=new eventsDAO();
        }
        return instance;
    }
    public int adde(eventsDTO p) throws SQLException{

        adde.setString(1,p.getE_Name());
        adde.setString(2,p.getE_Date());
        adde.setString(3,p.getE_Time());
        adde.setString(4,p.getE_Place());
        adde.setString(5,p.getE_Avenue());
        adde.setString(6,p.getE_Description());
        adde.setString(7,p.getE_Chair());
        adde.setDouble(8,p.getE_Amount());
        adde.setInt(9,p.getMember_ID());
        int ps=adde.executeUpdate();
        return ps;
    }
    public int eventsdelete(int Event_ID) throws SQLException{
        de.setInt(1,Event_ID);
        int s=de.executeUpdate();
        return s;
    }
    public eventsDTO getEvents(int Event_ID) throws SQLException{
        se.setInt(1,Event_ID);
        ResultSet rs=se.executeQuery();
        eventsDTO event=null;
        if(rs.next())
        {
            event = new eventsDTO();
            event.setE_Name(rs.getString("E_Name"));
            event.setE_Date(rs.getString("E_Date"));
            event.setE_Time(rs.getString("E_Time"));
            event.setE_Place(rs.getString("E_Place"));
            event.setE_Avenue(rs.getString("E_Avenue"));
            event.setE_Description(rs.getString("E_Description"));
            event.setE_Chair(rs.getString("E_Chair"));
            event.setE_Amount(rs.getDouble("E_Amount"));
            event.setMember_ID(rs.getInt("Member_ID"));

        }
        return event;
    }
    public List<eventsDTO> getAllEvents() throws Exception{
        ResultSet rs=sa.executeQuery();
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
public boolean updateEventName(int p,String n) throws SQLException
{
   up.setString(1,n);
   up.setInt(2,p);
   up.executeUpdate();
   return true;
}
public boolean updateEventDate(int p,String date) throws SQLException
{
    upd.setString(1,date);
    upd.setInt(2,p);
    upd.executeUpdate();
    return true;

}
public boolean updateEventTime(int p,String time) throws SQLException
{
   upt.setString(1,time);
   upt.setInt(2,p);
   upt.executeUpdate();
   return true;
}
public boolean updateEventPlace(int p,String place) throws SQLException
    {
        upp.setString(1,place);
        upp.setInt(2,p);
        upp.executeUpdate();
        return true;
    }
    public boolean updateEventAvenue(int p,String Avenue) throws Exception
    {
        upav.setString(1,Avenue);
        upav.setInt(2,p);
        upav.executeUpdate();
        return true;
    }
    public boolean updateEventDescription(int p,String des) throws SQLException
    {
        updes.setString(1,des);
        updes.setInt(2,p);
        updes.executeUpdate();
        return true;
    }   
    public boolean updateEventChair(int p,String chair) throws SQLException
    {
        upc.setString(1,chair);
        upc.setInt(2,p);
        upc.executeUpdate();
        return true;
    }
    public boolean updateEventAmount(int p,double Amount) throws SQLException
    {
        upa.setDouble(1,Amount);
        upa.setInt(2,p);
        upa.executeUpdate();
        return true;
    }
}
