package surya.service;

import java.util.ArrayList;
import java.util.List;

import surya.model.Task1;

public class TaskService1 {
    private static List<Task1> tasks=new ArrayList<>();
    
    private  int nextId=1;
    
    
    
//    public TaskService1() {
////    	tasks = new ArrayList<>();
//        nextId = 0;
//        
//        addTask(new Task1(nextId, "surya","xyz..",true));
//   	 	addTask(new Task1(nextId, "ram","xyz..",true));
//   	 	addTask(new Task1(nextId, "sam","xyz..",true));
//    }

    public void addTask(Task1 task) {
        task.setId(nextId++);
        //adding task to list type arraylist tasks
        tasks.add(task);
        System.out.println("task added-------"+task.toString());
//      System.out.println("service layer add task done:");
        
    }

    public void updateTask(Task1 updatedTask) {
        for (Task1 task : tasks) {
            if (task.getId() == updatedTask.getId()) {
                task.setName(updatedTask.getName());
                task.setAssignDate(updatedTask.getAssignDate());
                task.setCompletionDate(updatedTask.getCompletionDate());
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

    public List<Task1> getAllTasks() {
    	
    	System.out.println("all task get--------------"+tasks);
        return tasks;
    }

    public Task1 getTaskById(int id) {
        for (Task1 task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}