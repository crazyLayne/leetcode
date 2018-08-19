package TempTest151_175;

public class MajorityElement {
	public static void main(String args[]){
		
	}
	
	public int majorityElement(int[] nums){
		int majority=nums[0];
		int count=0;
		for(int num:nums){
			if(num==majority){
				count++;
			}else{
				count--;
			}
			if(count<=0){
				majority=num;
				count=1;
			}
		}
		return majority;
	}

}
