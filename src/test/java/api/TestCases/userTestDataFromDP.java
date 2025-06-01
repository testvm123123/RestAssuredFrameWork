package api.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.EndPoints.userEndpoints;
import api.Payloads.UserPayload;
import api.Utilities.DataProviderClass;
import io.restassured.response.Response;

public class userTestDataFromDP {
	
	
	
	
	@Test(priority=1, dataProvider= "alldata", dataProviderClass=DataProviderClass.class)
	public void testcreateUser(String userID, String username,String Firstname,String lastName,String email,String password,String phone) {
		UserPayload usrPlds=new UserPayload();
		
		System.out.println("Test Data: userID ***********= " + userID);
		int id = (userID == null || userID.trim().isEmpty()) ? 0 : Integer.parseInt(userID);
		usrPlds.setId(id);
		System.out.println("Test Data: userID ***********= " + userID);
		//usrPlds.setId(Integer.parseInt(userID));
		usrPlds.setUsername(username);
		usrPlds.setFirstName(Firstname);
		usrPlds.setLastName(lastName);
		usrPlds.setEmail(email);
		usrPlds.setPassword(password);
		usrPlds.setPhone(phone);
		
		Response response = userEndpoints.createUser(usrPlds);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
