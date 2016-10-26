package cs4188;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class MainCompiler {

	static String TERMINALS = "terminalList.txt";
	static String NONTERMINAL = "nonTerminalList.txt";
	static String GRAMMAR = "GrammarList.txt";

	public static void main(String[] args) {
		//load grammar data
		Grammar grammar = new Grammar(GRAMMAR, TERMINALS);
		//print out first set and write it to file
		printProductions(grammar.getFirst(), "FirstAlgorithm.txt");
		// printProductions(grammar.getFollow("FollowAlgorithm.txt));
	}

	public static void printProductions(List<Production> list, String fileName) {

		try {
			File file = new File(fileName);
			if (!file.exists())
				file.createNewFile();

			PrintWriter writer;
			writer = new PrintWriter(fileName, "UTF-8");

			for (Production p : list) {
				writer.print(p);
				System.out.print(p);
			}
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
