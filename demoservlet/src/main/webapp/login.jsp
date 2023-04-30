<%@ page import="model.Users" %>
<%@ page import="java.util.Random" %>
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
<div class="container">
    <div class="row mt-5">
        <div class="col-md-5 m-auto mt-5">
            <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
            <div class="p-4 border mt-4">
                <!--
                action: Đường dẫn mà tham số được gửi về
                method: phương thức gửi tham số cho đường dẫn khai báo
                H
                -->
                <% String contextPath = request.getContextPath();%>
                <%--                <h1>${msg}</h1>--%>
                <%--                <b>${user.username}</b>--%>
                <%--                <b>${user.getPassword()}</b>--%>
                <%--                <c:out value="${msg}"/>--%>
                <%--                <c:if test="${user.password=='123'}">--%>
                <%--                    &lt;%&ndash;Nội dung thoả điều kiện if&ndash;%&gt;--%>
                <%--                    Mật khẩu của bạn là ${user.getPassword()}--%>
                <%--                </c:if>--%>
                <c:if test="${list!=null}">
                    <ul
                        <c:forEach var="temp" items="${list}">
                            <li>${temp}</li>
                        </c:forEach>
                    </ul>
                </c:if>
                <form action="<%=contextPath%>/login" method="post">
                    <div>${msg}</div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" name="username" value="${username}">
                    </div>
                    <div class="form-group">
                        <label>Mật khẩu</label>
                        <input type="password" class="form-control" name="password" value="${password}">
                    </div>
                    <div>
                        <input name="remember" type="checkbox"/>Nhớ mật khẩu
                    </div>
                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </form>
            </div>
        </div>
    </div>
</div>


<%--<h1>QUẢN LÝ SẢN PHẨM</h1>--%>
<%--<% String contextPath = request.getContextPath();%>--%>
<%--<form action="<%=contextPath%>/login" method="post">--%>
<%--    <div class="form-group">--%>
<%--        <labe>Tên sản phẩm</labe></label>--%>
<%--        <input type="text" class="form-control" name="name">--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <label>Số lượng</label>--%>
<%--        <input type="number" class="form-control" name="quantity">--%>
<%--    </div>--%>
<%--    <div class="form-group">--%>
<%--        <label>Giá bán</label>--%>
<%--        <input type="number" class="form-control" name="price">--%>
<%--    </div>--%>
<%--    <button type="submit" class="btn btn-primary">Lưu lại</button>--%>
<%--</form>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>STT</td>--%>
<%--        </tr>--%>
<%--    </table>--%>

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