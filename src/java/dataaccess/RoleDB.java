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

/**
 *
 * @author Craig Kubinec
 */
public class RoleDB {
    
    public ArrayList<User> getAll(String intake) throws Exception {
        
    ArrayList<User> users = new ArrayList<>();
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    Connection connection = connectionPool.getConnection();
    PreparedStatement statement = null;
    ResultSet result = null;
    String sql = "SELECT * FROM user WHERE email=?";
    
    try {
        statement = connection.prepareStatement(sql);
        statement.setString(1, sql);
        result = statement.executeQuery();
        while(result.next()){
           String email = result.getString(1);
           int active = result.getInt(2);
           String firstName = result.getString(3);
           String lastName = result.getString(4);
           String password = result.getString(5);
           int role = result.getInt(6);
           User user = new User(email, active, firstName, lastName, password, role);
           user.add(user);
        }
    } finally {
        DBUtil.closeResultSet(result);
        DBUtil.closePreparedStatement(statement);
        connectionPool.freeConnection(connection);
    }
    
    return users;
  
    
}
