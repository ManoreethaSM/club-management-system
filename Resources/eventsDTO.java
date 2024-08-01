package Resources;
//import java.sql.Time;
//import java.time.LocalTime;
//import java.util.Date;
public class eventsDTO {
    private int Event_ID;
    private String E_Name;
    private String E_Date;
    private String E_Time;
    private String E_Place;
    private String E_Description;
    private String E_Chair;
    private double E_Amount;
    private String E_Avenue;
    private int Member_ID;
    public eventsDTO(int Event_ID,String E_Name,String E_Date,String E_Time,String E_Place,String E_Avenue,String E_Description,String E_Chair,double E_Amount,int Member_ID)
    {
        this.Event_ID=Event_ID;
        this.E_Name=E_Name;
        this.E_Date=E_Date;
        this.E_Time=E_Time;
        this.E_Place=E_Place;
        this.E_Description=E_Description;
        this.E_Chair=E_Chair;
        this.E_Amount=E_Amount;
        this.E_Avenue=E_Avenue;
        this.Member_ID=Member_ID;
    }

    public eventsDTO() {
        //TODO Auto-generated constructor stub
    }

    public int getEvent_ID() {
        return this.Event_ID;
    }

    public void setEvent_ID(int Event_ID) {
        this.Event_ID = Event_ID;
    }

    public String getE_Name() {
        return this.E_Name;
    }

    public void setE_Name(String E_Name) {
        this.E_Name = E_Name;
    }

    public String getE_Date() {
        return this.E_Date;
    }

    public void setE_Date(String E_Date) {
        this.E_Date = E_Date;
    }

    public String getE_Time() {
        return this.E_Time;
    }

    public void setE_Time(String E_Time) {
        this.E_Time = E_Time;
    }

    public String getE_Place() {
        return this.E_Place;
    }

    public void setE_Place(String E_Place) {
        this.E_Place = E_Place;
    }

    public String getE_Description() {
        return this.E_Description;
    }

    public void setE_Description(String E_Description) {
        this.E_Description = E_Description;
    }

    public String getE_Chair() {
        return this.E_Chair;
    }

    public void setE_Chair(String E_Chair) {
        this.E_Chair = E_Chair;
    }

    public double getE_Amount() {
        return this.E_Amount;
    }

    public void setE_Amount(double E_Amount) {
        this.E_Amount = E_Amount;
    }

    public String getE_Avenue() {
        return this.E_Avenue;
    }

    public void setE_Avenue(String E_Avenue) {
        this.E_Avenue = E_Avenue;
    }

    public int getMember_ID() {
        return this.Member_ID;
    }

    public void setMember_ID(int Member_ID) {
        this.Member_ID = Member_ID;
    }
}