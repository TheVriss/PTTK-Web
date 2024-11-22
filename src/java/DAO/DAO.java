package DAO;

import java.security.Timestamp;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class DAO {
    private static DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/MyDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    // Phương thức kết nối đến CSDL
    public static Connection connect() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            System.out.println("Connected to DB");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }

    public DAO() {
    }

    public Boolean login(String username, String passwd) throws SQLException {
        Connection conn = connect();
        if (conn == null) {
            System.out.println("Connection failed.");
            return false;
        }

        String query = String.format(
            "SELECT * FROM tblthanhvien147 WHERE username = '%s' AND passwd = '%s'", 
            username, passwd
        );

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error executing login query: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            conn.close();
        }
    }

 
    // Các phương thức truy vấn khác...
}
