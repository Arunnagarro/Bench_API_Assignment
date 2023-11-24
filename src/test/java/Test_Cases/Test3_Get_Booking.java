package Test_Cases;

import static org.hamcrest.Matchers.instanceOf;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.Base_Class;
import ReusableMethods.reusablemethods;
import Utils.Path;
import io.restassured.response.Response;


public class Test3_Get_Booking extends Base_Class{
	
   //String id = reusablemethods.get_ID();
	
	@Test(priority=3)
	void Get_Booking()
	{
		
	Response response = httprequest
					.when()
						.get(Path.getBooking( reusablemethods.get_ID()))
					.then()
						.log().all()
						.assertThat()
						.statusCode(200)
						//.body("additionalneeds", instanceOf(String.class))
						.extract().response();
	int statuscode = response.statusCode();
	Assert.assertEquals(statuscode, 200,"Check for status code");
	
	log.info("-------------Get Booking---------------");

	
	}
}