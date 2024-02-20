<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="surya.model.Task" %>
<%@ page import="surya.service.TaskService" %>

<%-- <%
    TaskService taskService = new TaskService();
    List<Task> tasks = taskService.getAllTasks(); 
%> --%>
<%-- 
<% List<Task> tasks = (List<Task>) request.getAttribute("tasks"); %> --%>

<html>
<head>
    <title>Task Management System</title>
</head>
<body>
    <h1>Task List</h1>
    <div>
        <a href="add.jsp">Add New Task</a>
    </div>
    <table border="1">
        <tr>
            <th> ID </th>
            <th> Name </th>
            <th> Task Name </th>
            <th> Task Description </th>
            <th> Status </th>
            <th> Actions </th>
        </tr>
          <% List<Task> tasks = (List<Task>) request.getAttribute("tasks");
           if (tasks != null && !tasks.isEmpty()) {%>
        <% for (Task task : tasks) { %>
            <tr>
                <td><%= task.getId() %></td>
                <td><%= task.getName() %></td>
                <td><%= task.getDescription() %></td>
                <td><%= task.getCompleted() %>
                <%-- <td><%= task.isCompleted() ? "Completed" : "Incomplete" %></td> --%>
                <td>
                    <a href="edit.jsp?id=<%= task.getId() %>">Edit</a>
                    <form method="post" action="../TaskServlet">
                        <input type="hidden" name="delete" value="delete">
                        <input type="hidden" name="taskId" value="<%= task.getId() %>">
                        <input type="submit" name="sbt" value="delete">
                    </form>
                </td>
            </tr>
              <% }
           } else { %>
                <tr>
                    <td colspan="5">No tasks found.</td>
                </tr>
           <% } %>
     
    </table>
</body>
</html>