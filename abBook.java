import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class abBook implements Cloneable{
	
	private String name, theme, summary;
	private int pageNum;
	private static File f;
	
	abBook(String name, String theme, int pageNum, String summary){
		this.name = name;
		this.theme = theme;
		this.summary = summary;
		this.pageNum = pageNum;
	}
	
	public static ArrayList<Book> Start() throws FileNotFoundException {
		//method for re-adding all the Obj books
		String s;
		int p = 0;
		String[] book = new String[4];
		f = new File("src/SaveFile.txt");
		Scanner fscan = new Scanner(f);
		
		int index = Integer.parseInt(fscan.nextLine());
		Book[] blist = new Book[index];
		
		for(int i = 0; i < index; i++) {
			s = fscan.nextLine();
			if(s.equals("Start")){
				for(int j = 0; j < 4; j++) {
					book[j] = fscan.nextLine();
				}
				
				Book b = new Book(book[0], book[1], Integer.parseInt(book[2]), book[3]);
				blist[p] = b;
				p++;
			}
		}
		fscan.close();
		
		ArrayList<Book> b = new ArrayList<>();
		
		for (Book book2 : blist) {
			b.add(book2);
		}
		return b;
	}
	
	public static void finish(ArrayList<Book> b) {
		FileWriter writer;
		try {
			writer = new FileWriter(f);
			writer.write(b.size() + "\n");
			for (Book book : b) {
				writer.write(book.toString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "Start\n" + name + "\n" + theme + "\n" + pageNum + "\n" + summary;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void addSummary(String summary2) {
		summary = summary2;
	}
	
}
