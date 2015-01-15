package letor_parser;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class precision {

	public static void main(String args[]) throws Exception{
		FileReader in = new FileReader("C:\\Users\\sidd__000\\workspace\\letor_parser\\data.txt");
		BufferedReader br = new BufferedReader(in);
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		while(line!=null){
			sb.append(line);
			sb.append("\n");
			line = br.readLine();
		}
		
		String text = sb.toString();
		String parsedText=multiply(text);
		
		Writer wr = new BufferedWriter(new FileWriter("newData.txt"));
		wr.write(parsedText);
		wr.close();
		
		
	}
	public static String multiply(String text){
		Pattern pattern = Pattern.compile("(\\.)(\\d\\d)(\\d\\d\\d\\d)");
		Matcher matcher = pattern.matcher(text);
		if(matcher.find()){
			text = matcher.replaceFirst(matcher.group(2)+"\\."+matcher.group(3));
			matcher = pattern.matcher(text);
			while(matcher.find()){
				text = matcher.replaceFirst(matcher.group(2)+"\\."+matcher.group(3));
				matcher = pattern.matcher(text);
			}
		}
		return text;
	}
}
