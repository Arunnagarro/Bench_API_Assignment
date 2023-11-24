package ReusableMethods;

import org.testng.annotations.BeforeMethod;

import BaseClass.Base_Class;

public class reusablemethods extends Base_Class {
	
	@BeforeMethod
	//Get booking id from property file
	public static String get_ID()		
	{
		String id = getProperty("Booking_ID");
		return id;
	}
	
	
	@BeforeMethod				
	public static String update_ID()
	{
		//Get updatebooking id from property file
		String id = getProperty("Update_ID");
		return id;
	}
	
	
	@BeforeMethod
	public static String partialUpdate_ID()		
	{
		// Partial Update id from property file
		String id = getProperty("PartialUpdate_ID");
		return id;
	}
	
	@BeforeMethod
	public static String delete_ID()	
	{
		// Delete booking id from property file
		String id = getProperty("Delete_ID");
		return id;
	}
}
