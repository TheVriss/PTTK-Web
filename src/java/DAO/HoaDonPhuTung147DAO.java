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

/**
 *
 * @author MY PC
 */
public class HoaDonPhuTung147DAO extends DAO {

    public List<HoaDonPhuTung147> get_listHoaDon_by_idNCC_Datetime(int idncc, Timestamp start, Timestamp end) throws SQLException {
        Connection conn = connect(); // Truy cập trực tiếp vào connect()
        List<HoaDonPhuTung147> list_hoadonphutung147 = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String query = String.format(
                    "SELECT * FROM tblhoadonphutung147 WHERE tblnhacungcap147id = '%d' AND thoigian >= '%s' AND thoigian <= '%s'",
                    idncc,
                    start.toString(),
                    end.toString()
            );
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
               float tongtien = rs.getFloat("tongtien");
               int tblnhacungcap147id = rs.getInt("tblnhacungcap147id");
               int tblnhanvienkho147id = rs.getInt("tblnhanvienkho147id");
               Timestamp thoigian = rs.getTimestamp("thoigian");
                HoaDonPhuTung147 hoadonphutung147 = new HoaDonPhuTung147(id, tongtien, tblnhacungcap147id, tblnhanvienkho147id, thoigian);
                list_hoadonphutung147.add(hoadonphutung147);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list_hoadonphutung147;
    }
}
