package TempTest1_25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
	public static void main(String args[]){
		
	}
	public static List<List<Integer>> solution(int[] nums){
		List<List<Integer>> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++)
			map.put(i, nums[i]);
		for(int i=0;i<nums.length-1;i++)
			for(int j=i+1;j<nums.length;j++){
				if(map.containsValue(-nums[i]-nums[j]) && i!=map.get(-nums[i]-nums[j]) && j!=map.get(-nums[i]-nums[j])){//²»ÖØ¸´
					List<Integer> an = new ArrayList<>();
					an.add(nums[i]);
					an.add(nums[j]);
					an.add(-nums[i]-nums[j]);
					ans.add( an );
					break;
				}
			}
		return ans;
	}

}
