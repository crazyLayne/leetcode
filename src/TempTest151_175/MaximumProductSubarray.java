package TempTest151_175;

public class MaximumProductSubarray {
	public static void main(String args[]){
		int[] nums={-1,1,2,1,-1,1,-1,2,-1,-1};
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i] + "   ");			
		}
		System.out.println();
		int p=proc(nums);
		for(int i=0;i<p;i++){
			System.out.print(nums[i] + "   ");			
		}
	}
	public static int maxproduct(int[] nums){
		int len=nums.length;
		if(len==0)return 0;
		if(len==1)return nums[0];
		len = proc(nums);
		int [][] products=new int[len+1][len+1];
		int maxProduct=Integer.MIN_VALUE;
		for(int i=1;i<=len;i++){
			for(int j=i;j<=len;j++){
				if(i==j){
					products[i][j]=nums[i-1];
					if(products[i][j]>maxProduct)maxProduct=products[i][j];
				}else{
					products[i][j]=products[i][j-1]*nums[j-1];
					if(products[i][j]>maxProduct)maxProduct=products[i][j];
				}
			}
		}
		return maxProduct;
	}
	//去除重复的1，或者相邻的-1，返回新数组长度
	public static int proc(int[] nums){
		int p=0;
        boolean flag=false;
		for(int i=0;i<nums.length;i++){
            if(flag && nums[i]==1)continue;
            if(!flag && nums[i]>1)flag=true;
			if(nums[i]==-1 && i<nums.length-2 && nums[i+1]==-1){
				i+=2;
			}
			nums[p++]=nums[i];
		}
		return p;
	}
	public static int solution(int [] nums){
		int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        
        max[0] = nums[0];
        min[0] = nums[0];
        
        for (int i = 1; i < max.length; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i-1]*nums[i], min[i-1]*nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i-1]*nums[i], min[i-1]*nums[i]));
        }
        
        int res = nums[0];
        
        for (int i = 0; i < max.length; i++) {
            res = Math.max(res, max[i]);
        }
        
        return res;
	}
	

}

