
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner{
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Book> list = null;
		String name, theme, summary;
		int answer, page;
		
		//goes to save file and makes all book objs through save file.
		try {
			list = abBook.Start();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		System.out.println("1. Started new book\n2. Finished Book\nEnter:");
		answer = scan.nextInt();
		
		if(answer == 1) { //new book //Test if adds to array right.
			Book temp;
			name = scan.nextLine();
			System.out.println("Name:");
			name = scan.nextLine();
			System.out.println("Theme:");
			theme = scan.nextLine();
			System.out.println("Page num");
			page = scan.nextInt();
			summary = "\n";
			temp = new Book(name, theme, page, summary);
			list.add(temp);
			
		}
		else if(answer == 2){//finished book
			name = scan.nextLine();
			System.out.println("what book? by Title");
			name = scan.nextLine();
			System.out.println("write a  summary:");
			summary = scan.nextLine();
			
			for (Book book : list) {
				if (book.getName().equals(name)) {
					book.addSummary(summary);
				}
			}
		}
		
//		System.out.println(list.size());
//		for (Book book : list) {
//			System.out.println();
//		}
		scan.close();
		Book.finish(list);
	}

}
