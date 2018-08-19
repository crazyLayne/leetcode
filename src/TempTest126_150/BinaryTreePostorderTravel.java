package TempTest126_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTravel {
	public static void main(String args[]){
		
	}
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        HashMap<TreeNode,Integer> map=new HashMap<>();
        if(root==null)return list;
        st.push(root);
        TreeNode temp; 
        while(!st.isEmpty()){
        	temp=st.peek();
        	if(map.containsKey(temp)){
        		list.add(st.pop().val);
        	}else{
        		map.put(temp, 1);
        		if(temp.right!=null)st.push(temp.right);
        		if(temp.left!=null)st.push(temp.left);
        	}
        }
        return list;
    }
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        if(root==null)return list;
        st.push(root);
        TreeNode temp; 
        while(!st.isEmpty()){
        	temp=st.peek();
        	if(temp.left==null && temp.right==null){
        		list.add(st.pop().val);
        	}else{
        		if(temp.right!=null){
        			st.push(temp.right);
        			temp.right=null;
        		}
        		if(temp.left!=null){
        			st.push(temp.left);
        			temp.left=null;
        		}
        	}
        }
        return list;
    }

}
