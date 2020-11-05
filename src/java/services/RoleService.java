package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

/**
 *
 * @author 813033
 */
public class RoleService 
{
    
    public List<Role> getAll() throws Exception 
    {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll();
        return roles;
    }
    
}
