<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.LichHen147"%>
<%@page import="model.KhachHang147"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đặt Lịch Hẹn</title>
</head>
<body>
    
    <%
        // Lấy đối tượng KhachHang147 từ session
        KhachHang147 khachhang147 = (KhachHang147) session.getAttribute("khachhang147");

        // Kiểm tra xem đối tượng khachhang147 có null không trước khi gọi các phương thức
        if (khachhang147 != null) {
    %>
        <p>Xin chào, mã khách hàng: <%= khachhang147.getMakh() %>!</p>
        <p>Tên khách hàng: <%= khachhang147.getTen() %>!</p>
    <%
        } else {
    %>
        <p>Không tìm thấy thông tin khách hàng.</p>
    <%
        }
    %>
      <%
        // Kiểm tra xem có thông báo thành công không
        Boolean appointmentSuccess = (Boolean) session.getAttribute("appointmentSuccess");
        if (appointmentSuccess != null && appointmentSuccess) {
            session.removeAttribute("appointmentSuccess"); // Remove the flag after showing the message
    %>
        <script type="text/javascript">
            alert("Đặt lịch hẹn thành công!");
        </script>
    <%
        }
    %>
    <h2>Chọn ngày đặt lịch</h2>
    <form method="post" action="DatLichHenServlet">
        
        <label for="datePicker">Chọn ngày và giờ:</label>
        <input type="datetime-local" id="datePicker" name="appointmentDate" required><br><br>

        <label for="name">Tên khách hàng:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="sdt">Số điện thoại:</label>
        <input type="tel" id="sdt" name="sdt" pattern="[0-9]{10}" required><br><br>
        
        <label for="diachi">Địa chỉ:</label>
        <input type="text" id="diachi" name="diachi" required><br><br>
        
        <button type="submit">Lưu</button>
    </form>

    <h2>Lịch hẹn gần đây</h2>
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>STT</th>
                <th>Tên</th>
                <th>SĐT</th>
                <th>Địa chỉ</th>
                <th>Ngày hẹn</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<LichHen147> listLichHen = (List<LichHen147>) session.getAttribute("list_lichhen147");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Định dạng mong muốn

                if (listLichHen != null && !listLichHen.isEmpty()) {
                    for (int i = 0; i < listLichHen.size(); i++) {
                        LichHen147 lichHen = listLichHen.get(i);
            %>
                        <tr>
                            <td><%= (i + 1) %></td>
                            <td><%= lichHen.getTen() %></td>
                            <td><%= lichHen.getSdt() %></td>
                            <td><%= lichHen.getDiachi() %></td>
                            <td><%= lichHen.getThoigian().toString() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="5">Không có lịch hẹn gần đây.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>
