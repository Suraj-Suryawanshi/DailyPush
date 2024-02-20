package surya.model;


public class Task1 {
	  
		private int id;
	    private String name;
	    private String taskName;
	    private String description;
	    private String assignDate;
	    private String completionDate;
	    private String completed;
	    
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getCompleted() {
			return completed;
		}
		public void setCompleted(String completed) {
			this.completed = completed;
		}
		
		
		public String getTaskName() {
			return taskName;
		}
		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}
		
		
		public String getAssignDate() {
			return assignDate;
		}
		public void setAssignDate(String assignDate) {
			this.assignDate = assignDate;
		}
		public String getCompletionDate() {
			return completionDate;
		}
		public void setCompletionDate(String completionDate) {
			this.completionDate = completionDate;
		}
		public Task1(int id, String name, String taskName, String description, String completed) {
			super();
			this.id = id;
			this.name = name;
			this.taskName = taskName;
			this.description = description;
			this.completed = completed;
		}
		@Override
		public String toString() {
			return "Task [id=" + id + ", name=" + name + ", description=" + description + ", completed=" + completed
					+ "]";
		}
	    
	    public Task1() {
	    	
	    }
	    

}









