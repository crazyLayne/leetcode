package TempTest176_200;

public class HouseRobber {
	public static void main(String args){
		
	}
	
	public static int rob(int[] nums){
		int len=nums.length;
        if(len==0)return 0;
        int[] dp=new int[len];
        for(int i=0;i<len;i++){
            if(i==0)dp[i]=nums[0];
            else if(i==1)dp[i]=Math.max(nums[0],nums[1]);
            else dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[len-1];
	}

}
