<%@page import="surya.model.Task"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="surya.service.TaskService"%>

<%--  <%
    TaskService taskService = new TaskService();
	
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        boolean completed = Boolean.parseBoolean(request.getParameter("completed"));

        Task task = new Task(0, name, description, completed); 
        taskService.addTask(task);

        response.sendRedirect("index.jsp");
        return;
    }
%> --%>
<%-- <%
Task task = new Task();
String select[] = request.getParameterValues("completed");
if (select != null && select.length != 0) {
	task.setCompleted("completed");
} else {
	task.setCompleted("incomplete");
}
%> --%>
<html>
<head>
<title>Add New Task</title>
</head>
<body>
	<h1>Add New Task</h1>
	<form method="post" action="../TaskServlet">
		Name: <input type="text" name="name" required><br>
		Description: <input type="text" name="description" required><br> 
		<label >Task Staus:</label> 
		<select id="completed" name="completed" required>
			<option value="complete">Complete</option>
			<option value="incomplete">Incomplete</option>
			
		</select>
		<!--  Completed: <input type="checkbox" name="completed" value="completed"
			value.isChecked==true ? value="completed" :value="incompleted"><br>
		 -->
		 <br><br><input type="submit" name="sbt" value="add">
	
	 </form>
</body>
</html>

