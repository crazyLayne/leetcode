package TempTest151_175;
import dataStructure.TreeNode;
public class BSTIterator {
	
	TreeNode node;
	
	public BSTIterator(TreeNode root) {
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return node.left!=null || node.right!=null;
    }

    /** @return the next smallest number */
    public int next() {
        
    }

}
