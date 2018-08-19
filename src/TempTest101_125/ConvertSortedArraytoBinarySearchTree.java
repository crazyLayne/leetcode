package TempTest101_125;

public class ConvertSortedArraytoBinarySearchTree {
	public static void main(String args[]){
		
	}
	public TreeNode sortedArrayToBST(int[] nums) {
        int len=nums.length;
        if(len==0)return null;
        TreeNode root=new TreeNode(nums[len/2]);
        build(nums, len/2, 0, len-1, root);
        return root;
    }
    public void build(int[] nums, int mid, int left, int right, TreeNode root){
        if(mid>left){           //存在左子树
            int leftM=(mid-1+left)/2;
            TreeNode leftTree=new TreeNode(nums[leftM]);
            root.left=leftTree;
            build(nums,leftM,left,mid-1,leftTree);
        }
        if(mid<right){          //存在右子树
            int rightM=(mid+1+right)/2;
            TreeNode rightTree=new TreeNode(nums[rightM]);
            root.right=rightTree;
            build(nums,rightM,mid+1,right,rightTree);
        }
    }

}
