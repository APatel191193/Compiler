package cs4188;

public class Production {
	
	String[] vals;
	String key;
	Production(String[] production){
		key = production[0];
		vals = production[1].split(" ");
	}
	
	
	public boolean produces(String val){
		
		for(int i = 0; i < vals.length; ++i)
		{
			if(val == vals[i])return true;
		}
		
		return false;
	}
}
