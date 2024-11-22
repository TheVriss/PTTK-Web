package controller;

import DAO.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

@WebServlet("/ChiTietNhaCungCap147Servlet")
public class ChiTietNhaCungCap147Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idhoadon = Integer.parseInt(request.getParameter("idhoadon"));
        ChiTietHoaDonNhap147DAO chitiethoadonnhat147DAO = new ChiTietHoaDonNhap147DAO();
        PhuTung147DAO phutung147DAO = new PhuTung147DAO();
        try {
            List<ChiTietHoaDonNhap147> list_chitiethoadonnhap147 = chitiethoadonnhat147DAO.get_list_ChiTietHoaDonNhap147_by_idHoaDonNhap(idhoadon);
            Map<ChiTietHoaDonNhap147,PhuTung147> map_chitiethoadon147_phutung147 = new HashMap<>();
            for(ChiTietHoaDonNhap147 chitiethoadonnhap147 :list_chitiethoadonnhap147 ){
                PhuTung147 tmp = phutung147DAO.get_PhuTung_by_id(chitiethoadonnhap147.getTblphutung147id());
                 map_chitiethoadon147_phutung147.put(chitiethoadonnhap147, tmp);
            }
            session.setAttribute("map_chitiethoadon147_phutung147", map_chitiethoadon147_phutung147);
            session.setAttribute("idhoadon", idhoadon);
            response.sendRedirect("ChiTietHoaDonPhuTung147.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietNhaCungCap147Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }
}
