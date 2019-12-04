import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class DateTimeOne extends MesoDateTimeOneAbstract
{
	//declares calendar and format for dtateformat 
	Calendar calendar = new GregorianCalendar();
	SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy hh:mm a");
	
	//declare  variable for the currentTime
	LocalDateTime currentTime;
	
	//first hashmap
	LinkedHashMap<String,String> TIME_ZONES = new LinkedHashMap<String, String>();
	
	//hashmap with values of TIME_ZONES as keys
	LinkedHashMap<String,String> DATE_TIMES = new LinkedHashMap<String, String>();
	
	//Use this to make life easier for date diffrenbt time zone
	LocalDateTime gmtTimeZoned = LocalDateTime.now(ZoneId.of("GMT"));
	
	LocalDateTime bstTimeZoned = LocalDateTime.now(ZoneId.of("Asia/Dhaka"));
	
	LocalDateTime cstTimeZoned = LocalDateTime.now(ZoneId.of("America/Chicago"));

	//sets these to make my life easier for dateDiffrtent time zone
	public String gmtTime;
	
	public String bstTime;
	
	public String cstTime;
	
	
	
	
	
	//use a constructor to intalize the currentTime
	public DateTimeOne(){
		currentTime = LocalDateTime.now();
	}
	
	//get and return the current second value
	public int getValueOfSecond(){
		 return currentTime.getSecond();
	}
	
	//uses simpleDateFormat to get current date/time in correct format
	public void dateTimeNow(){
		 System.out.println("Current Date/Time: " + dateFormat.format(calendar.getTime()));
		 
	}
	
	public void sleepForFiveSec(){
	//try catch is used incase the sleep thread is interuppted
		try {
			//1000 miliseconds == 1 seconds 
			Thread.sleep(5000);                 
		}
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void dateTimeOfOtherCity(){
		//get time on server
		System.out.println("Time on Server: " + currentTime.toLocalTime().getHour() + ":" 
				+ currentTime.toLocalTime().getMinute());
		
		//uses these in dtateTimeDiffrentZone
		gmtTime =  gmtTimeZoned.toLocalTime().getHour() + ":" + gmtTimeZoned.toLocalTime().getMinute();
		
		bstTime = bstTimeZoned.toLocalTime().getHour() + ":"  + bstTimeZoned.toLocalTime().getMinute();
		
		cstTime = cstTimeZoned.toLocalTime().getHour() + ":"  + cstTimeZoned.toLocalTime().getMinute();
		
		//print times
		System.out.println("GMT: " + gmtTime);
		
		System.out.println("BST (90E): " + bstTime);
		
		System.out.println("CST (90W): " + cstTime);
		
		
	}
	
	public void dateTimeDifferentZone(){
		
		//use dateTimeFormater since we arent using calander
		DateTimeFormatter newFormatZoned = DateTimeFormatter.ofPattern("M/dd/yyyy");
		
		//creates these strings to make adding to our hashmap easier
		String gmtDateTimeZoned = gmtTimeZoned.format(newFormatZoned) + " " + gmtTime;
		
		String bstDateTimeZoned =  bstTimeZoned.format(newFormatZoned)+ " " + bstTime;
		
		String cstDateTimeZoned = cstTimeZoned.format(newFormatZoned)+ " " + cstTime;
		
		//print dtate with time for time zones
		System.out.println("GMT: " + gmtDateTimeZoned);
		 
		System.out.println("BST: " + bstDateTimeZoned);
		 
		System.out.println("CST: " + cstDateTimeZoned );
		 
		 //adds to hashmaps
		 TIME_ZONES.put("GMT",gmtDateTimeZoned);
		 TIME_ZONES.put("BST",bstDateTimeZoned);
		 TIME_ZONES.put("CST",cstDateTimeZoned);
		 
		//add two more timezones that we are given
		 TIME_ZONES.put("ZST", "11/05/2018 19:59");
		 TIME_ZONES.put("AST", "10/01/2020 19:59");
	}
	
	public void timeZoneHashMap(){
		System.out.println("Print Style 1:");
		Map<String, String> print1 = new TreeMap<String, String>(TIME_ZONES);
		for (String str : print1.keySet()) {
		    System.out.println(str + " " + print1.get(str));
		    //get new hashmap while getting this output
		}
		
		 DATE_TIMES.put(TIME_ZONES.get("AST"),"1");
		 DATE_TIMES.put(TIME_ZONES.get("ZST"),"1");
		 DATE_TIMES.put(TIME_ZONES.get("CST"),"1");
		 DATE_TIMES.put(TIME_ZONES.get("BST"),"1");
		 DATE_TIMES.put(TIME_ZONES.get("GMT"),"1");
		
		
		System.out.println("Print Style 3:");
		Map<String, String> print3 = new TreeMap<String, String>(DATE_TIMES);
		for (String str : print3.keySet()) {
		    System.out.println(str + " ");
		}
		
		System.out.println("Print Style 5: Final sorted Array:");
		DateTimeFormatter newFormatZoned = DateTimeFormatter.ofPattern("yyyy-M-dd");
		
		//creates these strings to make adding to our hashmap easier
		String gmtNewFormat = gmtTimeZoned.format(newFormatZoned) + "T" + gmtTime;
		String bstNewFormat = bstTimeZoned.format(newFormatZoned) + "T" + bstTime;
		String cstNewFormat = cstTimeZoned.format(newFormatZoned) + "T" + cstTime;
		String zstNewFormat = "2018-11-05T19:59";
		String astNewFormat = "2020-10-01T19:54";
		//creates array
		String [] localDateTime = new String[5];
		//adds the strings to the array
		localDateTime[4] = zstNewFormat;
		localDateTime[2]=  gmtNewFormat;
		localDateTime[1] = cstNewFormat;
		localDateTime[3] = bstNewFormat;
		localDateTime[0] = astNewFormat;
		for(int i = 0; i < localDateTime.length; i++){
			System.out.println(localDateTime[i]);
		}
	
	}
	
}

