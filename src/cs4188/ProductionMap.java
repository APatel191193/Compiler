package cs4188;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ProductionMap {

	HashMap<String, List<Production>> map;

	ProductionMap(){
		map = new HashMap<String, List<Production>>();
	}


	public List<String>getAllNonTerminals(){

		List<String> list = new ArrayList<String>(); 
		//convert the hashmap into a list 
		for(Entry<String, List<Production>> entry : map.entrySet())
		{
			list.add(entry.getKey());
		}
		return list;
	}

	public List<Production>getProductions(String key){


		return map.get(key);
	}

	public void add(Production p){
		//add production to the map with the terminal as the key and list of its productions as the value 
		List<Production> prods = map.get(p.key);
		if(prods == null){
			prods = new ArrayList<Production>();
			prods.add(p);
			map.put(p.key, prods);
		}else{
			prods.add(p);
		}
	}
}
