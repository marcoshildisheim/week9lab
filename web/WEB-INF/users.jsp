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
        <link rel="stylesheet" href="users.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>User editing</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
         <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.email}</td>
                <td>${user.firstname}</td>
                <td>${user.lastname}</td>
                <td>${user.role}</td>
            </tr>
         </c:forEach>
        </table>
    </body>
</html>
