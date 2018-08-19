package TempTest51_75;

public class MaximumSubarray {
	public static void main(String args[]){
		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		int max=solution2(nums);
		System.out.println(max);
	}
	public int solution(int[] nums){
		int sum;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){		//从第i个开始求和
			sum=0;
			for(int j=i;j<nums.length;j++){
				sum+=nums[j];
				max=sum>max?sum:max;
			}
		}
		return max;
	}
	
	public static int solution2(int[] nums){
		int l,r,p,q;
		l=p=0;
		r=q=nums.length;
		int lsum,rsum;
		while(l<r){
			lsum=0;
			while(l<q){
				lsum+=nums[l];
				if(lsum<=0){
					p=l+1;
				}
				l++;
			}
			rsum=0;
			while(p<r){
				rsum+=nums[r];
				if(rsum<=0){
					q=r-1;
				}
				r--;
			}
		}
		lsum=0;
		for(int i=p;i<=q;i++)
			lsum+=nums[i];
		return lsum;
	}

}
