package TempTest101_125;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
	public static void main(String args[]){
		
	}
	public void flatten2(TreeNode root) {
		if(root!=null){
			Stack<TreeNode> s=new Stack<>();
            TreeNode node;			//正在处理的节点
			s.push(root);
            node=s.pop();
            if(root.right!=null)s.push(root.right);
            if(root.left!=null)s.push(root.left);
			while(!s.isEmpty()){
				node.right=s.pop();
				node.left=null;
				node=node.right;
				if(node.right!=null)s.push(node.right);
				if(node.left!=null)s.push(node.left);
			}
		}
    }
	public void flatten(TreeNode root) {		
		if(root!=null){
			flatten(root.left);
			TreeNode LLast=root;
			if(root.left!=null){
				LLast=root.left;
				while(LLast.right!=null){
					LLast=LLast.right;
				}
			}
			TreeNode L=root.left;
			flatten(root.right);
			TreeNode R=root.right;
			root.left=null;
			root.right=L;
			LLast.right=R;
		}
    }
	public void flatten3(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        TreeNode temp = root.left;
        while (temp != null && temp.right != null) {
            temp = temp.right;
        }
        
        flatten(root.right);
        if (temp != null) {
            temp.right = root.right;    
            root.right = root.left;
            root.left = null;
        }
    }


}
