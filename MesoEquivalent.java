import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class MesoEquivalent {
	
	String station = "";
	LinkedHashMap<String, Integer> hashmap;
	
	public MesoEquivalent(String stId) {
		hashmap = new LinkedHashMap<String, Integer>();
		station = stId;
	}

	public HashMap<String, Integer> calAsciiEqual() throws IOException {
		read("Mesonet.txt");
		//return hashmap
		return hashmap;
	}

	private void read(String filename) throws IOException {
		// TODO Auto-generated method stub
		//use BufferedReader to read our file in
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		//a variable that will increase by one each time another element is added to the array
		//to ensure array size is correct
		int numStation = 0;
		
		//ignores first 6 lines
		for(int i = 0; i < 3; ++i){
			br.readLine();
		}
		
		//sets String equal readline
		String lineOfData = br.readLine();

		while(lineOfData != null)
		{
			String station = new String();
			station = lineOfData.substring(10,14);
			MesoAsciiCal asciiAverage = new MesoAsciiCal(new MesoStation(station));
			int asciiAvg = asciiAverage.calAverage();		

			HashMap<String, Integer> asciiVal = new HashMap<String, Integer>();
			//put the keys and values into the hashmap
			asciiVal.put(station, asciiAvg);
			//get ascii interger avg value
			Integer avg = asciiVal.get(station);
			
			hashmap.put(station,avg);
			
			lineOfData = br.readLine();
			
		}
		
		br.close();
	}


}
