package controller;

import DAO.DAO;
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DAO dao = new DAO();
        
        boolean isValidUser = false;
        //dao.test();
        try {
            isValidUser = dao.login(username,password );
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

       if (isValidUser) {
            // Lấy session hiện tại hoặc tạo session mới nếu chưa có
            HttpSession session = request.getSession();
            // Lưu username vào session
            session.setAttribute("username", username);
            // Chuyển hướng đến trang chọn chức năng
            response.sendRedirect("ChonChucNangServlet"); 
       }
        else {
            response.getWriter().println("Invalid username or password.");
        }
    }
}
