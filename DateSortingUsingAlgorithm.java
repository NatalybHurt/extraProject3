import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class DateSortingUsingAlgorithm {
	Integer num = 1;
	LinkedHashMap<LocalDate, Integer> map = new LinkedHashMap<LocalDate, Integer>();

	private void read(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));

		// a variable that will increase by one each time another element is
		

		// sets String equal readline
		String lineOfData = br.readLine();
		// String to LocalDate

		while (lineOfData != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-M-dd");

			// convert sting to localDate
			LocalDate localDateObj = LocalDate.parse(lineOfData,dateTimeFormatter);
			// add to hashmap
			map.put(localDateObj, num);

			lineOfData = br.readLine();

			num = 1 + num;

		}

		br.close();

	}

	public void dateHashMapSortedDescending() throws IOException {
		read("SortingDates.txt");
		LocalDate [] arrayOfhm = (LocalDate[]) map.keySet().toArray();
        boolean swapped; 
        for (int i = 0; i < arrayOfhm.length - 1; i++)  
        { 
            swapped = false; 
            for (int j = 0; j <arrayOfhm.length  - i - 1; j++)  
            { 
                if (arrayOfhm[j].compareTo(arrayOfhm[j + 1]) < 0)  
                { 
                    //swap arr[j] and arr[j+1] 
                   LocalDate temp1 = arrayOfhm[j]; 
                    arrayOfhm[j] = arrayOfhm[j + 1]; 
                    arrayOfhm[j + 1] = temp1; 
                    swapped = true; 
                } 
            
            }
            if (swapped == false) 
                break; 
        }
        
        
        for (int i = 0; i < arrayOfhm.length - 1; i++) 
            System.out.println(arrayOfhm[i]);
	         
	}

	public void dateHashMapSorted() throws IOException {
		read("SortingDates.txt");
		/*//uses treemap to sort hashmap
		Map<LocalDate, Integer> print = new TreeMap<LocalDate, Integer>(map);
		//loops through map and prints outputs
		for (LocalDate lDate : print.keySet()) {
		    System.out.println(lDate);
		}*/
		// why doesnt it like this
		LocalDate [] arrayOfhm = (LocalDate[]) map.keySet().toArray();
	        boolean swapped; 
	        for (int i = 0; i < arrayOfhm.length - 1; i++)  
	        { 
	            swapped = false; 
	            for (int j = 0; j <arrayOfhm.length  - i - 1; j++)  
	            { 
	                if (arrayOfhm[j].compareTo(arrayOfhm[j + 1]) > 1)  
	                { 
	                    // swap arr[j] and arr[j+1] 
	                   LocalDate temp1 = arrayOfhm[j]; 
	                    arrayOfhm[j] = arrayOfhm[j + 1]; 
	                    arrayOfhm[j + 1] = temp1; 
	                    swapped = true; 
	                } 
	            
	            }
	            if (swapped == false) 
	                break; 
	        }
	        
	        
	        for (int i = 0; i < arrayOfhm.length - 1; i++) 
	            System.out.println(arrayOfhm[i]); 

	}
}


