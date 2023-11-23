package org.javaro.lecture;

public class MyStore {

	public static void main(String[] args) {
		BookStore testLibrary = new BookStore("도서관리 시스템");
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		Book b4 = new Book();
		b1.setIsbn("9788954649001");
		b2.setIsbn("9788954649002");
		b3.setIsbn("9788954649003");
		b4.setIsbn("9788954649004");
		b1.setTitle("전쟁과평화");
		b2.setTitle("진화론");
		b3.setTitle("춘향전");
		b4.setTitle("홍길동전");
		b1.setAuthor("톨스토이");
		b2.setAuthor("다윈");
		b3.setAuthor("미상");
		b4.setAuthor("허균");
		Student stud1 = new Student();
		Student stud2 = new Student();
		stud1.setStudNumber("202X1001");
		stud2.setStudNumber("202X1002");
		stud1.setName("홍길동");
		stud2.setName("성춘향");
		stud1.setMaxBooks(2);
		stud2.setMaxBooks(3);
		testLibrary.addBook(b1);
		testLibrary.addBook(b2);
		testLibrary.addBook(b3);
		testLibrary.addBook(b4);
		testLibrary.addStudent(stud1);
		testLibrary.addStudent(stud2);
		System.out.println("도서관리 시스템 설정");
		testLibrary.printStatus();
		testLibrary.checkOut(b1, stud2);
		testLibrary.printStatus();
		testLibrary.checkOut(b2, stud2);
		testLibrary.printStatus();
		testLibrary.checkOut(b3, stud2);
		testLibrary.printStatus();
		testLibrary.checkOut(b4, stud2);
		testLibrary.printStatus();
		testLibrary.checkIn(b1);
		testLibrary.checkOut(b2, stud1);
		testLibrary.printStatus();
	}

}
