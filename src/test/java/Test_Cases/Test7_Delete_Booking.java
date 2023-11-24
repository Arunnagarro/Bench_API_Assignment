package Test_Cases;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import BaseClass.Base_Class;
import ReusableMethods.reusablemethods;
import Utils.Path;
import io.restassured.specification.RequestSpecification;




public class Test7_Delete_Booking extends Base_Class
{
	String id = reusablemethods.delete_ID();
	
	@Test(priority=7)
	void Delete_Booking(ITestContext context)
	{
	
	String tk = (String) context.getAttribute("token");
			
	 RequestSpecification rs = httprequest;
				rs.header("Cookie","token="+tk)
				.when()
					.delete(Path.deleteBooking(id))
				.then()
					.log().all()
					.assertThat().statusCode(201);	
	
	log.info("-------------Delete Booking-------------------");	

				
	}
}