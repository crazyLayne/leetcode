package TempTest76_100;

public class ValidateBinarySearchTree {
	public static void main(String args[]){
		
	}
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 public boolean isValidBST(TreeNode root) {
		 int[] lastValue=new int[2];
		 return visit(lastValue,root);
	 }


	 public boolean visit(int[] last, TreeNode root){
	     if(root==null){
	    	 return true;
	     }
	     if(visit(last,root.left)){
	     	if(last[0]==0 || last[1]<root.val){
	        	last[0]=1;
	            last[1]=root.val;
	            if(visit(last,root.right)){
	            	return true;
	            }
	        }
	     }
	     return false;
	}
}
