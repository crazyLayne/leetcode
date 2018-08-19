package TempTest26_50;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static void main(String args[]){
		int[] nums = {8,7,4,3};
		int target = 11;
		List<List<Integer>> ans = solution(nums,target);
		System.out.println(ans);
	}
	public static List<List<Integer>> solution(int[] candidates,int target){
		List<List<Integer>> ans = new ArrayList<>();
		int[] max = new int[candidates.length];
		for(int i=0;i<candidates.length;i++)
			max[i]=target/candidates[i];
		List<Integer> an = new ArrayList<>();
		List<Integer> bn = new ArrayList<>();
		solve(candidates,max,target,0,0,ans,an,bn);
		return ans;
	}
	public static void solve(int[] nums,int[] max,int target,int sum,int index,List<List<Integer>> ans,List<Integer> an,List<Integer> temp){
		if(index<nums.length){
			for(int i=0;i<max[index];i++){
				an.add(nums[index]);
				sum+=nums[index];
			}
			for(int i=0;i<max[index];i++){
				if(sum==target){
 					temp=(List<Integer>) ((ArrayList<Integer>) an).clone();
					ans.add(temp);
				}else if(sum<target){
					solve(nums,max,target,sum,index+1,ans,an,temp);
				}
				an.remove(an.size()-1);
				sum-=nums[index];
			}
				solve(nums,max,target,sum,index+1,ans,an,temp);
		}
	}

}
