package fb;

public class FizzBuzz {

	public static void main(String[] args) {

		fizzbuzz(1, 100, 7, 14);

	}
	
	public static void fizzbuzz(int start, int end, int fizz, int buzz){
		// cycle through all numbers from 1 to 100
		for(int i = start; i <= end; i++) {
			// Number is divisible by 3 and divisible by 5
			if((i % fizz == 0) && (i % buzz == 0 )) {
				System.out.println("FizzBuzz");
			}
			//Number is divisible only by fizz
			else if(i % fizz == 0) {
				System.out.println("Fizz");
			}
			//  Number is divisible only by buzz
			else if(i % buzz == 0) {
				System.out.println("Buzz");
			}
			// not any of the above
			else {
				System.out.println(i);
			}
		}
	}

}
