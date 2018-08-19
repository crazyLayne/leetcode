package TempTest101_125;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	public static void main(String args[]){
		
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		dfs(root, 0, res);
        Collections.reverse(res);
        return res;
	}
    
    public void dfs(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }

}

