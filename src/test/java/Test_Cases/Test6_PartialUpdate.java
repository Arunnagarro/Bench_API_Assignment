package Test_Cases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import BaseClass.Base_Class;
import POJO_Class.pojo_class;
import ReusableMethods.reusablemethods;
import Utils.Path;
import io.restassured.specification.RequestSpecification;



public class Test6_PartialUpdate extends Base_Class {
	
	
String id = reusablemethods.partialUpdate_ID();
	
	@Test(priority=6)
	void Partial_Update(ITestContext context)
	{
		
		String tk = (String) context.getAttribute("token");
		
		
		
		pojo_class body = new pojo_class();
			body.setFirstname("Arun");
			body.setLastname("Singh");
		
			RequestSpecification rs = httprequest;
				rs.header("Content-Type","application/json")
				.header("Accept","application/json")
				.header("Cookie","token="+tk)
				.body(body)
				.when()
					.patch(Path.partialupdateBooking(id))
				.then()
					.assertThat().statusCode(200)					
					.log().all();	
				
		log.info("-----------Partial update booking---------------");

				
	}	

}
