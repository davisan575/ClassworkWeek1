package week1;

public class HelloThere {
		public static void main(String[] args) {
			int x = 3;
			int y = 2;
			if (x + y < x * 2) {
				x = y + 42;
				if(y > 0) {
					x = 1;
				}
			}
			System.out.println("x is " + x);
		}

}
