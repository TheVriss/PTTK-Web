package controller;

import DAO.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

@WebServlet("/ChonChucNangServlet")
public class ChonChucNangServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            
            ThanhVien147DAO thanhvien147DAO = new ThanhVien147DAO();
            try {
                ThanhVien147 thanhvien147 = thanhvien147DAO.getThanhVien147by_username(username);
                if (thanhvien147.getRole() ==0) {
                    KhachHang147DAO khachhang147DAO = new KhachHang147DAO();
                    KhachHang147 khachhang147 = khachhang147DAO.get_KH_by_idthanhvien(thanhvien147.getId());
                    // Lưu đối tượng khachhang147 vào session
                    session.setAttribute("khachhang147", khachhang147);
                }
                else if (thanhvien147.getRole() ==1){
                    NhanVienQuanLy147DAO nhanvienquanly147DAO = new NhanVienQuanLy147DAO();
                    NhanVienQuanLy147 nhanvienquanly147 = nhanvienquanly147DAO.get_NVQL_by_idthanhvien(thanhvien147.getId());
                     session.setAttribute("nhanvienquanly147", nhanvienquanly147);
                } 
            } catch (SQLException ex) {
                Logger.getLogger(ChonChucNangServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Chuyển tiếp đến trang ChonChucNang.jsp
            response.sendRedirect("ChonChucNang147.jsp");
        } else {
            // Nếu không có username trong session, chuyển hướng đến trang login
            response.sendRedirect("login147.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Kiểm tra nếu action là "datlichhen" thì chuyển hướng tới trang DatLichHen.jsp
        if ("datlichhen".equals(action)) {
            response.sendRedirect("DatLichHenServlet");
        } 
        // Nếu action là "thongke", chuyển hướng đến một trang khác hoặc thực hiện logic phù hợp
        else if ("thongke".equals(action)) {
            response.sendRedirect("ThongKeNCCServlet");
        } 
        // Nếu không có action hợp lệ, có thể chuyển hướng về trang mặc định hoặc hiển thị thông báo lỗi
        else {
            response.sendRedirect("ChonChucNang147.jsp");
        }
    }
}
