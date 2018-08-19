package TempTest26_50;

public class SearchForARange {
	public static void main(String args[]){
		
		int[] nums = {5,7,7,8,8,10};
//		int mid = HalfSearch(nums,8,0,nums.length-1);
		solution(nums,8);
	}
	public static int[] solution(int[] nums, int target){
		int left=-1,right=-1;
//		int mid = HalfSearch(nums,target,0,nums.length-1);
		int st = 0, ed = nums.length-1,mid=-1;			//非递归二分查找
		int temp;
		while(st<=ed){
			temp=(st+ed)/2;
			if(nums[temp]==target){
				mid=temp;
				break;
			}else if(nums[temp]>target){
				ed=temp-1;
			}else{
				st=temp+1;
			}
		}
		if( mid!=-1){						//存在
			left=mid;
			right=mid;
			while(left-1>=0 && nums[left-1]==target)
				left--;
			while(right+1<nums.length && nums[right+1]==target)
				right++;
		}
		int [] range = {left,right};
		return range;
	}
	public static int HalfSearch(int[] nums, int target, int left, int right){
		if(left<=right){
			int mid = (left+right)/2;
			if(nums[mid]==target)
				return mid;
			else if(nums[mid]>target){
				return HalfSearch(nums,target,mid+1,right);
			}else{
				return HalfSearch(nums,target,left,mid-1);
			}
		}
		return -1;
	}

	
	
}
