package TempTest176_200;

public class RotateArray {
	public static void main(String args[]){
		int[] nums={1,2,3,4,5,6};
		rotate2(nums,2);
		for(int i:nums)
			System.out.print(i+"\t");
	}

	public static void rotate(int[] nums, int k){
		 int n=nums.length;
	        if(k==0 || k%n==0)return;
			int count=0;
			int index1=0;
			int num1=nums[index1];
			int index2;
			int num2;
	        int firstIndex=index1;
			while(count<n){
				index2 = (index1+k)%n;
				num2=nums[index2];
				nums[index2]=num1;
	            count++;
	            for(int num:nums){
	            	System.out.print(num+"\t");
	            }
	            System.out.println();
	            if(index2==firstIndex){
	                index1=index2+1;
	                firstIndex=index1;
	                num1=nums[index1];
	                continue;
	            }
				num1=num2;
				index1=index2;
			}
	}

	//使用三次reverse数组
	public static void rotate2(int[] nums, int k){
		int len = nums.length;
		k=k%len;
		if(k==0)return ;
		reverse(nums, 0, len-k-1);
		reverse(nums, len-k, len-1);
		reverse(nums, 0, len-1);
	}
	public static void reverse(int[] nums, int L, int R){
		int temp;
		while(L<R){
			temp=nums[L];
			nums[L]=nums[R];
			nums[R]=temp;
			L++;
			R--;
		}
	}
}
