package TempTest26_50;

public class SearchInsertPosition {
	public static void main(String args[]){
		
	}
	public static int solution(int[] nums, int target){
		int i=0;
        for(;i<nums.length;i++){
            if(nums[i]>=target)
                break;
        }
        return i;
	}
	public static int solution2(int[] nums, int target){
		int L=0,R=nums.length-1;
		int mid;
		while(L<=R){
			mid=(L+R)/2;
			if(nums[mid]==target)
				return mid;
			else if(nums[mid]>target){
				R=mid-1;
			}else{
				L=mid+1;
			}
		}
		
		return L;
	}

}
