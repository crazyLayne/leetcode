package TempTest26_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations2 {
	public static void main(String args[]){
		
	}
	public static  List<List<Integer>> permute(int[] nums){
		List<List<Integer>> ans = new ArrayList<>();
        List<Integer> an = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int lens=0;								//unique number;
        for(int i=0;i<nums.length;i++){
        	if(map.containsKey(nums[i])){
        		map.put(nums[i], map.get(nums[i])+1);
        	}else{
        		map.put(nums[i], 1);
        		nums[lens++]=nums[i];
        	}
        }
        int[]  states = new int[nums.length];
        for(int i=0;i<lens;i++){
        	states[i]=map.get(nums[i]);
        }
        solution(ans,an,nums,states,nums.length,lens);
        return ans;
	}
	public static void solution(List<List<Integer>> ans,List<Integer> an,int[] nums,int[] states,int len,int lens){
		if(len==0){
			ans.add(an);
		}
		for(int i=0;i<lens;i++){
			if(states[i]!=0){
				List<Integer> ann = (List<Integer>) ((ArrayList) an).clone();
				ann.add(nums[i]);
				states[i]--;
				solution(ans,ann,nums,states,len-1,lens);
				states[i]++;
			}
		}
	}

}
