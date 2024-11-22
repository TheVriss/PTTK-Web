<%@page import="java.sql.Timestamp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin Nhà cung cấp và Hóa đơn Phụ tùng</title>
    </head>
    <body>
        <h1>Thông tin Nhà cung cấp</h1>
        <%
            // Ép kiểu các giá trị từ session
            NhaCungCap147 nhacungcap147 = (NhaCungCap147) session.getAttribute("nhacungcap147");
            Timestamp startTimestamp = (Timestamp) session.getAttribute("startTimestamp");
            Timestamp endTimestamp = (Timestamp) session.getAttribute("endTimestamp");

            if (nhacungcap147 != null) {
        %>
                <p>Tên nhà cung cấp: <%= nhacungcap147.getTen()%></p>
        <%
            } else {
        %>
                <p>Không tìm thấy thông tin nhà cung cấp trong session.</p>
        <%
            }

            if (startTimestamp != null && endTimestamp != null) {
        %>
                <p>Ngày bắt đầu: <%= startTimestamp %></p>
                <p>Ngày kết thúc: <%= endTimestamp %></p>
        <%
            } else {
        %>
                <p>Không tìm thấy thông tin ngày bắt đầu và ngày kết thúc trong session.</p>
        <%
            }
        %>

        <h1>Danh sách Hóa đơn Phụ tùng</h1>
        <%
            // Lấy và ép kiểu danh sách hóa đơn từ session
            List<HoaDonPhuTung147> list_hoadonphutung147 = (List<HoaDonPhuTung147>) session.getAttribute("list_hoadonphutung147");

            if (list_hoadonphutung147 != null) {
        %>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Tổng tiền</th>
                        <th>ID Nhà cung cấp</th>
                        <th>ID Nhân viên kho</th>
                        <th>Thời gian</th>
                    </tr>
        <%
                for (HoaDonPhuTung147 hoaDon : list_hoadonphutung147) {
        %>
                    <tr>
                        
                        <td> <a href="ChiTietNhaCungCap147Servlet?idhoadon=<%= hoaDon.getId() %>"><%= hoaDon.getId()%></a></td>
                        <td><%= hoaDon.getTongtien() %></td>
                        <td><%= hoaDon.getTblnhacungcap147id() %></td>
                        <td><%= hoaDon.getTblnhanvienkho147id() %></td>
                        <td><%= hoaDon.getThoigian() %></td>
                    </tr>
        <%
                }
        %>
                </table>
        <%
            } else {
        %>
                <p>Không tìm thấy danh sách hóa đơn phụ tùng trong session.</p>
        <%
            }
        %>
    </body>
</html>
