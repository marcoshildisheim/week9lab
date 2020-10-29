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
public class UserDB {
    
    public ArrayList<User> getAll(String intake) throws Exception {
        
    ArrayList<User> users = new ArrayList<>();
    ConnectionPool connectionPool = ConnectionPool.getInstance();
    Connection connection = connectionPool.getConnection();
    PreparedStatement statement = null;
    ResultSet result = null;
    String sql = "SELECT * FROM user WHERE email=?";
    
    try {
        statement = connection.prepareStatement(sql);
        statement.setString(1, intake);
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

    public void insert(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection connection = cp.getConnection();
        PreparedStatement statement = null;
        String sql = "INSERT INTO user (email, active, first_name, last_name, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, note.getTitle());
            statement.setString(2, note.getContents());
            statement.setString(3, note.getOwner());
            statement.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void update(Note note) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE note SET title=?, contents=? WHERE note_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContents());
            ps.setInt(3, note.getNoteId());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void delete(Note note) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM note WHERE note_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, note.getNoteId());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

}
