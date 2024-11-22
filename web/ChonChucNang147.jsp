<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chọn Chức Năng</title>
</head>
<body>
    <%
        // Lấy đối tượng KhachHang147 từ session
        KhachHang147 khachhang147 = (KhachHang147) session.getAttribute("khachhang147");
        NhanVienQuanLy147 nhanvienquanly147 =(NhanVienQuanLy147) session.getAttribute("nhanvienquanly147");
        // Kiểm tra xem đối tượng khachhang147 có null không trước khi gọi các phương thức
        if (khachhang147 != null) {
    %>
        <p>Xin chào, mã khách hàng: <%= khachhang147.getMakh() %>!</p>
        <p>Tên khách hàng: <%= khachhang147.getTen() %>!</p>
    <%
        } 
         if (nhanvienquanly147 != null) {
    %>
        <p>Xin chào, mã nhân viên quản lý: <%= nhanvienquanly147.getManv() %>!</p>
        <p>Tên nhân viên: <%= nhanvienquanly147.getTen() %>!</p>
    <%
        } 
    %>
    <h2>Chọn Chức Năng</h2>
    <form method="post" action="ChonChucNangServlet">
        <button type="submit" name="action" value="datlichhen">Đặt lịch hẹn</button>
        <button type="submit" name="action" value="thongke">Thống kê nhà cung cấp</button>
    </form>
</body>
</html>
