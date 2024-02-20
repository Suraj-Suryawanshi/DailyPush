<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="surya.model.Task1" %>
<%@ page import="surya.service.TaskService1" %>

<%
    TaskService1 taskService = new TaskService1();
    List<Task1> tasks = taskService.getAllTasks(); 
%>

<html>
<head>
    <title>Task Management System</title>
</head>
<body>
    <h1>Task List</h1>
    
    <table border="1">
        <tr>
            <th> ID </th>
            <th> Name </th>
            <th> Task Name </th>
            <th> Task Description </th>
            <th> Assign Date </th>
            <th> Completion Date
            <th> Status </th>
            <th> Actions </th>
        </tr>
        <% for (Task1 task : tasks) { %>
            <tr>
                <td><%= task.getId() %></td>
                <td><%= task.getName() %></td>
                <td><%= task.getDescription() %></td>
                <td><%= task.getAssignDate() %></td>
                <td><%= task.getCompletionDate() %></td>
                <td><%= task.getCompleted() %>
                <%-- <td><%= task.isCompleted() ? "Completed" : "Incomplete" %></td> --%>
                <td>
                    <a href="edit.jsp?id=<%= task.getId() %>">Edit</a>
               <%--      <form method="post" action="../TaskServlet">
                        <input type="hidden" name="delete" value="delete">
                        <input type="hidden" name="taskId" value="<%= task.getId() %>">
                        <input type="submit" name="sbt" value="delete">
                    </form> --%>
                </td>
            </tr>
        <% } %>
    </table>
</body>
</html>