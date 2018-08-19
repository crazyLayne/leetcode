package TempTest76_100;

import java.util.List;
import java.util.Vector;

public class Subset {
	public static void main(String args[]){
		
	}
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> ans=new Vector<>();
		List<Integer> an=new Vector<>();
        ans.add(new Vector<>(an));
		recur(nums, ans, an, 0);
		return ans;
	}
	public void recur(int[] nums, List<List<Integer>> ans, List<Integer> an, int st){
		for(int i=st;i<nums.length;i++){
			an.add(nums[i]);
            ans.add(new Vector<>(an));
			recur(nums, ans, an, i+1);
			an.remove(an.size()-1);
		}
	}

}
