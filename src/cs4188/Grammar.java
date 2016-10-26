package cs4188;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grammar {

	ProductionSet first, follow;
	ProductionMap all;
	List<String> terminals;

	public Grammar(String grammarFile, String terminalFile) {

		//create production sets and a map to hold all initial productions in the grammar
		first = new ProductionSet();
		follow = new ProductionSet();
		all = new ProductionMap();
		terminals = new ArrayList<String>();

		//Read the prodution data into invididual productions in this try catch block
		try {

			// read in grammar productions
			String line = null;
			FileReader fr = new FileReader(grammarFile);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				String[] production = line.split("::");
				Production p = new Production(production);
				all.add(p);
			}

			br.close();

			//read in all the non terminals 
			String line2 = null;
			FileReader fr2 = new FileReader(terminalFile);
			BufferedReader br2 = new BufferedReader(fr2);
			while ((line2 = br2.readLine()) != null) {
				terminals.add(line2);
			}

			br2.close();

		} catch (FileNotFoundException E) {
			System.out.println("File Not Found");
		} catch (IOException E) {
			System.out.println("Error Reading File:" + E.getMessage());
		}

		//get all the not terminals and find the first and follow for each 
		List<String> list = all.getAllNonTerminals();

		for (String p : list) {
			first.add(getFirst(p));
		}

		for (String p : list) {
			//follow.add(getFollow(p));
		}

	}

	private Production getFollow(String key) {

		//TODO: Implement
		return null;
	}

	private Production getFirst(String key) {
		//create empty production where key is a non terminal that produces other symbols
		Production prod = new Production(key);
		// this list will hold all the terminals that is produced by the key
		List<String> vals = new ArrayList<String>();
		//find the first of the key and append the terminals to the values list
		findFirst(key, vals);
		//add the terminals to the list of produced symbols 
		prod.addProducedSymbols(vals);
		return prod;
	}

	private void findFirst(String symbol, List<String> values) {

		//if the symbol is a terminal or empty then add it to the list
		if (isTerminal(symbol) || symbol.equals("empty")) {
			values.add(symbol);
		} else {
			//otherwise, if its a non terminal get all the productions for that symbol
			//and find the first of those
			List<Production> productions = all.getProductions(symbol);
			for (Production prods : productions) {
				String firstSymbol = prods.getProducedSymbol(0);
				//if the first is the same as the symbol then skip it 
				if (prods.key.equals(firstSymbol))
					continue;
				findFirst(firstSymbol, values);
			}
		}
	}

	boolean isTerminal(String symbol) {
		//check to see if the symbol is in the list on terminals 
		for (String s : terminals) {

			if (s.equals(symbol))
				return true;
		}
		return false;
	}

	public List<Production> getFirst() {

		return first.toList();
	}

	public List<Production> getFollow() {

		return follow.toList();
	}

}
