package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import model.LichHen147;

public class LichHen147DAO extends DAO {

    // Lưu lịch hẹn vào cơ sở dữ liệu
    public boolean save_lich_hen(LichHen147 lichhen147) {
    Connection conn = null;
    boolean isSuccess = false;

    try {
        conn = connect(); // Gọi trực tiếp connect()
        Statement stmt = conn.createStatement();
        String query = String.format(
            "INSERT INTO tbllichhen147 (thoigian, idkhachhang, ten, sdt, diachi) VALUES ('%s', '%s', '%s', '%s', '%s')",
            lichhen147.getThoigian(),
            String.valueOf(lichhen147.getIdkhachhang()),
            lichhen147.getTen(),
            lichhen147.getSdt(),
            lichhen147.getDiachi()
        );
        
        int rowsAffected = stmt.executeUpdate(query);
        isSuccess = rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    return isSuccess;
}

    // Lấy danh sách lịch hẹn theo mã khách hàng
   public List<LichHen147> get_list_lichhen_by_makh(int makh) throws SQLException {
    List<LichHen147> lichhen147List = new ArrayList<>();
    Connection conn = connect();

    try {
        Statement stmt = conn.createStatement();
        String query = String.format(
            "SELECT * FROM tbllichhen147 WHERE idkhachhang = '%s' ORDER BY id DESC LIMIT 5",
            makh
        );
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");

            // Lấy thời gian từ DB với múi giờ Asia/Ho_Chi_Minh
            java.sql.Timestamp thoigian = rs.getTimestamp("thoigian", Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh")));

            // Lấy các thông tin khác
            int idkhachhang = rs.getInt("idkhachhang");
            String ten = rs.getString("ten");
            String sdt = rs.getString("sdt");
            String diachi = rs.getString("diachi");

            // Gán dữ liệu vào đối tượng LichHen147
            LichHen147 lichHen = new LichHen147();
            lichHen.setId(id);
            lichHen.setThoigian(thoigian); // Thời gian đã tự động chuyển đổi sang GMT+7
            lichHen.setIdkhachhang(idkhachhang);
            lichHen.setTen(ten);
            lichHen.setSdt(sdt);
            lichHen.setDiachi(diachi);

            lichhen147List.add(lichHen);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            conn.close();
        }
    }
    return lichhen147List;
}

}
