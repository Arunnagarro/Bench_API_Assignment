package Test_Cases;

import static org.hamcrest.Matchers.instanceOf;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.Base_Class;
import Utils.Path;
import io.restassured.response.Response;

public class Test2_Get_Booking_IDs extends Base_Class{
	
	@Test(priority=2)
	void Get_BookingIds()
	{
	
		Response response = httprequest
					.when()
						.get(Path.getBookingIds_Path())
					.then()
						.log().all()
						.assertThat()
						.statusCode(200)
						.body("bookingid",instanceOf(ArrayList.class))
						.extract().response();
						
		response.prettyPeek();
		
		Assert.assertEquals(response.statusCode(), 200,"Check for status code");
		
		log.info("----------------Getting the Booking ID------------------");

	}

}
