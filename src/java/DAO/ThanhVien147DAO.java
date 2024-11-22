package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ThanhVien147;

public class ThanhVien147DAO extends DAO {

    // Lấy thông tin thành viên theo tên đăng nhập
    public ThanhVien147 getThanhVien147by_username(String username) throws SQLException {
        Connection conn = connect();
       ThanhVien147 thanhVien147 = null;

        try {
            Statement stmt = conn.createStatement();
            String query = String.format(
                "SELECT * FROM tblthanhvien147 WHERE username = '%s'", 
                username
            );
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("passwd");
                int role = rs.getInt("role");
                
               thanhVien147 = new ThanhVien147(id, username, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return thanhVien147;
    }
}
