import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
 
public class IDKSeinRelated {

	public static void main(String[] args) {
		
		ArrayList<String> quotesList = new ArrayList<String>();
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(new FileReader(new File("sein.txt")));
			
			while(fileScan.hasNext()) {
				String quote = fileScan.nextLine();
				quotesList.add(quote);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			if(fileScan!=null)
				fileScan.close();
		}
		
		System.out.println(quotesList.toString());
		Random generator = new Random();
		int i = 0;
		while(i < quotesList.size()) {
			int rand = generator.nextInt(quotesList.size());
			System.out.println(quotesList.get(rand));
			i++;
		}
		
		
		
		
	}

}
