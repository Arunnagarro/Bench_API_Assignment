package Test_Cases;

import static org.hamcrest.Matchers.equalTo;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClass.Base_Class;
import Utils.Path;
import io.restassured.specification.RequestSpecification;


public class Test4_Create_Booking extends Base_Class{
	
	
	@Test(priority=4)
	void Create_Booking()
	{
			//creating a instance file
		File cb= new File("Body_Data/create_booking.json");
		
//		JSONObject jsondata = new JSONObject();
//		jsondata.put("firstname","Arun");
//		jsondata.put("lastname","Singh");
//		jsondata.put("totalprice",500);
//		jsondata.put("depositpaid",true);
//		jsondata.put("checkin","2018-01-01" );
//		jsondata.put("checkout","2019-01-01" );
//		jsondata.put("additionalneeds","Breakfast" );
		
		RequestSpecification rs = httprequest;
		                rs.contentType("application/json")
						.body(cb)
						.when()
							.post(Path.createBooking())
						.then()
							.log().all()
							.assertThat().statusCode(200)
							//.body(jsondata);
							.body("booking.firstname",equalTo("Arun"),
									"booking.lastname",equalTo("Singh"),
									"booking.totalprice",equalTo(500));
		                
		   
					
		log.info("-----------------Booking Created-------------------");					
		
	}

}
