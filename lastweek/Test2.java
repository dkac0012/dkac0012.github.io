package javatest;

import java.io.*;

public class Test2 {
	public static void main(String[] args) {
	float[][] indat = new float[10][3];
	try {
		File csv = new File("C:\\Users\\PC-01\\Desktop\\1.csv");
		BufferedReader br = new BufferedReader(new FileReader(csv));
		String line = null;
		int row = 0;
		do {
			line = br.readLine();
			if(line!=null) {
				String[] token = line.split(",",-1);
				for(int i=0; i<3; i++) indat[row][i] = Float.parseFloat(token[i]);
				for(int i=0; i<3; i++) System.out.print(indat[row][i]+",");
				System.out.println("");
				row++;
			}
		} while(line != null);
		br.close();
		FileOutputStream out = new FileOutputStream("C:\\Users\\PC-01\\Desktop\\1.csv");
		for(int i=0; i<10; i++) {
			for(int j=0; j<3; j++) {
				out.write(Float.toString(indat[i][j]).getBytes("utf-8"));
				out.write(",".getBytes("utf-8"));
			}
			out.write(",".getBytes("utf-8"));
		}
		out.close();
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch(IOException e) {
		e.printStackTrace();
	}
}
}
