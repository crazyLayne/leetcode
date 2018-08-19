package TempTest201_225;

public class HouseRobberII {
	public static void main(String args[]){
		int[] nums={1,2,3,4,5,1,2,3,4,5};
		rob(nums);
	}
	public static int rob(int[] nums){
		int len=nums.length;
        if(len==0)return 0;
        if(len==1)return nums[0];
        if(len==2)return Math.max(nums[0],nums[1]);
        int[] dp1=new int[len]; //包含第一个，不含最后一个[0:len-2]
        int[] dp2=new int[len]; //包含最后一个，不含第一个[1:len-1]
        dp1[0]=nums[0];
        dp1[1]=Math.max(nums[0],nums[1]);
        dp2[1]=nums[1];
        dp2[2]=Math.max(nums[1],nums[2]);
        for(int i=3;i<len;i++){
            dp1[i-1]=Math.max(dp1[i-2],dp1[i-3]+nums[i-1]);
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        return Math.max(dp1[len-2],dp2[len-1]);
	}

}
