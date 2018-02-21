package week1;

public class Random25 {
	public static void main(String[] args) {
		
		int[] generatedNumber = new int[25];
		int[] secondRand = new int[25];
		
		for (int i = 0; i < 26; i++) {
			
			
            generatedNumber[i] = (int) (Math.random() *10);
            secondRand [i] = (int) (Math.random() * 10);
           
            System.out.println("Generating number " + (i+1) + ": " + generatedNumber[i]);
            System.out.println("Random comparison number: " + secondRand[i]);
            if(generatedNumber[i] > secondRand[i])
            {
            		System.out.println("First number is greater than other random number.");
            }
            
            else if(generatedNumber[i] < secondRand[i])
            {
            		System.out.println("First number is less than other random number.");
            }
            else
            {
            		System.out.println("Random numbers are equal");
            }
		}    
		
	}
}



	
