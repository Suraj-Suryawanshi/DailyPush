<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
body{
	display: flex;
	flex-direction:column;
	align-items: center;
	
}
</style>
</head>

<body>
	<div class="container">
		<h1>Welcome Admin</h1>
		<a href="userList.jsp" >Add User</a><br><br>
		<a href="adminDispTask.jsp" >Assign Task</a>
<!-- 		<form action="admin" method="post">
			 
			<label for="role">Role:</label> <input type="text" id="role"
				name="role" required><br> 
 -->		<!-- 
 			<label for="email">Email:</label>
 			<input type="text" id="email" name="email" required><br>
 			<label for="role:">Select Role:
			<select name="role" >
				<option value="Employee">Employee</option>
				<option value="Manager">Manager</option>
				<option value="Admin">Admin</option>
			</select>
			</label>
			<label for="password">Password:</label> <input type="password"
				id="password" name="password" required><br>
			<button type="submit">Login</button>
			<button type="link" >Login</button> 
			
		</form>-->
</body>
</html>