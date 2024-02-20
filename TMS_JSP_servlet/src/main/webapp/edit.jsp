<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="surya.model.Task" %>
<%@ page import="surya.service.TaskService" %>

<%
    TaskService taskService = new TaskService();
    int taskId = Integer.parseInt(request.getParameter("id"));
    Task task = taskService.getTaskById(taskId);

    if (task == null) {
        // Handle task not found error
        response.sendRedirect("admin/adminDispUser.jsp");
        return;
    }

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

<html>
<head>
    <title>Edit Task</title>
</head>
<body>
    <h1>Edit Task</h1>
    <form method="post" action="../TaskServlet">
        Name: <input type="text" name="name" value="<%= task.getName() %>" required><br>
        Description: <input type="text" name="description" value="<%= task.getDescription() %>"><br>
        Completed: <input type="checkbox" name="completed" value="<%= task.getCompleted()%>"><br>
       
        <input type="submit" name="sbt" value="edit">
    </form>
</body>
</html>