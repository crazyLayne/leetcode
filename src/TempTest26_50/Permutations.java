package TempTest26_50;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	public static void main(String args[]){
		
	}
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> an = new ArrayList<>();
        int[]  states = new int[nums.length];
        solution(ans,an,nums,states,nums.length);
        return ans;
    }
	public static void solution(List<List<Integer>> ans,List<Integer> an,int[] nums,int[] states,int len){
		if(len==0){
			ans.add(an);
		}
		for(int i=0;i<nums.length;i++){
			if(states[i]!=1){
				List<Integer> ann = (List<Integer>) ((ArrayList) an).clone();
				
				ann.add(nums[i]);
				states[i]=1;
				solution(ans,ann,nums,states,len-1);
				states[i]=0;
			}
		}
	}

}


