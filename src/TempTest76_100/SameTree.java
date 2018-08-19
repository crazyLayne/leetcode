package TempTest76_100;

public class SameTree {
	public static void main(String args[]){
		
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        if(p==null || q==null)return false;
        if(p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right)){
			return true;
        }
        return false;
    }
	 public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
