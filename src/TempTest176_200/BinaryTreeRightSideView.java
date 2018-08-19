package TempTest176_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dataStructure.TreeNode;

public class BinaryTreeRightSideView {
	public static void main(String args[]){
		
	}
	//层次遍历,每一层最后一个加入list
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if(root==null)return list;
		q.offer(root);
		TreeNode node,last1,last2;
		last1=last2=root;
		while(!q.isEmpty()){
			node=q.poll();
			if(node.left!=null){q.offer(node.left);last2=node.left;}
			if(node.right!=null){q.offer(node.right);last2=node.left;}
			if(node==last1){list.add(node.val);last1=last2;}	//上一层结束了
		}
		return list;
    }

}
