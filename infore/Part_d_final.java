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

public class Part_d_final {

	public static void main(String[] args) throws IOException {
		System.out.println("Please enter the file path");
		String path;
		Scanner input = new Scanner(System.in); 
		path = input.nextLine();
		System.out.println("The palindromes and their corresponding frequencies are as follows:");
		Hashtable<String,Integer> palinfrequencies = new Hashtable<String, Integer>();
		palinfrequencies = ComputePalindromeFrequencies(path);
		printpalindrome(palinfrequencies);
		System.out.println("Total number of unique Palindromes are:  " + palinfrequencies.size());
	}
	
	
	public static Hashtable<String,Integer> ComputePalindromeFrequencies(String path) throws IOException{
		File file = new File(path);
		String tokenstring;
		boolean flag=false;
		List<String> token_prev = new ArrayList<String>(); 
		Hashtable<String, Integer> pairs = new Hashtable<String, Integer>();
		List<String> token = new ArrayList<String>();
		BufferedReader currline = new BufferedReader(new FileReader(file));
			
		while((tokenstring=currline.readLine())!=null)
		{
			
			if(tokenstring.length()!=0){
				token = bufferreader.tokenise(tokenstring);
				pairs = palindrome(token,token_prev,pairs);
				token_prev = token;
			}
			
		}
		return(pairs);
	}
	
	public static Hashtable<String,Integer> palindrome(List<String> token,List<String> token_prev,Hashtable<String,Integer> palindrome){
			int count=0,x=0,temp = 0;
			boolean palincheck = true,palinkeycheck=false,breakflag=false;
			String palin = new String();
			String[] inter = token.toArray(new String[0]);
			temp = 	token_prev.size();
			String[] inter_prev = token_prev.toArray(new String[0]);
			int poll=0;
			String palinstring = "";
			if(temp!=0){                                                        // run this module only if previous tokens are present
				int point = token_prev.size()-1;
				while(true){
				for(int curr=0;curr<=count;curr++){
					if((curr)>inter.length-1){
						breakflag=true;
						break;
					}
					palin = palin.concat(inter[curr]);
					poll=curr;
				}	
				if(breakflag==true){
					break;
				}
				if(palin.length()>15){
					break;
				}
				while(palin.length()<15){
				palincheck = palindromecheck(palin);
				if(palincheck == true){
					for(int curr=0;curr<=poll;curr++){
						if(curr==0){
							palinstring = inter[curr];
						}
						else{
						palinstring = palinstring.concat(" ").concat(inter[curr]);
						}
					}
					for(int curr=token_prev.size()-1;curr>point;curr--)
						palinstring = inter_prev[curr].concat(" ").concat(palinstring);
					if(palinstring.length()>1){
					palinkeycheck =  palindrome.containsKey(palinstring);
					if(palinkeycheck==false){
						palindrome.put(palinstring, 1);
					}
					else{
						palindrome.put(palinstring, (palindrome.get(palinstring)+1));
					}
					}
					//palinstring="";
					palincheck=false;
				}
				if(point>=0){                                                            //condition for checking the last attachment
				palin = inter_prev[point].concat(palin);
				}
				point--;
				if(point<-1){
					palin="";
					break;
				}
			}
				point = token_prev.size()-1;
				palin="";
				count++;
			}
			}
			//========================================================================================  normal execution model start
			palin="";
			count=poll+1;
			palinkeycheck = false;
			
			if(breakflag==false){
			while(count<token.size()){
				for(x=count;x>=0;x--){
					palin = inter[x].concat(palin);
					if(palin.length()>30){
						break;
					}
					palincheck = palindromecheck(palin);
					if(palincheck == true){
						palindrome = recordpalin(palin,x,count, palindrome, token);
					}
				}
				count++;
				palin="";
			}
			}
			breakflag=false;
			return(palindrome);
			
			
		}
	
		public static Hashtable<String,Integer> recordpalin(String palin, int palinstart, int palinend, Hashtable<String,Integer> palindrome, List<String> token){
				
				String palinkey = new String();
				boolean first=false;
				boolean palinkeycheck=false;
				for(int z=palinstart;z<=palinend;z++){
					if(first==false){
						palinkey = palinkey.concat(token.get(z));
						first=true;
					}
					else
						palinkey = palinkey.concat(" ").concat(token.get(z));
				}
				first=false;
				palinkeycheck =  palindrome.containsKey(palinkey);
				if(palinkeycheck==false){
					palindrome.put(palinkey, 1);
				}
				else{
					palindrome.put(palinkey, (palindrome.get(palinkey)+1));
				}
				palinkey = "";
				return palindrome;
			
	
		}
		public static void printpalindrome(Hashtable<String,Integer> palindrome){
			ArrayList<Map.Entry<String, Integer>> palinsort = new ArrayList(palindrome.entrySet());
			Collections.sort(palinsort, new Comparator<Map.Entry<String, Integer>>(){
	    	 
	         public int compare(Map.Entry<String, Integer> palinentry1, Map.Entry<String, Integer> palinentry2) {
	            return palinentry2.getValue().compareTo(palinentry1.getValue());
	         	}
				}
			);
			System.out.println(palinsort);
		
		}

		public static boolean palindromecheck(String palin){
			int i=0,mid;
			boolean flag=false;
			i = palin.length();
				mid = i/2;
				flag=true;
				for(int k=0;k<mid;k++){
					if(palin.charAt(k)!=palin.charAt(palin.length()-k-1)){
						flag = false;
						return(flag);
					}
				}
				return(flag);
		}


	}