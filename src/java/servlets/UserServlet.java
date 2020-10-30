/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author 758688
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDB userDB = new UserDB();
        ArrayList<User> users = userDB.getAll();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        UserDB userDB = new UserDB();
        
        if (action.equals("add")) {
            String email = request.getParameter("addEmail");
            String fname = request.getParameter("addFName");
            String lname = request.getParameter("addLName");
            String pw = request.getParameter("addPassword");
            int role = Integer.parseInt(request.getParameter("addRole"));
            
            User user = new User(email, 1, fname, lname, pw, role);
            userDB.insert(user);
            
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response);
        }
        else if (action.equals("edit")) {
            String editEmail = request.getParameter("edit");
            
            
        }
        else if (action.equals("delete")) {
            
        }
        else if (action.equals("save")) {
            
        }
        else if (action.equals("cancel")) {
            
        }
        
    }


}
