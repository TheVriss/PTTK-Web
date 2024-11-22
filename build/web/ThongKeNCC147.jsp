<%@page import="java.sql.Timestamp"%>
<%@page import="model.TK_ncc147"%>
<%@page import="java.util.List"%>
<%@page import="model.NhanVienQuanLy147"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thống Kê Nhà Cung Cấp</title>
    </head>
    <body>
        <%
            NhanVienQuanLy147 nhanvienquanly147 = (NhanVienQuanLy147) session.getAttribute("nhanvienquanly147");
            Timestamp startTimestamp = (Timestamp) session.getAttribute("startTimestamp");
            Timestamp endTimestamp = (Timestamp) session.getAttribute("endTimestamp");

            // Kiểm tra nếu đối tượng nhanvienquanly147 không null
            if (nhanvienquanly147 != null) {
        %>
        <p>Xin chào, mã nhân viên quản lý: <%= nhanvienquanly147.getManv() %>!</p>
        <p>Tên nhân viên quản lý: <%= nhanvienquanly147.getTen() %>!</p>
        <%
            }

            // Kiểm tra nếu startTimestamp và endTimestamp không null
            if (startTimestamp != null && endTimestamp != null) {
        %>
        <p>Thời gian bắt đầu: <%= startTimestamp %></p>
        <p>Thời gian kết thúc: <%= endTimestamp %></p>
        <%
            }
        %>

        <form action="ThongKeNCCServlet" method="POST">
            <label for="startDate">Ngày bắt đầu:</label>
            <input type="date" id="startDate" name="startDate"><br><br>

            <label for="endDate">Ngày kết thúc:</label>
            <input type="date" id="endDate" name="endDate"><br><br>

            <input type="submit" value="Thống Kê">
        </form>

        <h1>Thống Kê Nhà Cung Cấp</h1>
        <%
            List<TK_ncc147> list_tkncc147 = (List<TK_ncc147>) session.getAttribute("list_tkncc147");

            // Kiểm tra nếu danh sách list_tkncc147 tồn tại và không rỗng
            if (list_tkncc147 != null && !list_tkncc147.isEmpty()) {
        %>
        <table border="1">
            <tr>
                <th>ID Nhà Cung Cấp</th>
                <th>Tên Nhà Cung Cấp</th>
                <th>Tổng Số Lượng Hàng Nhập</th>
            </tr>
            <%
                for (TK_ncc147 ncc : list_tkncc147) {
            %>
            <tr>
                <td><%= ncc.getId() %></td>
                <td><a href="ThongKeNCCServlet?idNCC=<%= ncc.getId() %>"><%= ncc.getTen() %></a></td>
                <td><%= ncc.getTongluonghangnhap() %></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            } else {
        %>
        <p>Không có dữ liệu thống kê!</p>
        <%
            }
        %>
    </body>
</html>
