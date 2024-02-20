<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="surya.model.User" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <a href="admin/addUser.jsp">Add User</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Role</th>
            <th>Username</th>
            <th>Email</th>
            <th>Date of Birth</th>
            <th>Address</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        <% List<User> users = (List<User>) request.getAttribute("users");
           if (users != null && !users.isEmpty()) {
               for (User user : users) { %>
                    <tr>
                        <td><%= user.getUserId() %></td>
                        <td><%= user.getRole() %></td>
                        <td><%= user.getUserName() %></td>
                        <td><%= user.getUserEmail() %></td>
                        <td><%= user.getUserDob() %></td>
                        <td><%= user.getUserAddress() %></td>
                        <td><%= user.getPassword() %></td>
                        <td>
                            <a href="admin/editUser.jsp?userId=<%= user.getUserId() %>">Edit</a>
                            <form method="post" action="UserServlet">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="userId" value="<%= user.getUserId() %>">
                                <input type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
               <% }
           } else { %>
                <tr>
                    <td colspan="8">No users found.</td>
                </tr>
           <% } %>
    </table>
</body>
</html>
