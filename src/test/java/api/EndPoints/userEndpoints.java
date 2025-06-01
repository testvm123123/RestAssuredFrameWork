package api.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import api.Payloads.UserPayload;
public class userEndpoints {
	
	
	public static Response createUser(UserPayload payload) {
		
		    Response response= given()
		     .contentType(ContentType.JSON)
		     .accept(ContentType.JSON)
		     .body(payload)
		      
		     .when()
		     .post(Routes.post_url);
		    
		    return response;
		
	}

    public static Response getUser(String userName) {
	    Response response=given()
	    .accept(ContentType.JSON)
	    .pathParam("username", userName)
	    
	    
	    .when()
	    .get(Routes.get_url);
	    
	    return response;
	
    }
     
    public static Response updateUser(String userName, UserPayload payloads) {
	    Response response=given()
	    .contentType(ContentType.JSON)
	    .pathParam("username", userName)
	    .body(payloads)
	    
	    .when()
	    .put(Routes.put_url);
	    
	    return response;
	
    }
    
    public static Response deleteUser(String userName) {
	    Response response=given()
	    .accept(ContentType.JSON)
	    .pathParam("username", userName)
	    
	    
	    .when()
	    .delete(Routes.delete_url);
	    
	    return response;
	
    }
     
}

