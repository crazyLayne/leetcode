package TempTest76_100;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	public static void main (String args[]){
		combine(5,4);
		int[] nums=new int[2];
		System.out.println(nums[1]);
		System.out.println(nums);
	}
	public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> an=new ArrayList<>();
        recursion(n,k,ans,an,0,0);
        return ans;
    }
	public static void recursion(int n,int k,List<List<Integer>> ans,List<Integer> an,int count,int st){
		if(count==k){
			ans.add(new ArrayList<Integer>(an));
		}else if(k-count>n-st)return;
		else if(count<k){
			for(int i=st;i<n;i++){
				an.add(i+1);
				recursion(n,k,ans,an,count+1,i+1);
				an.remove((Integer)(i+1));
			}
		}
    }

}
