
public class Main {

	public static void main(String[] args) {
		int[] nums = {3, 5, 7};
		int max = 10;
		System.out.println(sumOfMultiples(nums, max));
	}
	
	public static int sumOfMultiples(int[] nums, int max){
		int sum = 0;
		for(int n = 0; n<nums.length; n++) {

			for(int i = 0; nums[n]*i<max; i++) {
				sum = sum + nums[n]*(i);
			}
		}
			
		return sum;
	}	
}
