/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;
/**
 *
 * @author Craig Kubinec
 */
public class RoleDB {
    
    public ArrayList<Role> getAll() throws Exception {
        
    ArrayList<Role> roles = new ArrayList<>();
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    Connection connection = connectionPool.getConnection();
    PreparedStatement statement = null;
    ResultSet result = null;
    String sql = "SELECT * FROM user";
    
    try {
        statement = connection.prepareStatement(sql);
        result = statement.executeQuery();
        while(result.next()){
           int roleID = result.getInt(1);
           String roleName = result.getString(2);
           Role role = new Role(roleID, roleName);
           roles.add(role);
        }
    } finally {
        DBUtil.closeResultSet(result);
        DBUtil.closePreparedStatement(statement);
        connectionPool.freeConnection(connection);
    }
    
    return roles;
  
    }

    public List<Role> getAll(int roleNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
