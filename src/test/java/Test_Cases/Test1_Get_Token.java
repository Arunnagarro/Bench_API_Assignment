package Test_Cases;

import static org.hamcrest.Matchers.instanceOf;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import BaseClass.Base_Class;
import Utils.Path;


public class Test1_Get_Token extends Base_Class{
	
	@Test(priority=1)
	void Create_Token(ITestContext context)
	{
		
		String body = "{\"username\":\"admin\","
					+ "\"password\":\"password123\"}";
		
		String get_token = httprequest
						.headers("Content-Type","application/json")
						.body(body)
					.when()
						.post(Path.createToken_Path())
					.then()
						.assertThat()
						.statusCode(200)
						.log().all()
						.body("token",instanceOf(String.class))
						.extract().jsonPath().getString("token");

		context.setAttribute("token", get_token);	
		System.out.println(get_token);
		
		log.info("----------Token Created----------");
		
	
		
		
	}

}
