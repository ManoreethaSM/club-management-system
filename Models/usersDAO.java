package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Resources.loginDTO;
import Resources.usersDTO;
import java.sql.SQLException;

public class usersDAO extends Connect {
    private static usersDAO instance;
    PreparedStatement getsignUp, getlogSign, isId;

    private usersDAO() throws SQLException {
        getsignUp = con.prepareStatement("INSERT INTO Users(User_Name,Contact_No,Role,City,DOB,Blood_group,Potfolio)Values(?,?,?,?,?,?,?)");
        getlogSign = con.prepareStatement("INSERT INTO login(Email,Password,User_ID)Values(?,?,?)");
        isId = con.prepareStatement("select User_ID from Users where Contact_No=?");

    }
    public static usersDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new usersDAO();
        }
        return instance;
    }
    public int getsignUp(usersDTO dummy) throws SQLException {
        getsignUp.setString(1, dummy.getUser_Name());
        getsignUp.setString(2, dummy.getContact_No());
        getsignUp.setString(3, dummy.getRole());
        getsignUp.setString(4, dummy.getCity());
        getsignUp.setString(5, dummy.getDOB());
        getsignUp.setString(6, dummy.getBlood_group());
        getsignUp.setString(7, dummy.getPotfolio());
        int rs = getsignUp.executeUpdate();

        return rs;

    }
    public int getId(String Contact_numb) throws SQLException {
        isId.setString(1, Contact_numb);
        ResultSet rs = isId.executeQuery();
        int D = 0;
        if (rs.next()) {
            D = rs.getInt(1);
        }
        return D;

    }
    public int getsignUp2(loginDTO tummy, int id) throws SQLException {
        getlogSign.setString(1, tummy.getEmail());
        getlogSign.setString(2, tummy.getPassword());
        getlogSign.setInt(3, id);
        int ps = getlogSign.executeUpdate();
        return ps;

    }

}
