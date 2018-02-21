package week1;

import java.util.Scanner;
	
	public class PrimeDetector {

		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			boolean check = false;
			while(true)
			{

			System.out.println("Please enter number to check: ");
			int input = s.nextInt();
			check = false;
			
			for(int i = 2; i < input; i++)
			{
				if(input % i == 0)
				{
					check = true;
				}
				else
				{
					//nothing happens
				}
			}
			
			
			if(check == true)
			{
			 System.out.println("Number is not prime");
			}
			
			else if(check == false)
			{
				System.out.println("Number is prime");
				
			}	
		
			}
			

	}

}
