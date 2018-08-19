package TempTest101_125;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public static void main(String args[]){
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root!=null){
            List<Integer> an=new ArrayList<>();
            dfs(root,sum,ans,an);
        }
        return ans;
    }
    public void dfs(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> an){
        if(root!=null){
            an.add(root.val);
            if(root.left==null && root.right==null && sum==root.val){
                ans.add(new ArrayList<>(an));
            }
            if(root.left!=null)dfs(root.left, sum-root.val, ans, an);
            if(root.right!=null)dfs(root.right, sum-root.val, ans, an);
            an.remove(an.size()-1);
        }
        
    }

}
