package letor_parser;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class letorParser {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\sidd__000\\workspace\\letor_parser\\src\\letor_parser\\Querylevelnorm.txt"));
		StringBuilder sb = new StringBuilder();
		String line = bf.readLine();
		
		while(line!=null){
			sb.append(line);
			sb.append("\n");
			line = bf.readLine();
		}
		
		String text = sb.toString();
		text = Dparser(text);
		
		Writer wr= new BufferedWriter(new FileWriter("data.txt"));
		wr.write(text);
		wr.close();
	}
	
	static String Dparser(String text){
		Pattern pattern = Pattern.compile("qid\\:");
		Matcher matcher = pattern.matcher(text);
		if(matcher.find()){
			text = matcher.replaceAll("");
		}
		pattern = Pattern.compile("([0-9]+?)\\:");
		matcher = pattern.matcher(text);
		if( matcher.find()){
			text = matcher.replaceAll(""); 
		}
		pattern = Pattern.compile("(#docid)(.*?)\n");
		matcher = pattern.matcher(text);
		text = matcher.replaceAll("\n");
	
		
		
		
		
		return text;
	}

}
