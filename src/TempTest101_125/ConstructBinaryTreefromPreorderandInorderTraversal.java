package TempTest101_125;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public static void main(String args[]){
		
	}
	int cur;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)return null;
        TreeNode root=new TreeNode(preorder[0]);
        cur=0;
        HashMap<Integer, Integer> hash=new HashMap<>();
        for(int i=0;i<preorder.length;i++)hash.put(inorder[i],i);
        build(preorder, inorder, 0, inorder.length-1, root, hash);
        return root;
    }
    public void build(int[] preorder, int[] inorder, int left, int right, TreeNode node, HashMap<Integer, Integer> hash){
        int i=hash.get(preorder[cur]);
        if(i>left){         //左子树不为空
            TreeNode leftTree=new TreeNode(preorder[++cur]);
            node.left=leftTree;
            build(preorder, inorder, left, i-1, leftTree, hash);
        }
        if(i<right){        //右子树不为空
            TreeNode rightTree=new TreeNode(preorder[++cur]);
            node.right=rightTree;
            build(preorder, inorder, i+1, right, rightTree, hash);
        }
        
    }

}
