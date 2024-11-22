package controller;

import DAO.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.KhachHang147;
import model.LichHen147;
import model.ThanhVien147;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
@WebServlet("/DatLichHenServlet")
public class DatLichHenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang147 khachhang147 = (KhachHang147) session.getAttribute("khachhang147");

        if (khachhang147 != null) {
            // Truy xuất danh sách 5 lịch hẹn gần nhất cho khách hàng từ DAO
            LichHen147DAO lichhen147DAO = new LichHen147DAO();
            try {
                List<LichHen147> list_lichhen147 = lichhen147DAO.get_list_lichhen_by_makh(khachhang147.getMakh());
                session.setAttribute("list_lichhen147", list_lichhen147);
                 response.sendRedirect("DatLichHen147.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("errorPage.jsp");
                return;
            }
        }
        
        // Chuyển hướng đến trang DatLichHen.jsp
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Nhận các tham số từ form
    String appointmentDate = request.getParameter("appointmentDate");
String name = request.getParameter("name");
String sdt = request.getParameter("sdt");
String diachi = request.getParameter("diachi");

SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

try {
    java.util.Date parsedDate = format.parse(appointmentDate);
    Timestamp timestamp = new Timestamp(parsedDate.getTime());

    HttpSession session = request.getSession();
    KhachHang147 khachhang147 = (KhachHang147) session.getAttribute("khachhang147");

    if (khachhang147 != null) {
        // Khởi tạo và lưu lịch hẹn
        LichHen147 lichhen147 = new LichHen147();
        lichhen147.setThoigian(timestamp);
        lichhen147.setIdkhachhang(khachhang147.getMakh());
        
        // Gán thêm thông tin từ form vào đối tượng LichHen147
        lichhen147.setTen(name);
        lichhen147.setSdt(sdt);
        lichhen147.setDiachi(diachi);

        LichHen147DAO lichhen147DAO = new LichHen147DAO();
        boolean isSaved = lichhen147DAO.save_lich_hen(lichhen147); // Lưu trạng thái lưu thành công

        if (isSaved) {
            // Lấy lại danh sách 5 lịch hẹn gần nhất sau khi đặt lịch
            List<LichHen147> list_lichhen147 = lichhen147DAO.get_list_lichhen_by_makh(khachhang147.getMakh());
            session.setAttribute("list_lichhen147", list_lichhen147);
            session.setAttribute("appointmentSuccess", true); // Đặt cờ thành công
        } else {
            session.setAttribute("appointmentSuccess", false); // Đặt cờ thất bại nếu lưu không thành công
        }
    }

    // Quay lại trang lịch hẹn
    response.sendRedirect("DatLichHen147.jsp");

} catch (ParseException e) {
    e.printStackTrace();
    response.sendRedirect("errorPage.jsp"); // Chuyển đến trang lỗi nếu có lỗi khi phân tích ngày
} catch (SQLException e) {
    e.printStackTrace();
    response.sendRedirect("errorPage.jsp"); // Chuyển đến trang lỗi nếu có lỗi khi lưu vào cơ sở dữ liệu
}

}

}
