/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DAO.connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.*;

/**
 *
 * @author MY PC
 */
public class NhanVienQuanLy147DAO extends DAO{
    public NhanVienQuanLy147 get_NVQL_by_idthanhvien(int id) throws SQLException {
        Connection conn = connect(); // Truy cập trực tiếp vào connect()
        
        try {
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM tblnhanvienquanly147 WHERE idthanhvien = '%s'", String.valueOf(id));
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int manv= rs.getInt("manv");
                String ten = rs.getString("ten");
                int idthanhvien = id;
                NhanVienQuanLy147 nhanvienquanly147 = new NhanVienQuanLy147(manv, ten,idthanhvien);
                conn.close();
                return nhanvienquanly147;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
}
