/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package toan.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import toan.dev.bean.StudentBean;
import toan.dev.data.dao.CategoryDao;
import toan.dev.data.dao.Database;
import toan.dev.data.dao.DatabaseDao;
import toan.dev.data.model.Category;

/**
 *
 * @author Admin
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Tạo một đối tượng StudentBean
        StudentBean student = new StudentBean();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setAge(20);
        
        // Lưu đối tượng vào session
        HttpSession session = request.getSession();
        session.setAttribute("student", student);
        
        request.getRequestDispatcher("home.jsp").include(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}