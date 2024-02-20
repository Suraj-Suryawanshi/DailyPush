package surya.service;

import java.util.ArrayList;
import java.util.List;

import surya.model.Task;

public class TaskService {
    private static List<Task> tasks=new ArrayList<>();
    
    private  int nextId=1;
    
    
    
//    public TaskService() {
////    	tasks = new ArrayList<>();
//        nextId = 0;
//        
//    }

    public void addTask(Task task) {
        task.setId(nextId++);
        //adding task to list type arraylist tasks
        tasks.add(task);
        System.out.println("task added-------"+task.toString());
//      System.out.println("service layer add task done:");
        
    }

    public void updateTask(Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == updatedTask.getId()) {
                task.setName(updatedTask.getName());
                task.setDescription(updatedTask.getDescription());
                task.setCompleted(updatedTask.getCompleted());
				/*
				 * if(str !=null) { task.setCompleted(str); } else {
				 * task.setCompleted("incomplete"); }
				 */                
                break;
            }
        }
    }

    public void deleteTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
        System.out.println("deleted----");
    }

    public List<Task> getAllTasks() {
    	
    	System.out.println("all task get--------------"+tasks);
        return tasks;
    }

    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}