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
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author MY PC
 */
public class NhaCungCap147DAO extends DAO{
    public NhaCungCap147 getNCCById(int idncc) throws SQLException{
         Connection conn = connect(); // Truy cập trực tiếp vào connect()
        NhaCungCap147 nhacungcap147 = new NhaCungCap147();
        try {
            Statement stmt = conn.createStatement();
            String query = String.format(
            "SELECT * FROM tblnhacungcap147 WHERE id = '%s'",
            String.valueOf(idncc)
        );
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                    int id = rs.getInt("id");
                    String ten = rs.getString("ten");
                    nhacungcap147.setId(id);
                    nhacungcap147.setTen(ten);
                   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return nhacungcap147;
    }
      public  List<NhaCungCap147>  get_list_all_NCC() throws SQLException {
        Connection conn = connect(); // Truy cập trực tiếp vào connect()
        List<NhaCungCap147> list_nhacungcap147 = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM tblnhacungcap147");
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                    int id = rs.getInt("id");
                    String ten = rs.getString("ten");
                    NhaCungCap147 tmp = new NhaCungCap147(id,ten);
                    list_nhacungcap147.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list_nhacungcap147;
    }
}
