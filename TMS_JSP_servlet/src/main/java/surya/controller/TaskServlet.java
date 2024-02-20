package surya.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import surya.model.Task;
import surya.service.TaskService;

@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//    static List<Task> listTasks=new ArrayList<>();
	Task task = new Task();
	private TaskService taskService = new TaskService();
//	task = new Task();
//	taskService = new TaskService();

//    int nextId=0;
//	@Override
//	public void init() throws ServletException {
//		
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 try {
		        List<Task> tasks = taskService.getAllTasks();
				/*
				 * if (tasks == null || tasks.isEmpty()) { // If tasks list is empty or null,
				 * set an empty list to avoid NullPointerException in JSP tasks = new
				 * ArrayList<>(); }
				 */
		        request.setAttribute("tasks", tasks);
		        request.getRequestDispatcher("admin/adminDispTask.jsp").forward(request, response);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		// request.getParameter getting values which is entered by client user
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//    	 Task task=new Task(nextId++, "surya","xyz..",true);
//    	 Task task1=new Task(nextId++, "surya","xyz..",true);
//    	 Task task2=new Task(nextId, "sonu","xyz..",true);
//    	taskService.addTask(task);
//    	taskService.addTask(task1);
//    	taskService.addTask(task2);
//    	ArrayList<Task> displayTask=new ArrayList<>();
//    	System.out.println("\n"+displayTask);
//    	request.setAttribute("displayTask", displayTask);
//    	switch (action) {
//        case "add":
//            addTask(request, response);
//            break;
//        case "update":
//            updateTask(request, response);
//            break;
//        case "delete":
//            deleteTask(request, response);
//            break;
//    }
		String action = request.getParameter("sbt");
		System.out.println("action call" + action);
		if (action != null) {
			if ("add".equals(action)) {
				addTask(request, response);
			} else if ("delete".equals(action)) {
				deleteTask(request, response);
			} else if ("edit".equals(action)) {
				updateTask(request, response);
			} else {
				response.sendRedirect("admin/adminDispUser.jsp");
			}
		} else {
			response.sendRedirect("admin/adminDispUser.jsp"); // Redirect to index.jsp if no action parameter is provided
		}
	}

	private void addTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
//        boolean completed = Boolean.parseBoolean(request.getParameter("completed"));
		String completed = request.getParameter("completed");
//        String select[] = request.getParameterValues(completed);
//        if (select != null && select.length != 0) {
//        	task.setCompleted("Completed");
//        } else {
//        	task.setCompleted("Incomplete");
//        }
		/*
		 * if (completed == null) { completed = "incomplete"; }
		 */
//        if(completed.equals(completed)) {
//        	completed="completed";
//        }
//        else {
//        	completed="incomplete";
//        }
		System.out.println(">>>>>>>>>>>>>>>>>>>>>" + name + description + completed);

		Task task = new Task(1, name, description, completed); // ID will be assigned by TaskService
//        listTasks.add(task);
//        request.setAttribute("listTask", listTasks);
		taskService.addTask(task);
		System.out.println("taskServletAdd>>" + task);
		response.sendRedirect("admin/adminDispUser.jsp");

	}

	private void updateTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		TaskService taskService = new TaskService();
		int taskId = Integer.parseInt(request.getParameter("id"));
//		Task task = taskService.getTaskById(taskId);

//		int taskId = Integer.parseInt(request.getParameter("taskId"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
//        boolean completed = Boolean.parseBoolean(request.getParameter("completed"));
		String completed = request.getParameter("completed");
		System.out.println("update>>>>>>>>>>>>>>>"+completed);
		/*
		 * if (completed != null) { completed = "completed"; } else {
		 * completed="incomplete"; }
		 */
//		String select[] = request.getParameterValues(completed);
//		if (select != null && select.length != 0) {
//			task.setCompleted("Completed");
//		} else {
//			task.setCompleted("Incomplete");
//		}

		Task task = new Task(taskId, name, description, completed);

		taskService.updateTask(task);

		response.sendRedirect("admin/adminDispUser.jsp");
	}

	private void deleteTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		taskService.deleteTask(taskId);
		System.out.println("servlet delete>>>>>>>>");
		response.sendRedirect("admin/adminDispUser.jsp");
	}

}
