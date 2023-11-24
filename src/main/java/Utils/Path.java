package Utils;

public class Path 
{
	
	public static String createToken_Path()
	{
		//Path for a creating token
		String resource = "/auth"; 			
		return resource;
	}
	
	public static String getBookingIds_Path() 
	{
		//Path for Get Booking_Ids
		String resource = "/booking";			
		return resource;
	}
	
	public static String getBooking(String id)
	{	
		//Path for Providing Single Id
		String resource = "/booking/" + id;		
		return resource;
	}
	
	
	public static String createBooking()
	{
		//Path for Creating Booking
		String resource = "/booking";		
		return resource;
	}
	
	
	public static String updateBooking(String id)
	{	
		//Path for Update Booking
		String resource = "/booking/" + id;		
		return resource;
	}
	
	public static String partialupdateBooking(String id)
	{	
		//Path for Partial Update Booking
		String resource = "/booking/" + id;		
		return resource;
	}	
	
	
	public static String deleteBooking(String id)
	{	
		//Path for Delete Booking
		String resource = "/booking/" + id;		
		return resource;
	}
	
}