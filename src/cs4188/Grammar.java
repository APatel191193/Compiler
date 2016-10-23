package cs4188;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grammar {
	

	
	ProductionSet first, follow;
	List<Production> all;

	
	public static Grammar loadGrammar(String file){
		
		Grammar g = new Grammar();
		g.first = new ProductionSet();
		g.follow = new ProductionSet();
		g.all = new ArrayList<Production>();
		
		try{
			String line = null;
			FileReader fr = new FileReader(file);

			BufferedReader br = new BufferedReader(fr);
		

			while((line = br.readLine())!= null){
				String [] production = line.split("::");
				Production p = new Production(production);
				g.all.add(p);
			}

			br.close();

		}
		catch(FileNotFoundException E){
			System.out.println("File Not Found");
		}
		catch(IOException E){
			System.out.println("Error Reading File");
		}

		/*
		 * Rules for First Sets
		If X is a terminal then First(X) is just X!
		If there is a Production X → ε then add ε to first(X)
		If there is a Production X → Y1Y2..Yk then add first(Y1Y2..Yk) to first(X)
		First(Y1Y2..Yk) is either
		First(Y1) (if First(Y1) doesn't contain ε)
		OR (if First(Y1) does contain ε) then First (Y1Y2..Yk) is everything in First(Y1) <except for ε > as well as everything in First(Y2..Yk)
		If First(Y1) First(Y2)..First(Yk) all contain ε then add ε to First(Y1Y2..Yk) as well.
		*/
		List<Production> list = g.all;
		for(Production p: list)
		{
			if(p.produces("empty"))g.first.add(p);
			//else if()
		}
		
		
		
	/*
	 * Rules for Follow Sets
	First put $ (the end of input marker) in Follow(S) (S is the start symbol)
	If there is a production A → aBb, (where a can be a whole string) then everything in FIRST(b) except for ε is placed in FOLLOW(B).
	If there is a production A → aB, then everything in FOLLOW(A) is in FOLLOW(B)
	If there is a production A → aBb, where FIRST(b) contains ε, then everything in FOLLOW(A) is in FOLLOW(B)
	*/
		
		
		
		
		
		
		
		
		return g;
	}
	
	
	public List<Production> getFirst(){
		
		return first.toList();
	}
	
	public List<Production> getFollow(){
			
		return follow.toList();
	}
	

}
