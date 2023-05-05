package week1.day1;

public class FibbinocciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 11;
		int first_Num = 0 , second_Num = 1 , sum ;
		System.out.println("The Fibbinocci series is : ");
		System.out.println(first_Num);
		System.out.println(second_Num);
		for(int i = 0 ; i<=num; i++) {
			
			sum = first_Num + second_Num;
			if(sum>=56) {
				break;
			}
			System.out.println(sum);
			first_Num = second_Num;
			second_Num = sum;

		}

	}

}
