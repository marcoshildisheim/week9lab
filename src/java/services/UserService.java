package services;

import dataaccess.*;
import java.util.List;
import models.User;

/**
 *
 * @author 813033
 */
public class UserService 
{
    
    public List<User> getAll() throws Exception 
    {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
      
    public void insert(String email, boolean active, String firstName, String lastName, String password, int role) throws Exception 
    {
        UserDB userDB = new UserDB();
        RoleDB roleDB = new RoleDB();
        
        User user = new User(email, active, firstName, lastName, password);
        user.setRole(roleDB.get(role));
        userDB.insert(user);
    }
    
    public void update(String email, boolean active, String firstName, String lastName, String password, int role) throws Exception 
    {
        UserDB userDB = new UserDB();
        RoleDB roleDB = new RoleDB();
        
        User user = userDB.get(email);
        
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setRole(roleDB.get(role));
    }
    
    public void delete(String email) throws Exception 
    {
        UserDB userDB = new UserDB();
        userDB.delete(userDB.get(email));
    }  
}
