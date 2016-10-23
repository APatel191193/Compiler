package cs4188;

import java.util.List;

public class MainCompiler {


	
	static String TERMINALS = "terminalList.txt";
	static String NONTERMINAL= "nonTerminalList.txt";
	static String GRAMMAR = "GrammarList.txt";


	public static void main(String[] args) {
		
		Grammar grammar = Grammar.loadGrammar(GRAMMAR);
		printProductions(grammar.getFirst());
		printProductions(grammar.getFollow());
	}
	
	public static void printProductions(List<Production> list){
		
		for(Production p: list){
			System.out.println(p);
		}
	}

}
