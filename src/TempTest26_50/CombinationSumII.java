package TempTest26_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static void main(String args[]){
		int[] nums = {1};
		int target = 1;
		System.out.println(solution(nums,target));
		
	}
	public static List<List<Integer>> solution(int[] candidates, int target){
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> an = new ArrayList<>();
		List<Integer> bn = new ArrayList<>();
		int[] max = new int[candidates.length];
		int length = 0;
		boolean flag;
		int i,j;
		for(i=0;i<candidates.length;i++){
			if(candidates[i]<=target){
				flag=false;
				for(j=0;j<length;j++){
					if(candidates[i]==candidates[j]){
						flag=true;
						break;
					}
				}
				if(flag){
					max[j]=max[j]+1;
				}else{
					candidates[length]=candidates[i];
					max[length++]=1;
				}
			}
		}
		
		solve(candidates,max,target,0,0,ans,an,bn,length);
		return ans;
	}
	public static void solve(int[] nums,int[] max,int target,int sum,int index,List<List<Integer>> ans,List<Integer> an,List<Integer> temp,int length){
		if(index<length){
			for(int i=0;i<max[index];i++){
				an.add(nums[index]);
				sum+=nums[index];
			}
			for(int i=0;i<max[index];i++){
				if(sum==target){
 					temp=(List<Integer>) ((ArrayList<Integer>) an).clone();
					ans.add(temp);
				}else if(sum<target){
					solve(nums,max,target,sum,index+1,ans,an,temp,length);
				}
				an.remove(an.size()-1);
				sum-=nums[index];
			}
				solve(nums,max,target,sum,index+1,ans,an,temp,length);
		}
	}

}
