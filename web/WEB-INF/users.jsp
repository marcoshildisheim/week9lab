<%-- 
    Document   : users
    Created on : Oct 29, 2020, 10:29:19 AM
    Author     : 789648
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="users.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <title>User editing</title>
    </head>
    <body>
        <h1>Add Users</h1>
        <form method="post" action="addUser">
            Email: <input type="text" name="addEmail"/><br>
            First Name: <input type="text" name="addFName"/><br>
            Last Name: <input type="text" name="addLName"/><br>
            Password: <input type="password" name="addPassword"/><br>
            Role: <select name="addRole">
                <option value="bedroom">System Admin</option>
                <option value="garage">Regular User</option>
                <option value="kitchen">Company Admin</option>
            </select><br>
            <submit value="Save"/><br>
        </form>
        
        <h1>Manage Users</h1>
        <table>
         <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.role}</td>
            </tr>
         </c:forEach>
        </table>
        
        <form method="post" action="EditUser">
            Email <input type="text" name="editEmail"/><br>
            First Name <input type="text" name="editFName"/><br>
            Last Name <input type="text" name="editLName"/><br>
            Password <input type="password" name="editPassword"/><br>
            Role <select name="editRole">
                <option value="bedroom">System Admin</option>
                <option value="garage">Regular User</option>
                <option value="kitchen">Company Admin</option>
            </select><br>
            <submit value="Save"/><br>
            <submit value="Cancel"/>
        </form>
    </body>
</html>
