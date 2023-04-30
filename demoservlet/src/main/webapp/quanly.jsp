<%@ page import="model.Users" %>
<%@ page import="java.util.Random" %>
<%@ page import="model.SanPham" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%! int number = 0;
%>
<% number += 1;
%>
<h1>QUẢN LÝ SẢN PHẨM</h1>
<% String contextPath = request.getContextPath();%>
<form action="<%=contextPath%>/quanly" method="post">
    <div class="form-group">
        <labe>Tên sản phẩm</labe>
        </label>
        <input type="text" class="form-control" name="name">
    </div>
    <div class="form-group">
        <label>Số lượng</label>
        <input type="number" class="form-control" name="quantity">
    </div>
    <div class="form-group">
        <label>Giá bán</label>
        <input type="number" class="form-control" name="price">
    </div>
    <button type="submit" class="btn btn-primary">Lưu lại</button>
</form>

<table border="1">
    <tr>
        <td>
            <div>STT</div>
        </td>
        <td>
            <div>Tên Sản Phẩm</div>
        </td>
        <td>
            <div>Số lượng</div>
        </td>
        <td>
            <div>Giá bán</div>
        </td>
    </tr>
    <c:forEach var="temp" items="${sanpham}">
        <tr>
            <td>
                <div><%=number  %>
                </div>
            </td>
            <td>
                <div>${temp.name}</div>
            </td>
            <td>
                <div>${temp.quantily}</div>
            </td>
            <td>
                <div>${temp.price}</div>
            </td>
        </tr>
    </c:forEach>

</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
<%--
    <%! %> : thẻ dùng để khai báo biến
    <% %> : thẻ dùng để xử lý logic code, thẻ đa năng
    <%= %>: thẻ xuất ra màn hình
 --%>