<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/index.css">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="loginServlet" method="post"> 
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required><br>
            <label for="rollId">Role:</label>
            <input type="text" id="roleId" name="roleId" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <button type="submit">Login</button>
        </form>

       
        <%-- Display error message if login fails --%>
        <% String error = request.getParameter("error");
            if (error != null && error.equals("1")) { %>
                <p style="color: red;">Invalid userName or password. Please try again.</p>
        <% } %>
       
        
    </div>
</body>
</html>