/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataaccess.UserDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        
        ArrayList<User> users;
        try {
            users = userDB.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            try {
                userDB.insert(user);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("user");
            //getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response);
        }
        else if (action.equals("edit")) {
            String editEmail = request.getParameter("edit");
            
            
        }
        else if (action.equals("delete")) {
            
            //userDB.delete(user);
        }
        else if (action.equals("save")) {
            String email = request.getParameter("editEmail");
            String fname = request.getParameter("editFName");
            String lname = request.getParameter("editLName");
            String pw = request.getParameter("editPassword");
            int role = Integer.parseInt(request.getParameter("editRole"));
            
            User user = new User(email, 1, fname, lname, pw, role);
            try {
                userDB.update(user);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("user");
        }
        else if (action.equals("cancel")) {
            request.setAttribute("editEmail", "");
            request.setAttribute("editFName", "");
            request.setAttribute("editLName", "");
            request.setAttribute("editPassword", "");
            request.setAttribute("editPassword", "");
            
            response.sendRedirect("user");
            
        }
        
    }


}