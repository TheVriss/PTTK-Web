/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.KhachHang147;

/**
 *
 * @author MY PC
 */
public class KhachHang147DAO extends DAO{
      public KhachHang147 get_KH_by_idthanhvien(int id) throws SQLException {
        Connection conn = connect(); // Truy cập trực tiếp vào connect()
        
        try {
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM tblKhachHang147 WHERE idthanhvien = '%s'", String.valueOf(id));
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int makh = rs.getInt("makh");
                String ten = rs.getString("ten");
                String diachi = rs.getString("diachi");
                String sdt = rs.getString("sdt");
                int idthanhvien = id;
                KhachHang147 khachHang = new KhachHang147(makh, ten, diachi, sdt,idthanhvien);
                conn.close();
                return khachHang;
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
