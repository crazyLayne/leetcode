package TempTest26_50;

public class JumpGameII {
	public static void main(String args[]){
		int[] nums={2,3,1,1,4};
		System.out.println(jump(nums));
	}
	public static int jump(int[] nums) {
		if(nums.length==0 || nums.length==1)return 0;
        int i=0;            //当前位置
        int ip=0;           //上次比较的结束位置
        int count=1;
        int maxi;
        while(i+nums[i]<nums.length-1){       //没越界
            maxi=i;             //下一步最远跳跃距离,处置设为起点
            for(int j=ip;j<=i+nums[i];j++){
                if(j+nums[j]>maxi+nums[maxi]){
                    maxi=j;
                }
            }
            if(i==maxi)return 0;        //最远就是i，则跳不到终点
            ip=i+nums[i];
            i=maxi;
            count++; 
        }
        return count;
    }

}
