package inforetrieve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Part_c_final {

	public static void main(String[] args) throws IOException {
		System.out.println("Please enter the file path");
		Hashtable<token_2, Integer> pairs = new Hashtable<token_2, Integer>();
		String path;
		Scanner input = new Scanner(System.in);
		path = input.nextLine();
		System.out.println("The 2gram and their frequencies are as follows:  ");
		pairs = Compute2GramFrequencies(path);								//function computing the 2 gram frequencies..
		print(pairs);														//function printing the 2 grams along-with their frequencies
		System.out.println("Total number of unique 2Grams are :  " + pairs.size());
	}
		
	public static Hashtable<token_2, Integer> Compute2GramFrequencies(String path) throws IOException{
		
		File file = new File(path);
		String tokenstring;
		boolean flag=false;
		Hashtable<token_2, Integer> pairs = new Hashtable<token_2, Integer>();
		List<String> token = new ArrayList<String>();
		BufferedReader currline = new BufferedReader(new FileReader(file));
		tokenstring = currline.readLine();
		String endline="";
		token = bufferreader.tokenise(tokenstring);
		
		while(tokenstring != null){
			if(tokenstring.length()!=0){
				token = bufferreader.tokenise(tokenstring);
				boolean check=false;
				int i=0;
				while(i<token.size()-1){
					token_2 twotoken = new token_2();                  //token_2 object created for every 2 gram
					twotoken.token1 = token.get(i);
					twotoken.token2 = token.get(i+1);
					if(!pairs.containsKey(twotoken)){					//token_2 object stored in Hashtable for every unique 2 gram
						pairs.put(twotoken,1);
					}
					else{
						pairs.put(twotoken,(pairs.get(twotoken)+1));
					}
					i++;
				}
				endline = token.get(i);
				tokenstring = currline.readLine();
				
				while(tokenstring!=null){
					if(tokenstring.length()!=0){
						token = bufferreader.tokenise(tokenstring);
						token_2 twotoken = new token_2();
						twotoken.token1 = endline;
						twotoken.token2 = token.get(0);
						if(!pairs.containsKey(twotoken)){
							pairs.put(twotoken,1);
						}
						else{
							pairs.put(twotoken,(pairs.get(twotoken)+1));
						}
						break;
					}
					else{
						tokenstring = currline.readLine();
					}
				}
				
			}
			else
				tokenstring = currline.readLine();
			}

	return(pairs);
	}	
	
	
	public static void print(Hashtable<token_2,Integer> pairs){
		
		ArrayList<Map.Entry<token_2, Integer>> ngramsort = new ArrayList(pairs.entrySet());
		Collections.sort(ngramsort, new Comparator<Map.Entry<token_2, Integer>>(){
    	 
         public int compare(Map.Entry<token_2, Integer> gram2_1, Map.Entry<token_2, Integer> gram2_2) {
            return gram2_2.getValue().compareTo(gram2_1.getValue());
         	}
			}
		);
		for(Map.Entry<token_2, Integer> gram_2 : ngramsort)
		{
			token_2 tok = gram_2.getKey();
			System.out.println(tok.token1 + "  " + tok.token2 + "  " + gram_2.getValue());
		
		}
		
	}
}
		
		


