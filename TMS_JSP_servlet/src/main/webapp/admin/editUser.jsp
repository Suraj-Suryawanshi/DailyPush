<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="surya.model.User" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>
    <% User user = (User) request.getAttribute("user");%>
      <%--  if (user != null) { %> --%>
            <form method="post" action="UserServlet">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="userId" value="<%= user.getUserId() %>">
                Role: 
                <select name="role">
                    <option value="admin" <%= user.getRole().equals("admin") ? "selected" : "" %>>Admin</option>
                    <option value="manager" <%= user.getRole().equals("manager") ? "selected" : "" %>>Manager</option>
                    <option value="employee" <%= user.getRole().equals("employee") ? "selected" : "" %>>Employee</option>
                </select><br>
                Username: <input type="text" name="userName" value="<%= user.getUserName() %>"><br>
                Email: <input type="email" name="userEmail" value="<%= user.getUserEmail() %>"><br>
                Date of Birth: <input type="text" name="userDob" value="<%= user.getUserDob() %>"><br>
                Address: <input type="text" name="userAddress" value="<%= user.getUserAddress() %>"><br>
                Password: <input type="password" name="password" value="<%= user.getPassword() %>"><br>
                <input type="submit" value="Update User">
            </form>
  <%--   <% } else { %>
            <p>User not found.</p>
    <% } %> --%>
</body>
</html>
