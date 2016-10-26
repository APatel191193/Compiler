package cs4188;

import java.util.ArrayList;
import java.util.List;

public class Production {

	ArrayList<String> vals;
	String key;

	Production(String key) {
		this.key = key;
		vals = new ArrayList<String>();
	}

	Production(String[] production) {
		key = production[0].trim();// get the nonterminal
		vals = new ArrayList<String>();//list of produced symbols
		String[] values = production[1].trim().split(" ");
		//add any produced symbols to the list 
		for (String v : values) {
			vals.add(v.trim());

		}
	}

	/**
	 * This checks to see if this symbol is already in the list
	 * @param val
	 * @return
	 */
	public boolean produces(String val) {

		for (String v : vals) {
			if (val.equals(v))
				return true;
		}

		return false;
	}

	public int length() {
		//get the number symbols produced by this production
		return vals.size();
	}

	public void add(Production p) {
		if (p.key != key)
			return;

		for (String val : p.vals) {
			//check to see if value is already in the list so we don't add duplicates
			if (!produces(val)) {
				vals.add(val);
			}
		}
	}

	void addProducedSymbols(List<String> list) {

		for (String val : list) {
			//check to see if value is already in the list so we don't add duplicates
			if (!produces(val)) {
				vals.add(val);
			}
		}

	}

	void addProducedSymbol(String symbol) {
		//check to see if val is already in the list so we don't add duplicates
		if (!produces(symbol))
			vals.add(symbol);

	}

	public String toString() {

		String string = "";
		string += key + ":: ";
		for (String s : vals) {
			string += s + " ";
		}
		string += "\n";
		return string;
	}

	public String getProducedSymbol(int index) {

		return vals.get(index);
	}

}
