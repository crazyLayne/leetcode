package TempTest151_175;

public class FindMinimumInRotatedSortedArray {
	public static void main(String args[]){
		int[] nums={3,4,5,6,7,8,9,0,1,2};
		System.out.print(findMin(nums));
	}
	//二分查找
	public static int findMin(int[] nums){
		 int i,j,mid;
		 i=0;
		 j=nums.length-1;
		 if(nums.length==1 || nums[0]<nums[nums.length-1])return nums[0];
		 mid=(i+j)/2;
		 while(i<j){
			 if(nums[mid]>nums[mid+1])break;
			 if(nums[mid]>nums[j]){
				 i=mid;
			 }else{
				 j=mid;
			 }
			 mid=(i+j)/2;
		 }
		 return nums[mid+1];
	}

	//分治
	public static int finMin2(int[] nums){
		int len=nums.length;
        if(len==1)return nums[0];
        return helper(nums,0,len-1);
	}
	public static int helper(int[] nums,int l,int r){
		if(l==r)return nums[l];
		int mid=(l+r)/2;
		return Math.min(helper(nums,l,mid), helper(nums,mid+1,r));
	}

	
	
}
