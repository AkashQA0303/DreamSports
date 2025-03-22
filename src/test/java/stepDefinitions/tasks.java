package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import baseUtilities.commonUtils;
import io.cucumber.java.en.Then;
import pojomodel.Todo;
import utilities.customlogger;

public class tasks extends commonUtils{
	
	@Then("User Completed task percentage should be greater than {int}%")
	public void user_completed_task_percentage_should_be_greater_than(Integer percentage) {
		System.out.println("fanCodeUserIds: " + fanCodeUserIds);
		System.out.println("todoList size: " + todoList.size());
	   for(Integer userid: fanCodeUserIds) {
		   List<Todo> userTasks = new ArrayList<>();
		   for (Todo todo : todoList) {
	            if (todo.getUserId().equals(userid)) {
	                userTasks.add(todo);
	            }
	        }
		   
		   if (userTasks.isEmpty()) {
	            customlogger.warn("No tasks found for User ID: " + userid);
	            continue;
	        }
		   int completedTasks = 0;
	        
	        // Manually count completed tasks
	        for (Todo task : userTasks) {
	            if (task.getCompleted()) {
	                completedTasks++;
	            }
	        }
	        
	        double completionPercentage = (double) completedTasks / userTasks.size() * 100;
	        
	        customlogger.info("User ID: " + userid + " - Completed: " + completedTasks + "/" + userTasks.size() +
                    " (" + completionPercentage + "%)");

	        if (completionPercentage <= percentage) {
	            customlogger.error("Validation failed for User ID: " + userid + ". Completion percentage: " + completionPercentage + "%");
	            throw new AssertionError("User ID: " + userid + " has not completed more than " + percentage + "% tasks.");
	        }
	    }

	    customlogger.info("Validation passed. All users have completed more than " + percentage + "% tasks.");

		   
	   
	}

}
