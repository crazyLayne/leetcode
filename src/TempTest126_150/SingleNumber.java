package TempTest126_150;

//import java.util.HashMap;
import java.util.Hashtable;

public class SingleNumber {
	public static void main(String args){
		
	}
	public static int singleNumber1(int[] nums){
		Hashtable<Integer,Character> t=new Hashtable<>();
		int temp;
		for(int i=0;i<nums.length;i++){
			temp=nums[i];
			if(t.containsKey(temp)){
				t.remove(temp);
			}else{
				t.put(temp, null);
			}
		}
		return (int) t.keySet().toArray()[0];
	}
	public static int singleNumber(int[] nums){
		int res=0;
		for(int i=0;i<nums.length;i++){
			res^=nums[i];
		}
		return res;
	}

}
