package week1;

import java.util.Scanner;

public class Inputter {

	public static void main(String[] args) {
		System.out.println("Insert your argument: ");
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		System.out.println("Insert another argument: ");
		Scanner r = new Scanner(System.in);
		String b = r.nextLine();
		System.out.println("Insert your final argument: ");
		Scanner t = new Scanner(System.in);
		String c = t.nextLine();
		System.out.println("Your arguments are: " + a + ", " + b + ", " + c);
	}

}
