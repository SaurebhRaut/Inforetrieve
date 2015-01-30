package inforetrieve;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Part_A_final {

	public static void main(String[] args) throws IOException {
		System.out.println("Please enter the file path");
		List<String> tokencoll =new ArrayList<String>();
		String path;
		Scanner input = new Scanner(System.in);
		path = input.nextLine();
		System.out.println("Tokens present are follows: ");
		tokencoll = tokenisefile(path);											//function return token collection
		print(tokencoll);														//function printing the token collection
		System.out.println("");
		System.out.println("Total number of alphanumeric tokens present in the file are:  " + tokencoll.size());
	}
	
	public static List<String> tokenisefile(String path) throws IOException{
	
		File file = new File(path);
		BufferedReader currline = new BufferedReader(new FileReader(file));
		List<String> token = new ArrayList<String>();
		List<String> tokencoll =new ArrayList<String>();
		String currstring;
		int length=0;
		
		while((currstring = currline.readLine())!=null){
			if(currstring.length()!=0){
				token = bufferreader.tokenise(currstring);				//tokenise function of class bufferreader giving the tockens of a line
				for(int i=0;i<token.size();i++){
					tokencoll.add(token.get(i));
		//			tokenscount++;
				}
			}
		}
		return(tokencoll);
	}
	
	public static void print(List<String> tokencoll){
		for(int i=0;i<tokencoll.size();i++){
			System.out.print(tokencoll.get(i)+"," + " ");
		}
	}
}
		
	