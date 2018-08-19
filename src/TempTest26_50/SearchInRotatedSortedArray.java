package TempTest26_50;

public class SearchInRotatedSortedArray {
	public static void main(String args[]){
//		int [] nums={4,5,6,7,0,1,2};
		int [] nums={3,1};
		System.out.println(solution3(nums, 1));
	}
	//暴力查找
	public static int solution(int[] nums, int target){
		for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
                return i;
        }
        return -1;
	}
	//分支暴力查找
	public static int solution2(int[] nums, int target){
		int i;
		if(nums.length>0){
			if(nums[0]==target)return 0;
			else if(nums[0]<target){				//从前往后找
				i=0;
				while(i<nums.length-1 && nums[i]<nums[i+1]){	//保持增序
					if(nums[++i]==target)
						return i;
				}
			}else{									//从后往前找
				i=nums.length-1;
				if(nums[i]==target)return i;
				while(i>1 && nums[i]>nums[i-1]){		//保持递减
					if(nums[--i]==target)
						return i;
				}
			}
		}
		return -1;
	}
	// 二分查找
	public static int solution3(int[] nums, int target){
		int len=nums.length;
		int i=0;
		int j=len-1;
		int mid;
		if(len==0)return -1;
		
		while(i<=j){
			mid=(i+j)/2;
			if(nums[mid]==target)return mid;
			if(nums[mid]>=nums[i]){			//左半边有序
				if(target<nums[mid] && target>=nums[i]){
					j=mid-1;
				}else{
					i=mid+1;
				}
			}else{							//右半边有序
				if(target>nums[mid] && target<=nums[j]){
					i=mid+1;
				}else{
					j=mid-1;
				}
			}
			
		}
		return -1;
	}
}
