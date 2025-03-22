package utilities;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojomodel.Todo;

public class apiutils {
	
	public static Response getApiData(String url){
		try {
			customlogger.info("Sending GET request to URL: " + url);
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.when()
					.get(url)
					.then()
					.statusCode(200)
					.extract()
					.response();

			return response;	
		}
		catch (Exception e) {
            customlogger.error("Error during GET request to URL: " + url, e);
            throw e;
        }
		
	}
	
	
	public static Response postApiData(String url, Todo payload) {
		try {
			customlogger.info("Sending POST request to URL: " + url);
            customlogger.info("Payload: " + payload);
            Response response = RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post(url)
                    .then()
                    .extract()
                    .response();

            customlogger.info("POST request completed. Status Code: " + response.getStatusCode());
            return response;
        } catch (Exception e) {
            customlogger.error("Error during POST request to URL: " + url, e);
            throw e;
        }
	}
}
