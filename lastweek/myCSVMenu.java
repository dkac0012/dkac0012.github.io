package javatest;

import java.io.*;
import java.util.*;

public class myCSVMenu {

	public static void main(String[] args) {
		int menu;
		boolean check = true;
		float[][] indat = new float[10][3];
		
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("-----메뉴------");
			System.out.println("1. 읽기");
			System.out.println("2. 쓰기/종료");
			System.out.println("메뉴선택>>");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("읽기");
				try {
					File csv = new File("C:\\Users\\PC-01\\Desktop\\1.csv");
					BufferedReader br = new BufferedReader(new FileReader(csv));
					String line = null;
					int row=0;
					do {
						line = br.readLine();
						if(line!=null) {
							String[] token = line.split(",",-1);
							for(int i=0; i<3; i++)indat[row][i] =Float.parseFloat(token[i]);
							for(int i=0; i<3; i++)System.out.print(indat[row][i]+",");
							System.out.println("");
							row++;
						}
					}while(line!=null);
					br.close();
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				check =false;
				FileOutputStream out = null;
				try {
					out = new FileOutputStream("C:\\Users\\PC-01\\Desktop\\2.csv");
					for(int i= 0; i<10; i++) {
						for(int j=0; j<3; j++) {
							out.write(Float.toString(indat[i][j]).getBytes("utf-8"));
							out.write(",".getBytes("utf-8"));
						}
						out.write("\n".getBytes("utf-8"));
					}
					out.close();
					System.out.println("쓰기하고 종료합니다");
					check = false;
					break;
				}catch(FileNotFoundException e) {
					System.out.println(e.getMessage());
				}catch(IOException e) {
						System.out.println(e.getMessage());
			}finally {
				try {out.close();} catch(IOException e) {}
			}
			default:
				System.out.println("잘못된 입력함");
		}
	}while(check);
	scan.close();
}
}
