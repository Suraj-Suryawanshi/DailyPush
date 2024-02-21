<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.surya.model.User" %>
<%@ page import="com.surya.dao.UserDao" %>

<%@ page import="com.surya.dao.UserDaoImpl" %> 

<%
 	
	 //UserDaoImpl userDaoImpl = new UserDaoImpl();
    //int userId = Integer.parseInt(request.getParameter("userId"));
  //  User user = userDaoImpl.getUserById(userId); 
    User user = (User) request.getAttribute("user");
    System.out.println(user);
/* 
    if (task == null) {
        // Handle task not found error
        response.sendRedirect("admin/admin1.jsp");
        return;
    }
 */
    /* if ("POST".equalsIgnoreCase(request.getMethod())) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        boolean completed = Boolean.parseBoolean(request.getParameter("completed"));

        task.setName(name);
        task.setDescription(description);
        task.setCompleted(completed);

        taskService.updateTask(task);

        response.sendRedirect("index.jsp");
        return;
    } */
%>
 <% //User user = (User) request.getAttribute("user"); %>
        
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>
    <form method="post" action="userServlet">
        ID: <input type="text" name="id" value="<%= user.getUserId() %>" readonly><br>
        UserName: <input type="text" name="name" value="<%= user.getUserName() %>" required><br>
        UserDob: <input type="date" name="name" value="<%= user.getUserDob() %>" required><br>
        UserRole: 
     <%--    <select name="myList">
<% for (String value : myValues) { %>
<option value="<%= value %>"><%= value %></option>
<% } %>
</select> --%>
        
        <%-- <select name="userRole">
            <option value="<%= user.getUserRole().equals("Admin") ? "selected" : ""%>">Admin</option>
            <option value="<%= user.getUserRole().equals("Manager") ? "selected" : ""%>">Manager</option>
            <option value="<%= user.getUserRole().equals("Employee")?"selected": "" %>">Employee</option>
        </select><br> --%>
        UserName: <input type="text" name="<%= user.getUserName() %>"><br>
        Email: <input type="email" name="<%= user.getUserEmail() %>"><br>
        Date of Birth: <input type="date" name="<%= user.getUserDob() %>"><br>
        Date of Joining: <input type="date" name="<%= user.getUserJoiningDate() %>"><br>
        User Salary: <input type="text" name="<%= user.getUserSalary() %>"><br>
        Address: <input type="text" name="<%= user.getUserSalary() %>"><br>
        Password: <input type="password" name="<%= user.getUserPassword() %>"><br>
       
        
        <%-- Completed: <input type="checkbox" name="completed" value="<%= task.getCompleted()%>"> --%><br>
       
        <input type="submit" name="sbt" value="edit">
    </form>
</body>
</html>