package TempTest1_25;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//Two Sum
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//Example
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].



public class TwoSum {
	public static void main(String args[]){
		int [] nums = {5,11,15,2,6};
		int target = 8;
		int [] a = twoSum3(nums,target);
		System.out.println("a= "+a[0]+" "+a[1]);
	}
	
	public static int[] twoSum1(int[] nums, int target){
		int i,j;
		for(i=0;i<nums.length-1;i++){
			for(j=i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target){
					return new int [] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution.");
	}
	
	public static int[] twoSum2(int[] nums, int target){
		int i,complement;
		Map<Integer, Integer> map = new HashMap<>();
		for(i=0;i<nums.length;i++){
			map.put(nums[i], i);
		}
		for(i=0;i<nums.length;i++){
			complement = target-nums[i];
			if(map.containsKey(complement)&&map.get(complement)!=i)
				return new int [] {i,map.get(complement)};
		}
		throw new IllegalArgumentException("No two sum solution.");
	}
	
	public static int[] twoSum3(int[] nums, int target){
		int i,complement;
		Map<Integer, Integer> map = new HashMap<>();
		for(i=0;i<nums.length;i++){
			complement = target-nums[i];
			if(map.containsKey(complement))
				return new int [] {map.get(complement),i};
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution.");
	}

}
