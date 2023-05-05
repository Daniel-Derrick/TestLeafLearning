package week1.day1;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test = "Change";
		String change = new String();
		
		char[] arr = test.toCharArray();
		
		int length = arr.length;
		
		for(int i = 0 ; i <= length-1 ; i++) {
			
			if(i%2==0) {
				change = change+String.valueOf(arr[i]);

			}
			else if(i%2!=0)
			change = change+String.valueOf(arr[i]).toUpperCase();
		}
		
		System.out.println(change);
	}

}
