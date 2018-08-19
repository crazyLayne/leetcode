package TempTest76_100;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public void main (String args[]){
		
	}
	
	 
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	class Solution {
	    public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> nodes=new ArrayList<>();
	        if(root!=null)visit(nodes,root);
	        return nodes;
	    }
	    
	    public void visit(List<Integer> nodes, TreeNode root){
	        if(root!=null){
	            visit(nodes,root.left);
	            nodes.add(root.val);
	            visit(nodes,root.right);
	        }
	    }
	    
	}

}
