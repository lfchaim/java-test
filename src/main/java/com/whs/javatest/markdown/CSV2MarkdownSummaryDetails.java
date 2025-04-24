package com.whs.javatest.markdown;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSV2MarkdownSummaryDetails {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<String> allLines = Files.readAllLines(Paths.get("interview-questions.csv"));
		System.out.println("Linhas: "+allLines.size());
		
		List<String> lines = new ArrayList<String>();
		
		lines.add("# Job Interview  \n");
		
		for( int i = 1; i < allLines.size(); i++ ) {
			String[] lineSplit = allLines.get(i).split(";");
			StringBuilder sb = new StringBuilder();
			sb.append("<details>\n");
			sb.append("\t<summary>"+i+") "+lineSplit[0]+"</summary>\n");
			sb.append("\t"+lineSplit[1]+"\n");
			sb.append("</details>\n");
			
			lines.add(sb.toString());
		}
		
		Path path = Paths.get("interview-questions.md");
        
        Files.write(path, lines, StandardCharsets.UTF_8);
        System.out.println("Finished!");
	}

}
