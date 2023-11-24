package Test_Cases;

import java.io.File;
import java.util.HashMap;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import BaseClass.Base_Class;
import ReusableMethods.reusablemethods;
import Utils.Path;
import io.restassured.specification.RequestSpecification;


public class Test5_Update_Booking extends Base_Class
{
	
	String id = reusablemethods.update_ID();

	@Test(priority=5)
	void Update_Booking(ITestContext context)
	{
		//get token
		//String t = (String) context.getAttribute("token"); 
		String t = (String) context.getAttribute("token");
		
		System.out.print(t);
		
		File ub = new File("Body_Data/update_booking.json");
				
		HashMap<String,String> h = new HashMap();
		h.put("Content-Type","application/json");
		h.put("Accept","application/json");
		h.put("Cookie","token="+t);

		RequestSpecification rs = httprequest;
				rs.headers(h)
				.body(ub)
				.when()
					.put(Path.updateBooking(id))
				.then()
					.log().all()
					.assertThat().statusCode(200);
		log.info("----------------Update Booking----------------");	
	}
}