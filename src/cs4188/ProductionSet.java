package cs4188;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ProductionSet {
	
	HashMap<String, Production> productions;
	
	ProductionSet(){
		productions = new HashMap<String, Production>();
	}
	
	
	public List<Production> toList(){
		
		List<Production> list = new ArrayList<Production>(); 
		//converting the hashmap into a list of productions
		for(Entry<String, Production> entry : productions.entrySet())
		{
			list.add(entry.getValue());
		}
		
		
		return list;
	}
	
	public Production getProduction(String key){
		return productions.get(key);
	}
	
	public void add(Production p){
		
		Production prod = productions.get(p.key);
		if(prod == null){
			productions.put(p.key, p);	
			
		}else{
			prod.add(p);
		}
	}
}
