
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	public String stid;
	
	public MesoAsciiCal(MesoStation mesoStation) 
		{
			stid = mesoStation.getStID();
			
		}
	int calAverage(){
		//declare and intyalize avg
		int avg =0;
		//gets the char value of the average 
		//get the station id as an array of char
		char [] letters = stid.toCharArray();
		//set temp array 
		int [] temp = new int[letters.length];
		
		 //decalre and initalize sum
		double sum = 0;
		
		//loop through letter array
		for(int i = 0; i < letters.length; i++){
			//cast the char as an int in order to get it's ASCII value
			temp[i] = (int)letters[i];
		}
		//use our temp array to get the value of sum
		for(int i = 0; i < temp.length; i++){
			sum = sum + temp[i];
		}
		
		//divide by length to get average
		sum = sum/ temp.length;
		
		//set first index in array to ceiling of sum
		double ceilling = Math.ceil(sum);
		//set second index in array to floor of sum
		double floor =  Math.floor(sum);
		
		
		//sum casted as an int
		int sumi = (int)sum;
		
		double decimal = sum - sumi;
		
		//figure out what the vaerage will be equal to
		if(decimal >= 0.25){
			//sets to ceiling if >.5
			avg = (int)ceilling;
		} 
		//else sets to floor
		else
		{
			avg = (int)floor;
		}
		//gets average
		int average = ((avg + 79 )/2);
		return average;
		 
	
	}
	
}