import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;



public class DateTimeTwo {
	
	public LinkedHashMap<LocalDate, Integer> DATES_ = new LinkedHashMap<LocalDate, Integer>();
	
	//uses this to get value of hasmap
	Integer num = 1;
	
	//get today
	LocalDate today = LocalDate.now();

	public void daysOfCurrentMonth() {
		//use localdate to set date to get 10th day for
		LocalDate tenthDay = LocalDate.of(2019,Month.OCTOBER, 10); 
		//uses DayOfWeek from api 
		DayOfWeek print10Day = tenthDay.getDayOfWeek();
		
		//use localdate to set date to get 10th day for
				LocalDate eighteenDay = LocalDate.of(2019,Month.OCTOBER, 18); 
				//uses DayOfWeek from api 
				DayOfWeek print18Day = eighteenDay .getDayOfWeek();
		
		System.out.println("The tenth day of this month is " + print10Day
				+ " and eighteenth is " + print18Day);
	}

	public void daysOfAnyMonth(int i, int j) {
		// TODO Auto-generated method stub
		LocalDate fifteenthDay = LocalDate.of(j,Month.of(i), 15);
		DayOfWeek get15Day = fifteenthDay.getDayOfWeek();
		LocalDate lastDay = LocalDate.of(j, Month.of(i), Month.of(i).maxLength() );
		DayOfWeek getLastDay = lastDay.getDayOfWeek();
		System.out.println("For the year (" + j + ") and month (" + i+ "), the fifteenth day is " 
		+  get15Day +" and the last day is " + getLastDay);
		
	}

	public void compareYear() throws IOException {
		//creates boolean
		boolean isLeapYear = false;
		String theYear = "";
		
		read();
		
		//loops through hasmap of text we read in
		for(Map.Entry<LocalDate, Integer> entry : DATES_.entrySet()){
			LocalDate key = entry.getKey();
			int keyYear = key.getYear();
			
			//test if year is a leapyear
			if(keyYear % 400 == 0){
				isLeapYear = true;
				theYear = " is a leap year, and Diffrence: ";
				
			}else if( keyYear % 100 == 0){
					isLeapYear = false;
					theYear = " is not a leap year, and Diffrence: ";
					
				}else if(keyYear % 4 == 0){
					isLeapYear = true;
					theYear = " is a leap year, and Diffrence: ";
					
				}else{
					isLeapYear = false;
					theYear = " is not a leap year, and Diffrence: ";
				}
			//use period to make getting diffrence easier
			Period timePeriod = Period.between(key, today);
			int yearDiff = timePeriod.getYears();
			int monthDiff = timePeriod.getMonths();
			int daysDiff = timePeriod.getDays();
			
			//print leapywar output
			System.out.println(keyYear + theYear + yearDiff + " years, " + monthDiff + " months, and "
					+ daysDiff + " days.");
		}
	
		}
	
	
	public void read()throws IOException
	   {
		   	//use BufferedReader to read our file in
			BufferedReader br = new BufferedReader(new FileReader("Dates.txt"));
			
			
			
			//a variable that will increase by one each time another element is added to the array
			//to ensure array size is correct
		
			
			//sets String equal readline
			String lineOfData = br.readLine();
			//String to LocalDate
			
			while(lineOfData != null){
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M.dd.yyyy");
			
			//convert sting to localDate
			LocalDate localDateObj = LocalDate.parse(lineOfData,dateTimeFormatter);   
			//add to hashmap
			DATES_.put(localDateObj,num);
			
			lineOfData  = br.readLine();
			
			num = 1 + num;
			
			}
			
			br.close();
	   
}

	public void dateHashMap() {
		// TODO Auto-generated method stub
		//print hashmap
		for(Map.Entry<LocalDate, Integer> entry : DATES_.entrySet()){
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		
	}

	public void dateHashMapSorted() {
		// TODO Auto-generated method stub
		Map<LocalDate, Integer> print = new TreeMap<LocalDate, Integer>(DATES_);
		for (LocalDate lDate : print.keySet()) {
		    System.out.println(lDate + ":" + print.get(lDate));
		}
	}

}
