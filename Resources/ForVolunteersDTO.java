package Resources;

public class ForVolunteersDTO {
    private int FV_ID;
    private int Event_ID;
    private int Volunteer_ID;
    private double Amount_donated;
    private String Feedbacks;
    private String Suggestions;



public ForVolunteersDTO(int FV_ID,int Event_ID,int Volunteer_ID,double Amount_donated,String Feedbacks,String Suggestions)
{
    this.FV_ID=FV_ID;
    this.Event_ID=Event_ID;
    this.Volunteer_ID=Volunteer_ID;
    this.Amount_donated=Amount_donated;
    this.Feedbacks=Feedbacks;
    this.Suggestions=Suggestions;
}

    public ForVolunteersDTO() {
    //TODO Auto-generated constructor stub
}

    public int getFV_ID() {
        return this.FV_ID;
    }

    public void setFV_ID(int FV_ID) {
        this.FV_ID = FV_ID;
    }

    public int getEvent_ID() {
        return this.Event_ID;
    }

    public void setEvent_ID(int Event_ID) {
        this.Event_ID = Event_ID;
    }

    public int getVolunteer_ID() {
        return this.Volunteer_ID;
    }

    public void setVolunteer_ID(int Volunteer_ID) {
        this.Volunteer_ID = Volunteer_ID;
    }

    public double getAmount_donated() {
        return this.Amount_donated;
    }

    public void setAmount_donated(double Amount_donated) {
        this.Amount_donated = Amount_donated;
    }

    public String getFeedbacks() {
        return this.Feedbacks;
    }

    public void setFeedbacks(String Feedbacks) {
        this.Feedbacks = Feedbacks;
    }

    public String getSuggestions() {
        return this.Suggestions;
    }

    public void setSuggestions(String Suggestions) {
        this.Suggestions = Suggestions;
    }
}
