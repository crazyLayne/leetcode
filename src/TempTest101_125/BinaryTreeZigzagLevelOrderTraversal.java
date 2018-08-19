package TempTest101_125;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String args[]){
		
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<>();
		if(root!=null){
			DSF(root,0,res);
		}
		return res;
    }
	
	public void DSF(TreeNode root, int depth, List<List<Integer>> res){
		if(root!=null){
			if(depth==res.size()){
				res.add(new ArrayList<>());
			}
			if(depth%2==0)	res.get(depth).add(root.val);
			else	res.get(depth).add(0, root.val);
			DSF(root.left,depth+1,res);
			DSF(root.right,depth+1,res);
		}
	}

}
