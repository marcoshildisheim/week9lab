/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author 775653
 * 
 */
public class Role implements Serializable  {
    private int roleNum;
    private String roleDesc;

    public Role() {
        
    }

    public Role(int roleNum, String roleDesc) {
        this.roleNum = roleNum;
        this.roleDesc = roleDesc;
    }

    public int getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(int roleNum) {
        this.roleNum = roleNum;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    
    
    
}
