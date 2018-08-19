package TempTest101_125;

public class MinimumDepthofBinaryTree {
	public static void main(String args[]){
		
	}
	public int minDepth(TreeNode root) {
		if(root==null)return 0;
		int left=minDepth(root.left);
		int right=minDepth(root.right);
		return 1+((left==0^right==0)?Math.max(left, right):Math.min(left, right)); 
    }
}
