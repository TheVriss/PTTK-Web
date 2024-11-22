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

public class PhuTung147DAO extends DAO{
         public PhuTung147 get_PhuTung_by_id(int idphutung) throws SQLException {
        Connection conn = connect();
       PhuTung147 phutung147 = new PhuTung147();

        try {
            Statement stmt = conn.createStatement();
            String query = String.format(
                "SELECT * FROM tblphutung147 WHERE id = '%s'", 
                String.valueOf(idphutung)
            );
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                float gia = rs.getFloat("gia");
                phutung147.setId(id);
                phutung147.setTen(ten);
                phutung147.setGia(gia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return phutung147;
    }
}
