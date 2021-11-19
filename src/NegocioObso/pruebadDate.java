package NegocioObso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class pruebadDate {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	      Scanner sc = new Scanner(System.in);

	      System.out.println("Eample: 25/12/2103");
	      System.out.print("Enter date: ");
	      String str = sc.nextLine();
	      
	      try {
	         Date date = sdf.parse(str); 	 
	         sdf = new SimpleDateFormat("EEEE, d MMMM yyyy");
	         System.out.println("Date: " + sdf.format(date));
			 
	      } catch (ParseException e) { 
	         System.out.println("Parse Exception");
	      }
	}
}