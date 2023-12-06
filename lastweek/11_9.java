package javatest;
import java.util.Scanner;

public class Ex11_9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("개:1, 고양이:2 ?");
		int select = sc.nextInt();
		if(select==1) {
			System.out.println("개 선택");
		}else if(select==2) {
			System.out.println("고양이 선택");
		}
		sc.close();
	}
}
