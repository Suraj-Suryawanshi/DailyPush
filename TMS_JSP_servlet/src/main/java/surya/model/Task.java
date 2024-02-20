package surya.model;

public class Task {
	  
		private int id;
	    private String name;
	    private String description;
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
		public Task(int id, String name, String description, String completed) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.completed = completed;
		}
		@Override
		public String toString() {
			return "Task [id=" + id + ", name=" + name + ", description=" + description + ", completed=" + completed
					+ "]";
		}
	    
	    public Task() {
	    	
	    }
	    

}



















//public class Task {
//    private int id;
//    private String name;
//    private String description;
//    private boolean completed;
//
//    public Task(int id, String name, String description, boolean completed) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.completed = completed;
//    }
//
//    // Getters and setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public boolean isCompleted() {
//        return completed;
//    }
//
//    public void setCompleted(boolean completed) {
//        this.completed = completed;
//    }
//}
//

//	
