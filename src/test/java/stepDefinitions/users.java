package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.Assert;

import baseUtilities.commonUtils;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import pojomodel.User;
import utilities.apiutils;
import utilities.customlogger;


public class users extends commonUtils {
	

	private Response userResponse;
	private List<User> users;

	
    @And("User belongs to the city {string}")
    public void userBelongsToTheCity(String city) {
    	try {
    		customlogger.info("Filtering users to identify FanCode City users based on lat and long.");
        	userResponse = apiutils.getApiData("https://jsonplaceholder.typicode.com/users");
        	if(userResponse.getStatusCode()!=200) {
        		 customlogger.error("API call failed. Status Code: " + userResponse.getStatusCode());
                 throw new AssertionError("Failed to fetch users. Status Code: " + userResponse.getStatusCode());
        	}
        	users = userResponse.getBody().jsonPath().getList("",User.class);
        	customlogger.info("Successfully fetched " + users.size() + " user details.");
        	fanCodeUserIds =  users.stream()
                    .filter(this::isValidFanCodeCity)
                    .map(User::getId)
                    .collect(Collectors.toList());
        	
        	 if (fanCodeUserIds.isEmpty()) {
                 customlogger.warn("No users found belonging to FanCode City based on lat/long criteria.");
             } else {
                 customlogger.info("Identified FanCode City Users with IDs: " + fanCodeUserIds);
                 System.out.println("Identified FanCode City Users with IDs: " + fanCodeUserIds);
             }

    	}
    	catch (Exception e) {
            customlogger.error("Exception while fetching user details: " + e.getMessage());
            throw new AssertionError(e.getMessage());
        }
    	
    	 
    }
    
    
    private boolean isValidFanCodeCity(User user) {
        try {
            double lat = Double.parseDouble(user.getAddress().getGeo().getLat());
            double lng = Double.parseDouble(user.getAddress().getGeo().getLng());
            return lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100;
        } catch (NumberFormatException e) {
            customlogger.error("Invalid latitude or longitude for user ID: " + user.getId());
            return false;
        }
    }

}
