/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.*;

/**
 *
 * @author 775653
 */
public class DBUtil {
    public static void closePreparedStatement(Statement ps){
        try {
            if(ps != null){
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void closeResultSet(ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
