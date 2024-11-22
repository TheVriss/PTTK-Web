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
import model.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/ThongKeNCCServlet")
public class ThongKeNCCServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String idNCCParam = request.getParameter("idNCC");
        
        // Kiểm tra nếu idNCC không tồn tại hoặc rỗng
        if (idNCCParam == null || idNCCParam.isEmpty()) {
            response.sendRedirect("ThongKeNCC147.jsp");
            return;
        }
        int idNCC = Integer.parseInt(idNCCParam);
        HttpSession session = request.getSession();
        Timestamp   startTimestamp = (Timestamp)session.getAttribute("startTimestamp");
        Timestamp endTimestamp =  (Timestamp)session.getAttribute("endTimestamp");
        HoaDonPhuTung147DAO hoadonphutung147DAO = new HoaDonPhuTung147DAO();
        NhaCungCap147DAO nhacungcap147DAO = new NhaCungCap147DAO();

        try {
            // Lấy thông tin nhà cung cấp
            NhaCungCap147 nhacungcap147 = nhacungcap147DAO.getNCCById(idNCC);

            // Lấy danh sách hóa đơn của nhà cung cấp
            List<HoaDonPhuTung147> list_hoadonphutung147 = hoadonphutung147DAO.get_listHoaDon_by_idNCC_Datetime(idNCC,startTimestamp,endTimestamp);

            // Đặt dữ liệu vào request attribute để chuyển đến JSP
            session.setAttribute("nhacungcap147", nhacungcap147);
            session.setAttribute("list_hoadonphutung147", list_hoadonphutung147);
            
            // Chuyển tiếp đến trang JSP hiển thị chi tiết
             response.sendRedirect("ChiTietNhaCungCap147.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
       

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");
        Timestamp startTimestamp;
        Timestamp endTimestamp;

        try {
            startTimestamp = Timestamp.valueOf(start + " 00:00:00");
            endTimestamp = Timestamp.valueOf(end + " 23:59:59");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
            return;
        }

        HoaDonPhuTung147DAO hoadonDAO = new HoaDonPhuTung147DAO();
        NhaCungCap147DAO nhacungcap147DAO = new NhaCungCap147DAO();
        ChiTietHoaDonNhap147DAO cthdDAO = new ChiTietHoaDonNhap147DAO();

        try {
            List<NhaCungCap147> list_nhacungcap147 = nhacungcap147DAO.get_list_all_NCC(); // Lấy danh sách nhà cung cấp
            List<TK_ncc147> list_tkncc147 = new ArrayList<>();

            for (NhaCungCap147 nhacungcap147 : list_nhacungcap147) {
                int totalQuantity = 0;
                List<HoaDonPhuTung147> listHoaDon = hoadonDAO.get_listHoaDon_by_idNCC_Datetime(nhacungcap147.getId(), startTimestamp, endTimestamp);

                for (HoaDonPhuTung147 hoaDon : listHoaDon) {
                    List<ChiTietHoaDonNhap147> listCTHD = cthdDAO.get_list_ChiTietHoaDonNhap147_by_idHoaDonNhap(hoaDon.getId());
                    for (ChiTietHoaDonNhap147 cthd : listCTHD) {
                        totalQuantity += cthd.getSoluong(); // Tính tổng số lượng hàng nhập
                    }
                }

                TK_ncc147 tmp = new TK_ncc147();
                tmp.setId(nhacungcap147.getId());
                tmp.setTen(nhacungcap147.getTen());
                tmp.setTongluonghangnhap(totalQuantity);
                list_tkncc147.add(tmp);

            }
             Collections.sort(list_tkncc147, new Comparator<TK_ncc147>() {
            public int compare(TK_ncc147 o1, TK_ncc147 o2) {
                return Integer.compare(o2.getTongluonghangnhap(), o1.getTongluonghangnhap());
            }
        });
            session.setAttribute("startTimestamp",startTimestamp );
              session.setAttribute("endTimestamp",endTimestamp );
            session.setAttribute("list_tkncc147", list_tkncc147);
            response.sendRedirect("ThongKeNCC147.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeNCCServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("error.jsp");
        }
    }
}
