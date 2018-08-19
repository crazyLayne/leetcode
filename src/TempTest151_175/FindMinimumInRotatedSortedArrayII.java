package TempTest151_175;

public class FindMinimumInRotatedSortedArrayII {
	public static void main(String args[]){
		int[] nums={3,3,3,3,3,3,1,3};
//		int[] nums={0,1};
		System.out.print(findMin(nums));
	}
	
	//分治
	public static int findMin2(int[] nums){
		int len=nums.length;
        if(len==1)return nums[0];
        return helper(nums,0,len-1);
	}
	public static int helper(int[] nums,int l,int r){
		if(l==r)return nums[l];
		int mid=(l+r)/2;
		return Math.min(helper(nums,l,mid), helper(nums,mid+1,r));
	}
	
	//二分
	public static int findMin(int[] nums){
		int i,j,mid;
		 i=0;
		 j=nums.length-1;
		 int min=nums[0];
		 if(nums.length==1)return min;
		 else while(i<=j){
			 mid=(i+j)/2;
			 min=Math.min(nums[mid], min);
			 if(nums[mid]>nums[i]){		//左侧有序
				 min=Math.min(nums[i], min);
				 i=mid+1;
			 }else if(nums[mid]<nums[i]){		//右侧有序
				 min=Math.min(nums[mid], min);
				 j=mid-1;
			 }else{
				 i++;
			 }
		 }
		 return min;
	}
}
