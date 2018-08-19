package TempTest101_125;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {
	public static void main(String args[]){
		
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans=new LinkedList<>();
		if(root==null)return ans;
        Queue<TreeNode> p=new LinkedList<>();		//上一层
        Queue<TreeNode> q=new LinkedList<>();		//下一层
        p.offer(root);
        while(!p.isEmpty()){
        	List<Integer> an=new LinkedList<>();
        	while(!p.isEmpty()){
            	root=p.poll();
            	an.add(root.val);
            	if(root.left!=null)q.offer(root.left);
            	if(root.right!=null)q.offer(root.right);
            }
        	ans.add(an);
        	p=q;
            q=new LinkedList<>();
        }
        return ans;
    }
}
