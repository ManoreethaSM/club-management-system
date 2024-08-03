package Models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class paymentsDAO extends Connect
{
    private static paymentsDAO instance;
    private PreparedStatement insertStatement;
    public paymentsDAO() throws SQLException{
        insertStatement =con.prepareStatement("INSERT INTO Payments (Member_ID,Event_ID,P_Date) VALUES (?,?,?)");
    }
    public static paymentsDAO getInstance() throws SQLException
    {
        if(instance == null)
        {
            instance =new paymentsDAO();
        }
        return instance;
    }

    public boolean insertPayment(int Member_ID,int Event_ID,Date P_date) throws SQLException
    {
        insertStatement.setInt(1,Member_ID);
        insertStatement.setInt(2,Event_ID);
        insertStatement.setDate(3,P_date);

        int rowsAffected =insertStatement.executeUpdate();
        return rowsAffected > 0;
    }
}
