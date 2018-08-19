package TempTest101_125;

//import java.util.ArrayList;
//import java.util.List;

public class CovertSortedListtoBinarySearchTree {
	public static void main(String args[]){
		
	}
//	public TreeNode sortedArrayToBST(ListNode head) {
//		List<Integer> nums=new ArrayList<>();
//		while(head!=null){
//			nums.add(head.val);
//			head=head.next;
//		}
//        int len=nums.size();
//        if(len==0)return null;
//        TreeNode root=new TreeNode(nums.get(len/2));
//        build(nums, len/2, 0, len-1, root);
//        return root;
//    }
//    public void build(List<Integer> nums, int mid, int left, int right, TreeNode root){
//        if(mid>left){           //存在左子树
//            int leftM=(mid-1+left)/2;
//            TreeNode leftTree=new TreeNode(nums.get(leftM));
//            root.left=leftTree;
//            build(nums,leftM,left,mid-1,leftTree);
//        }
//        if(mid<right){          //存在右子树
//            int rightM=(mid+1+right)/2;
//            TreeNode rightTree=new TreeNode(nums.get(rightM));
//            root.right=rightTree;
//            build(nums,rightM,mid+1,right,rightTree);
//        }
//    }
    public TreeNode sortedArrayToBST(ListNode head) {
		int len=0;
		ListNode Head=head;
		while(head!=null){
			len++;
			head=head.next;
		}
		int[] nums=new int[len]; 
		for(int i=0;i<len;i++){
			nums[i]=Head.val;
			Head=Head.next;
		}
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
