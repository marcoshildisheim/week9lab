package servlets;

import dataaccess.UserDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.UserService;

/**
 *
 * @author 758688
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})

public class UserServlet extends HttpServlet 
{    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        List<User> users = new ArrayList<>();
        UserService us = new UserService();
        
        try 
        {
            if(users != null)
            {
                users = null;
            }
            users = us.getAll();
            request.setAttribute("users", users);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        String action = request.getParameter("action");
        UserService us = new UserService();
        
        if (action.equals("add")) 
        {
            String email = request.getParameter("addEmail");
            String fname = request.getParameter("addFName");
            String lname = request.getParameter("addLName");
            String pw = request.getParameter("addPassword");
            int role = Integer.parseInt(request.getParameter("addRole"));
            
            try 
            {
                us.insert(email, true, fname, lname, pw, role);
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (action.equals("edit")) 
        {
            String editEmail = request.getParameter("email_e");
            String editFName = request.getParameter("FName_e");
            String editLName = request.getParameter("LName_e");
            String editPassword = request.getParameter("pw_e");
            String editRole = request.getParameter("role_e");

            request.setAttribute("editEmail", editEmail);
            request.setAttribute("editFName", editFName);
            request.setAttribute("editLName", editLName);
            request.setAttribute("editPassword", editPassword);
            request.setAttribute("editRole", editRole); 
        }
        else if (action.equals("delete")) 
        {
            String deleteEmail = request.getParameter("email_d");
            System.out.println(deleteEmail + "deleting");
            try 
            {
                us.delete(deleteEmail);
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (action.equals("save")) 
        {
            String email = request.getParameter("editEmail");
            String fname = request.getParameter("editFName");
            String lname = request.getParameter("editLName");
            String pw = request.getParameter("editPassword");
            int role = Integer.parseInt(request.getParameter("editRole"));
            
            try 
            {
                us.update(email, true, fname, lname, pw, role);
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (action.equals("cancel")) 
        {
            request.setAttribute("editEmail", "");
            request.setAttribute("editFName", "");
            request.setAttribute("editLName", "");
            request.setAttribute("editPassword", "");
            request.setAttribute("editPassword", "");             
        }
        
        List<User> users;
            try 
            {
                users = us.getAll();
                request.setAttribute("users", users);
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response); 
    }
}