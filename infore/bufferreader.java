package inforetrieve;

import java.util.*;
import java.util.ArrayList;

public class bufferreader {
	
	
	public static List<String> tokenise(String current){
		boolean temp=false;
		List<String> token = new ArrayList<String>();
		int siz=0,count=0,j=0,i=0;
		String[] current1;
		
		current = current.replaceAll("[^A-Za-z0-9]"," ");
		current =current.toLowerCase();
		temp = current.contains(" ");
		if(temp == true){
			current1 = current.split(" "); 
			siz = current1.length;
			j=0;
			while(j<siz-count){
				if(current1[j].length()<1){
					count++;
					for(int h=j;h<siz-count;h++){
					current1[h]=current1[h+1];
					}
				}
				else{
				j++;
				}
			}
			j=0;
			siz = current1.length;
			while(j<siz-count){
				
				token.add(i, current1[j]);
				i++;j++;
			}
			//i++;
			temp=false;
		}
		else{
		token.add(i, current);
		//System.out.println(temp);
		i++;
		}
		return(token);
		}
}
