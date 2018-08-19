package TempTest76_100;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public static void main(String args[]){
		generateTrees(3);
	}
	 public static List<TreeNode> generateTrees(int n) {
		 if(n<1)return new ArrayList<>();
		 return solve(1,n);
	 }
	 public static List<TreeNode> solve(int left,int right){
		 List<TreeNode> trees = new ArrayList<>();
		 if(left>right){
			 trees.add(null);
			 return trees;
		 }
		 for(int i=left;i<=right;i++){
			 List<TreeNode> LeftTrees=solve(left,i-1);
			 List<TreeNode> RightTrees=solve(i+1,right);
			 for(TreeNode Lnode:LeftTrees){
				 for(TreeNode Rnode:RightTrees){
					 TreeNode root=new TreeNode(i);
					 root.left=Lnode;
					 root.right=Rnode;
					 trees.add(root);
				 }
			 }
		 }
		 return trees;
	 }
	        
	 
	

}
