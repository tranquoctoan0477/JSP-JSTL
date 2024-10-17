/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package toan.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import toan.dev.data.dao.Database;
import toan.dev.data.dao.DatabaseDao;
import toan.dev.data.dao.UserDao;
import toan.dev.data.model.User;

/**
 *
 * @author tranq
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            response.sendRedirect("HomeServlet");
        } else {
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseDao.init(new Database());
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDao.findByEmail(email);
        if (user == null) {
            //Failed
            session.setAttribute("error", "Login Failed");
            response.sendRedirect("LoginServlet");
        } else {
            if (user.getPassword().equals(password)) {
                //Success
                session.setAttribute("user", user);
                response.sendRedirect("HomeServlet");
            } else {
                //Failed
                session.setAttribute("error", "Login Failed");
                response.sendRedirect("LoginServlet");
            }
        }
    }

}
