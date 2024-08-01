package Resources;
import java.util.Date;
public class paymentsDTO 
{
    private int Payment_ID;
    private int Event_ID;
    private int Member_ID;
    private Date P_Date;

    public paymentsDTO(){
        
    }
    
        public paymentsDTO(int Payment_ID, int Event_ID, int Member_ID, Date P_Date) {
            this.Payment_ID = Payment_ID;
            this.Event_ID = Event_ID;
            this.Member_ID = Member_ID;
            this.P_Date =P_Date;
        }

    public int getPayment_ID() {
        return this.Payment_ID;
    }

    public void setPayment_ID(int Payment_ID) {
        this.Payment_ID = Payment_ID;
    }

    public int getEvent_ID() {
        return this.Event_ID;
    }

    public void setEvent_ID(int Event_ID) {
        this.Event_ID = Event_ID;
    }

    public int getMember_ID() {
        return this.Member_ID;
    }

    public void setMember_ID(int Member_ID) {
        this.Member_ID = Member_ID;
    }

    public Date getP_Date() {
        return this.P_Date;
    }

    public void setP_Date(Date P_Date) {
        this.P_Date = P_Date;
    }
        
    }