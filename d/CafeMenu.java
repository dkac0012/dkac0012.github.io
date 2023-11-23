package org.javaro.lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class CafeMenu {
	public static void main(String[] args) {
		CafeStore cafeStore = new CafeStore("스키");
		int menu;
		boolean check = true;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("----메뉴-----");
			System.out.println("1. 음료 주문");
			System.out.println("2. 알콜 주문");
			System.out.println("3. 영수증");
			System.out.println("4. 종료");
			System.out.println("메뉴선택 :");
			menu= scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("1. 음료 주문 선택함");
				System.out.println("음료 이름 입력:");
				String product = scan.next();
				System.out.println("가격 입력:");
				int price = scan.nextInt();
				System.out.println("갯수 입력:");
				int quantity = scan.nextInt();
				BeverageX beverage = new BeverageX(product,price,quantity);
				cafeStore.addBeverage(beverage);
				break;
			case 2:
				System.out.println("2. 알콜 주문 선택함");
				System.out.println("알콜 이름 입력:");
				product = scan.next();
				System.out.println("가격 입력:");
				price = scan.nextInt();
				System.out.println("갯수 입력:");
				quantity = scan.nextInt();
				System.out.println("알콜 도수 입력:");
				float alcohol = scan.nextFloat();
				Liquor liquor = new Liquor(product,price,quantity,alcohol);
				cafeStore.addLiquor(liquor);
				break;
			case 3:
				System.out.println("3 영수증 인쇄 선택함");
				cafeStore.printReceipt();
				break;
			case 4:
				System.out.println("4. 종료를 선택하였습니다.");
				check = false;
				break;
			default:
				System.out.println("잘못된 입력함. 새로 입력하세요");					
			} 
		}while(check);
		scan.close();
	}
}
class CafeStore{
	String storeName;
	ArrayList<BeverageX>beverages;
	ArrayList<Liquor>liquors;
	CafeStore(String storeName){
		this.storeName=storeName;
		beverages=new ArrayList<BeverageX>();
		liquors=new ArrayList<Liquor>();
	}
	public String getStoreName() {
		return this.storeName;
	}
	public ArrayList<BeverageX>getBeverages(){
		return this.beverages;
	}
	public ArrayList<Liquor>getLiquors(){
		return this.liquors;
	}
	public void addBeverage(BeverageX beverage) {
		this.beverages.add(beverage);
	}
	public void addLiquor(Liquor liquor) {
		this.liquors.add(liquor);
	}
	public void printReceipt() {
		System.out.println("---영수증---");
		int sum =0;
		if(this.getBeverages().isEmpty()==false) {
			System.out.println("제품명\t\t단가\t수량\t금액");
			for(BeverageX aBeverage :  this.getBeverages()) {
				sum = sum+aBeverage.price*aBeverage.quantity;
				System.out.println(aBeverage.product+"\t\t"+aBeverage.price+"\t"+aBeverage.quantity+"\t"+aBeverage.getTotal());
			}
		}
		if(this.getLiquors().isEmpty()==false) {
			System.out.println("제품명(알콜)\t단가\t수량\t금액");
			for(Liquor aLiquor:this.getLiquors()) {
				sum= sum+aLiquor.price*aLiquor.quantity;
				System.out.println(aLiquor.product+"\t\t"+aLiquor.price+"\t"+aLiquor.quantity+"\t"+aLiquor.getTotal());
			}
		}
		if(this.getBeverages().isEmpty()==false||this.getLiquors().isEmpty()==false) {
			System.out.println("총 영수금액="+sum);
		}
	}
}
class BeverageX{
	String product; int price; int quantity;
	public BeverageX(String product,int price, int quantity) {
		this.product=product;
		this.price=price; this.quantity=quantity;
	}
	public String getProduct() {
		return this.product;
	}
	public int getPrice() {
		return this.price;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public int getTotal() {
		return this.price*this.quantity;
	}
	void printTitle() {
		System.out.println("제품명\t\t단가\t수량\t금액");
	}
	void printData() {
		System.out.println(this.product+"\t"+this.price+"\t"+this.quantity+"\t"+this.getTotal());
	}
}
class Liquor extends BeverageX{
	float alcohol;
	public Liquor(String product,int price,int quantity, float alcohol) {
		super(product, price,quantity);
		this.alcohol=alcohol;
	}
	void printTitle() {
		
		System.out.println("제품명(알콜)\t단가\t수량\t금액");
	}
	void printData() {
		System.out.println(this.product+"("+this.alcohol+")\t"+this.price+"\t"+this.quantity+"\t"+this.getTotal());
	}
}