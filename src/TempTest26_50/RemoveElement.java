package TempTest26_50;

public class RemoveElement {
	public static void main(String args[]){
		
	}
	public static int solution(int[] nums, int val ){
		int j=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=val){
				nums[j]=nums[i];
				j++;
			}
		}
		return j+1;
	}

}
