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
import models.User;

/**
 *
 * @author Craig Kubinec
 */
public class UserDB {
    
    public ArrayList<User> getAll() throws Exception {
        
    ArrayList<User> users = new ArrayList<>();
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    Connection connection = connectionPool.getConnection();
    PreparedStatement statement = null;
    ResultSet result = null;
    String sql = "SELECT * FROM user";
    
    try {
        statement = connection.prepareStatement(sql);
        result = statement.executeQuery();
        while(result.next()){
           String email = result.getString(1);
           int active = result.getInt(2);
           String firstName = result.getString(3);
           String lastName = result.getString(4);
           String password = result.getString(5);
           int role = result.getInt(6);
           User user = new User(email, active, firstName, lastName, password, role);
           users.add(user);
        }
    }
        finally {
        DBUtil.closeResultSet(result);
        DBUtil.closePreparedStatement(statement);
        connectionPool.freeConnection(connection);
    }
    
    return users;
  
    }

    public void insert(User user) throws Exception {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO user (email, active, first_name, last_name, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setInt(2, user.getActive());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getRole());
            statement.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(statement);
            pool.freeConnection(connection);
        }
    }

    public void update(User user) throws Exception {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null;
        String sql = "UPDATE user SET email=?, active=?, first_name=?, last_name=?, password=?, role=? WHERE email=?";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setInt(2, user.getActive());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getRole());
            statement.setString(7, user.getEmail());
            statement.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(statement);
            pool.freeConnection(connection);
        }
    }

    public void delete(User user) throws Exception {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement statement = null;
        String sql = "DELETE FROM user WHERE email=?";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(statement);
            pool.freeConnection(connection);
        }
    }

}
