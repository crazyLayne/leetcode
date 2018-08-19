package TempTest201_225;

public class MinimumSizeSubarraySum {
	public static void main(String args[]){
		
	}
	//双指针法，前后两个指针遍历O(n)
	public int minSubArrayLen(int s, int[] nums){
		int n=nums.length;
        int left,right;
        left=right=0;
        int sum=0;
        int minLen=n;
        boolean flag=false;
        while(right<n){
            sum+=nums[right];		//右指针先去找到满足条件的区间
            if(sum>=s){
                flag=true;
                while(left<=right && sum>=s){	//左指针去缩小这个区间，直到不满足条件
                    sum-=nums[left++];
                }
                minLen=Math.min(minLen,right-left+2);	//比较最小区间
            }
            right++;
        }
        if(!flag)return 0;
        return minLen;
	}

	//二分查找，O(nlogn)
//	public int minSubArrayLen2(int s, int[] nums){
//
//	}
}
