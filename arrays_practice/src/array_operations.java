// Demonstrates the use of arrays, operators, and control flow
public class array_operations {

	public static void main(String[] args) {
		int[] nums = new int[10];
		
		// For loop iterating through each element in the array and performing operations on them.
		for(int i = 0; i < nums.length; i++) {
				nums[i] =i;
				
				if(i > 0) {
					nums[i] = nums[i] + nums[i-1];
				}
				
				System.out.println("Iteration "+(i+1)+" : "+nums[i]);
		}
	}

}
