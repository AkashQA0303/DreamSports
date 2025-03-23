package stepDefinitions;

import java.util.List;
import java.util.Map;

import baseUtilities.ConfigReader;
import baseUtilities.commonUtils;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import pojomodel.Todo;
import utilities.apiutils;
import utilities.customlogger;

public class todo extends commonUtils{
	    
	
	private Response todoResponse;
	

    @Given("User has the todo tasks")
    public void userHasTheTodoTasks() {
    	customlogger.info("Fetching todos from API");
    	 try {
    		 String endPoint = ConfigReader.getProperty("todos_url");
             todoResponse = apiutils.getApiData(baseUrl + endPoint);
             todoList = todoResponse.getBody().jsonPath().getList("", Todo.class);
             System.out.println("todoResponse : " + todoResponse.asString());
             customlogger.info("Successfully fetched and deserialized todos. Total tasks: " + todoList.size());
         } catch (Exception e) {
             customlogger.error("Error while fetching or deserializing todos: " + e.getMessage());
             throw new RuntimeException(e);
         }
    	
    }

}
