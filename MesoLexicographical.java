import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class MesoLexicographical extends MesoSortedAbstract
{
	Map<String, Integer> toReturn;
	
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		TreeMap<String, Integer> sortedMap = new TreeMap<>(asciiVal);
		for(String str: sortedMap.keySet()){
			System.out.println(str);
		}
	}

	@Override
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		return null;
	}
}

