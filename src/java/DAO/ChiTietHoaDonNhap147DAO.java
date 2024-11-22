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
import java.util.List;
import model.*;
import java.sql.*;
import java.util.ArrayList;

public class ChiTietHoaDonNhap147DAO extends DAO{
         public List<ChiTietHoaDonNhap147> get_list_ChiTietHoaDonNhap147_by_idHoaDonNhap(int idhoadonnhap) throws SQLException {
        Connection conn = connect();
       List<ChiTietHoaDonNhap147> list_chitiethoadonnhap147 = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            String query = String.format(
                "SELECT * FROM tblchitiethoadonnhap147 WHERE tblhoadonphutung147id = '%s'", 
                String.valueOf(idhoadonnhap)
            );
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
               int soluong = rs.getInt("soluong");
               int tblhoadonphutung147id = rs.getInt("tblhoadonphutung147id");
              int  tblphutung147id = rs.getInt("tblphutung147id");
                float gianhap=rs.getFloat("gianhap");
               ChiTietHoaDonNhap147 tmp = new ChiTietHoaDonNhap147(id,soluong,tblhoadonphutung147id,tblphutung147id,gianhap);
               list_chitiethoadonnhap147.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list_chitiethoadonnhap147;
    }
}
