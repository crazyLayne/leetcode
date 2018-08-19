package TempTest101_125;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public static void main(String args[]){
		
	}
	int cur;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0)return null;
        cur=postorder.length-1;
        TreeNode root=new TreeNode(postorder[cur]);
        HashMap<Integer, Integer> hash=new HashMap<>();
        for(int i=0;i<inorder.length;i++)hash.put(inorder[i],i);        //用hashmap方便查找分支节点所在坐标
        build(inorder, 0, inorder.length-1, postorder, root, hash);
        return root;
    }
    public void build(int[] inorder, int left, int right , int[] postorder, TreeNode node, HashMap<Integer, Integer> hash){
        int i=hash.get(postorder[cur]);
        if(i<right){
            node.right=new TreeNode(postorder[--cur]);
            build(inorder, i+1, right, postorder, node.right, hash);
        }
        if(i>left){
            node.left=new TreeNode(postorder[--cur]);
            build(inorder, left, i-1, postorder, node.left, hash);
        }
        
    }

}
