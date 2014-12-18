package com.ledlogic.spacetrivia.util;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class QuizCsvGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// setup
		String inFileName = "./util/data/ep-terminology.txt";
		
		// load lines
		File file = new File(inFileName);
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(file, "UTF-8");
		} catch (Exception e) {
			return;
		}
		
		// aggregate lines
		for (int i=lines.size()-1;i>=0;i--) {
			String line = lines.get(i);
			if (!line.startsWith("n ")) {
				lines.remove(i);
				lines.add(i, lines.get(i-1) + line);
				lines.remove(i-1);
			}
		}
		
		// output
		for (int i=0;i<lines.size();i++) {
			System.out.print(lines.get(i));
		}
	}

}
