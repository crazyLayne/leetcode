package TempTest26_50;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String args[]){
		
	}
	
	public static int[] solution(int[] nums){
		if (nums.length == 0) return nums;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return nums;
	}

}
