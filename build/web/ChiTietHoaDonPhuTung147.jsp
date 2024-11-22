<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List, model.ChiTietHoaDonNhap147, model.PhuTung147" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin Hóa đơn và Chi tiết</title>
    </head>
    <body>
        <h1>Thông tin Hóa đơn</h1>
        <%
            // Lấy idHoadon từ session
            Integer idhoadon = (Integer) session.getAttribute("idhoadon");

            // Kiểm tra nếu idhoadon tồn tại
            if (idhoadon != null) {
        %>
                <p>ID Hóa đơn: <%= idhoadon %></p>
        <%
            } else {
        %>
                <p>Không tìm thấy ID hóa đơn trong session.</p>
        <%
            }

            // Lấy map từ session
            Map<ChiTietHoaDonNhap147, PhuTung147> map_chitiethoadon147_phutung147 = 
                    (Map<ChiTietHoaDonNhap147, PhuTung147>) session.getAttribute("map_chitiethoadon147_phutung147");

            // Kiểm tra nếu map tồn tại
            if (map_chitiethoadon147_phutung147 != null) {
        %>
                <h2>Chi tiết Hóa đơn</h2>
                <table border="1">
                    <tr>
                        <th>Số lượng</th>
                        <th>Tên phụ tùng</th>
                        <th>Giá nhập</th>
                    </tr>
        <%
                // Duyệt qua các entry trong map
                for (Map.Entry<ChiTietHoaDonNhap147, PhuTung147> entry : map_chitiethoadon147_phutung147.entrySet()) {
                    ChiTietHoaDonNhap147 chiTiet = entry.getKey();
                    PhuTung147 phuTung = entry.getValue();
        %>
                    <tr>
                        <td><%= chiTiet.getSoluong() %></td>
                        <td><%= phuTung.getTen() %></td>
                        <td><%= chiTiet.getGianhap() %></td>
                    </tr>
        <%
                }
        %>
                </table>
        <%
            } else {
        %>
                <p>Không tìm thấy thông tin chi tiết hóa đơn trong session.</p>
        <%
            }
        %>
    </body>
</html>
