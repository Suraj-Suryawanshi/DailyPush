<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <h1>Add User</h1>
    <form method="post" action="../UserServlet">
        <input type="hidden" name="action" value="add">
        Role: 
        <select name="role">
            <option value="admin">Admin</option>
            <option value="manager">Manager</option>
            <option value="employee">Employee</option>
        </select><br>
        Username: <input type="text" name="userName"><br>
        Email: <input type="email" name="userEmail"><br>
        Date of Birth: <input type="date" name="userDob"><br>
        Address: <input type="text" name="userAddress"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Add User">
    </form>
</body>
</html>
