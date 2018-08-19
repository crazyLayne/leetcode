package TempTest101_125;

public class SymmetricTree {
	public static void main(String args[]){
		
	}
	public boolean isSymmetric(TreeNode root) {
		if(root!=null)
			return isSameTree(root.left,root.right);
        return true;
    }
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        if(p==null || q==null)return false;
        if(p.val==q.val && isSameTree(p.left,q.right) && isSameTree(p.right,q.left)){
			return true;
        }
        return false;
    }

}
