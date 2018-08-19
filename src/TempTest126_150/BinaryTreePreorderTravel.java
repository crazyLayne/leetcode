package TempTest126_150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTravel {
	public static void main(String args[]){
		
	}
	public List<Integer> preorderTrabersal(TreeNode root){
		List<Integer> list=new ArrayList<>();
		Stack<TreeNode> st=new Stack<>();
		if(root==null)return list;
		st.push(root);
		TreeNode temp;
		while(!st.isEmpty()){
			temp=st.pop();
			list.add(temp.val);
			if(temp.right!=null)st.push(temp.right);
			if(temp.left!=null)st.push(temp.left);
		}
		return list;
	}

}
