package TempTest51_75;

public class JumpGame {
	public static void main(String args[]){
		int[] nums={3,2,1,0,4};
		System.out.println(solution2(nums));
	}
	public static boolean solution(int[] nums){
		if(nums.length<=1)return true;
		return solve(nums,0,nums.length);
	}
	public static boolean solve(int[] nums,int index,int len){
		if(index>=len-1 || index+nums[index]>=len-1)return true;
		else{
			for(int i=nums[index];i>=1;i--){
				if(solve(nums,index+i,len))return true;
			}
			return false;
		}
	}
	public static boolean solution2(int[] nums){
		if(nums.length<=1)return true;
        int p=nums.length-1;
        for(int i=p-1;i>=0;i--)
        	if(nums[i]>=p-i)
        		p=i;
        return p==0?true:false;
	}
}
