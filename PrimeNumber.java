package week1.day1;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 10;
		boolean isPrime = true ;
		for(int i = 2; i<=num-1;i++) {
			if(num%i==0) {
				isPrime = false;
			}
		}
		
		if(isPrime) {
			System.out.println("The given number is prime number");
		}
			else {
				
				System.out.println("The given number is non prime number");
		}
	}
	

}
