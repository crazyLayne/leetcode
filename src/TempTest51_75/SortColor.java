package TempTest51_75;

public class SortColor {
	public static void main(String args[]){
		int[] nums={1,0};
		sortColor(nums);
	}
	public static void sortColor(int[] nums){
		int L0,R0,L1,R1,L2,R2;
        int i=0;
        int j=nums.length-1;
        L0=L1=L2=-1;
        R0=R1=R2=j+1;
        while(i<j){
            if(nums[i]==1){
                L1=i;
            }else if(nums[i]==0){
                L0=i;
            }else{
                L2=i;
            }
            i++;
            if(L0>=0&&L1>=0&&L1<L0)swip(nums,L1,L0);
            if(nums[j]==1){
                R1=j;
            }else if(nums[j]==0){
                R0=j;
            }else{
                R2=j;
            }
            j--;
            if(R2<nums.length&&R1<nums.length&&R2<R1)swip(nums,R2,R1);
            if(L2>=0&&R0<nums.length&&L2<R0)swip(nums,L2,R0);
	        }
	    }
	    public static void swip(int[] nums, int a, int b){
	        int temp=nums[a];
	        nums[a]=nums[b];
	        nums[b]=temp;
	    }

}
