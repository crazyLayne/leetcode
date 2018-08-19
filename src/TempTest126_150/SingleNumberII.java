package TempTest126_150;

import java.util.Hashtable;

public class SingleNumberII {
	public static void main(String args[]){

//		int[] nums={-2,-2,1,1,-3,1,-3,-3,-4,-2};
//		System.out.print(singleNumber(nums));
		int n=100;
		int m=-n;
		int c=n&-n;
		for(int i=0;i<32;i++){
			System.out.print((n>>i&1)+"  ");
		}
		System.out.println();
		for(int i=0;i<32;i++){
			System.out.print((m>>i&1)+"  ");
		}
		System.out.println();
		for(int i=0;i<32;i++){
			System.out.print((c>>i&1)+"  ");
		}
	}
	// Hashtable
	public static int singleNumber1(int[] nums){
		Hashtable<Integer,Integer> t=new Hashtable<>();
		int temp;
		for(int i=0;i<nums.length;i++){
			temp=nums[i];
			if(t.containsKey(temp)){
				if(t.get(temp)==1)t.put(temp, 2);
				else t.remove(temp);
			}else{
				t.put(temp, 1);
			}
		}
		return (int) t.keySet().toArray()[0];
	}
	//位运算，用32大小数组统计二进制数每一位出现的次数，最后对3取余
	public static int singleNumber(int[] nums){
		
		int res = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int j = 0; j < nums.length; ++j) {
            	int temp=nums[j] >> i;
                sum += (temp) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
	}
	

}

