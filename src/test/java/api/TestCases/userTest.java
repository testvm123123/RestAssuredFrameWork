package api.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.EndPoints.userEndpoints;
import api.Payloads.UserPayload;
import io.restassured.response.Response;

public class userTest {
    Faker faker;
    UserPayload usrPlds;
    public static Logger logger;

    @BeforeClass
    public void generateFakeData() {
        usrPlds = new UserPayload();
        faker = new Faker();

        usrPlds.setId(faker.idNumber().hashCode());
        usrPlds.setFirstName(faker.name().firstName());
        usrPlds.setUsername(faker.name().username());
        usrPlds.setLastName(faker.name().lastName());
        usrPlds.setEmail(faker.internet().safeEmailAddress());
        usrPlds.setPhone(faker.phoneNumber().cellPhone());
        usrPlds.setPassword(faker.internet().password(5, 8));

        logger = LogManager.getLogger("rest.assured");
        logger.info("Test data generated for user: " + usrPlds.getUsername());
    }

    @Test(priority = 1)
    public void testCreateUser() {
        logger.info("Sending POST request to create user");
        Response response = userEndpoints.createUser(usrPlds);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("User created successfully");
    }

    @Test(priority = 2)
    public void testGetUser() throws InterruptedException {
        logger.info("Sending GET request to retrieve user");
        Thread.sleep(3000);
        Response response = userEndpoints.getUser(this.usrPlds.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("User retrieved successfully");
    }

    @Test(priority = 3)
    public void testUpdateUser() {
        logger.info("Sending PUT request to update user");
        usrPlds.setFirstName(faker.name().firstName());
        Response response = userEndpoints.updateUser(this.usrPlds.getUsername(), usrPlds);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("User updated successfully");
    }

    @Test(priority = 4)
    public void testDeleteUser() throws InterruptedException {
        logger.info("Sending DELETE request to delete user");
        Thread.sleep(3000);
        Response response = userEndpoints.deleteUser(this.usrPlds.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        
        logger.info("User deleted successfully************");
        logger.info("User deleted successfully");
    }
}
