package controller;

import com.mysql.cj.Session;
import config.MysqlConfig;
import model.UserModel;
import model.Users;
import service.LoginService;
import sun.java2d.pipe.AAShapePipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie cookie = new Cookie("username", "nguyenvana");
////      Yêu cầu khởi tạo cookie
//        resp.addCookie(cookie);
//        Cookie[] cookies = req.getCookies();
//        for (Cookie item : cookies) {
//            if (item.getName().equals("username")) {
//                System.out.println("kiem tra " + item.getValue());
//            }
//        }
//        Cookie[] cookies = req.getCookies();
//        String userName = "";
//        String password = "";
//        for (Cookie item : cookies) {
//            if (item.getName().equals("username")) {
//                userName = item.getValue();
//            }
//            if (item.getName().equals("password")) {
//                password = item.getValue();
//            }
//        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        boolean isSuccess = loginService.checkLogin(email, password);
        if (isSuccess) {
            HttpSession session = req.getSession();
            Users users = new Users(email, password);
            session.setAttribute("user", users);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/profile.jsp");
        } else {
            req.setAttribute("msg", "Sai tên đăng nhập hoặc mật khẩu!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

}
