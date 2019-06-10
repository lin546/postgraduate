package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	
	public static Date createDate(String model,String time) throws ParseException{
		DateFormat dateFormat1 = new SimpleDateFormat(model);  
	    Date date = dateFormat1.parse(time);  
	    return date;
	}
}
