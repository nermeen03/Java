/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persondetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;
/**
 *
 * @author nerme
 */
public class DataAccessLayer {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement pst;
    static{
        try {
            DriverManager.registerDriver(new ClientDriver());
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonalInfo", "root","root");
            System.out.println("Connection successful!");
            } catch (SQLException ex) {
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Connection failed.");
            }

    }
    public static boolean insert(Information user) throws SQLException {
    boolean finalResult = false;
    String sql = "INSERT INTO INFO VALUES(?,?,?,?,?,?)";
    PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt(1, user.getID());
        pst.setString(2, user.getFirstName());
        pst.setString(3, user.getSecondName());
        pst.setString(4, user.getLastName());
        pst.setString(5, user.getEmail());
        pst.setString(6, user.getPhone());

        int result = pst.executeUpdate();
        if (result > 0) {
            finalResult = true;
        }

    return finalResult;
}

    public static boolean delete(int id) throws SQLException{
        boolean finalResult = false;
        PreparedStatement pst = con.prepareStatement("DELETE FROM INFO WHERE ID = ?");
        pst.setInt(1,id);
        int result = pst.executeUpdate();
        if(result>0){
            finalResult = true;
        }
        return finalResult;
    }
    public static boolean update(Information user) throws SQLException {
    boolean finalResult = false;
    String sql = "UPDATE INFO SET FirstName=?, MiddleName=?, LastName=?, Email=?, Phone=? WHERE ID=?";
    PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, user.getFirstName());
        pst.setString(2, user.getSecondName());
        pst.setString(3, user.getLastName());
        pst.setString(4, user.getEmail());
        pst.setString(5, user.getPhone());
        pst.setInt(6, user.getID());

        int result = pst.executeUpdate();
        if (result > 0) {
            finalResult = true;
        }
    return finalResult;
}
    private static void createResultSet() throws SQLException {
        String query = "SELECT * FROM INFO";
        pst = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = pst.executeQuery();
    }

    public static Information first() throws SQLException {
        if (rs == null) {
            createResultSet();
        }
        if (rs.first()) {
            Information user = new Information();
            user.setID(rs.getInt("ID"));
            user.setFirstName(rs.getString("FirstName"));
            user.setSecondName(rs.getString("MiddleName"));
            user.setLastName(rs.getString("LastName"));
            user.setEmail(rs.getString("Email"));
            user.setPhone(rs.getString("Phone"));
            return user;
        }
        return null; 
    }

    public static Information last() throws SQLException {
        if (rs == null) {
            createResultSet(); 
        }
        if (rs.last()) {
            Information user = new Information();
            user.setID(rs.getInt("ID"));
            user.setFirstName(rs.getString("FirstName"));
            user.setSecondName(rs.getString("MiddleName"));
            user.setLastName(rs.getString("LastName"));
            user.setEmail(rs.getString("Email"));
            user.setPhone(rs.getString("Phone"));
            return user;
        }
        return null;
    }

    public static Information next() throws SQLException {
        if (rs == null) {
            createResultSet();
        }
        if (rs.next()) {
            Information user = new Information();
            user.setID(rs.getInt("ID"));
            user.setFirstName(rs.getString("FirstName"));
            user.setSecondName(rs.getString("MiddleName"));
            user.setLastName(rs.getString("LastName"));
            user.setEmail(rs.getString("Email"));
            user.setPhone(rs.getString("Phone"));
            return user;
        }
        return null;
    }

    public static Information prev() throws SQLException {
        if (rs == null) {
            createResultSet();
        }
        if (rs.previous()) {
            Information user = new Information();
            user.setID(rs.getInt("ID"));
            user.setFirstName(rs.getString("FirstName"));
            user.setSecondName(rs.getString("MiddleName"));
            user.setLastName(rs.getString("LastName"));
            user.setEmail(rs.getString("Email"));
            user.setPhone(rs.getString("Phone"));
            return user;
        }
        return null;
    }
}
