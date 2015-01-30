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

public class Part_B_buffer {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Please enter the file path");
		String path;
		Scanner input = new Scanner(System.in); 
		path = input.nextLine();
		System.out.println("Tokens and there frequencies are as follows:  ");
		Hashtable<String,Integer> tokenfreqcoll = new Hashtable<String, Integer>();
		tokenfreqcoll = ComputeWordFrequencies(path);                                   // function computing the frequencies of the tokens
		print(tokenfreqcoll);															// function for printing the token frequencies				
	}
	
	public static Hashtable<String,Integer> ComputeWordFrequencies(String path) throws IOException{
		File file = new File(path);
		String tokenstring;
		boolean flag=false,match=false;
		Hashtable<String, Integer> pairs = new Hashtable<String, Integer>();
		List<String> token = new ArrayList<String>();
		BufferedReader currline = new BufferedReader(new FileReader(file));
		tokenstring = currline.readLine();
		while(tokenstring != null){
			if(tokenstring.length()!=0){
			token = bufferreader.tokenise(tokenstring);
			if(token.size()>0){
			for(int i=0;i<token.size();i++){
				
				match = pairs.containsKey(token.get(i));
				if(match==true)
					pairs.put(token.get(i), (pairs.get(token.get(i))+1));
				else
					pairs.put(token.get(i),1);
				
			}
			}
			}
			tokenstring = currline.readLine();
		}

		return(pairs);
	}
	
	public static void print(Hashtable<String, Integer> tokenfreq){
		ArrayList<Map.Entry<String, Integer>> tokensort = new ArrayList(tokenfreq.entrySet());
		Collections.sort(tokensort, new Comparator<Map.Entry<String, Integer>>(){
    	 
         public int compare(Map.Entry<String, Integer> token1, Map.Entry<String, Integer> token2) {
            return token2.getValue().compareTo(token1.getValue());
         	}
		}
		);
		System.out.println(tokensort);
	}
		
}
