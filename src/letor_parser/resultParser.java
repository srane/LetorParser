package letor_parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class resultParser {
	
	public static void main(String args[]) throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader("C:\\study\\IR\\project 2\\result2.txt"));
		StringBuilder sb = new StringBuilder();
		String line = bf.readLine();
		
		while(line!=null){
			sb.append(line);
			sb.append("\n");
			line = bf.readLine();
		}
		
		String text = sb.toString();
		text = Rparser(text);
		
		Writer wr= new BufferedWriter(new FileWriter("result2.txt"));
		wr.write(text);
		wr.close();
	}
	
	static String Rparser(String text){
		Pattern pattern = Pattern.compile("iprec_at_recall_");
		Matcher matcher = pattern.matcher(text);
		if(matcher.find()){
			text = matcher.replaceAll("");
		}
		pattern = Pattern.compile("all");
		matcher = pattern.matcher(text);
		if( matcher.find()){
			text = matcher.replaceAll(""); 
		}
		//pattern = Pattern.compile("(#docid)(.*?)\n");
		//matcher = pattern.matcher(text);
		//text = matcher.replaceAll("\n");
	
		
		
		
		
		return text;
	}

		
	}


