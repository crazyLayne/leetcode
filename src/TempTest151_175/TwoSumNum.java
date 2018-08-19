package TempTest151_175;

public class TwoSumNum {
	public static void main(String args[]){
		
	}
	public int[] twoSum(int[] numbers, int target){
		int p=0;
		int q=numbers.length;	//find the first smaller than target
		int[] res = new int[2];
		while(p<q){
			if(p+q==target){
				res[0]=p;
				res[1]=q;
				return res;
			}else if(p+q>target)q--;
			else p++;
		}
		return res;
	}

}
