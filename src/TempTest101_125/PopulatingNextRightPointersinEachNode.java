package TempTest101_125;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
	public static void main(String args[]){
		
	}
	public void connect(TreeLinkNode root) {		//²ã´Î±éÀú
		if(root==null)return;
		Queue<TreeLinkNode> q1=new LinkedList<>();
		Queue<TreeLinkNode> q2=new LinkedList<>();
		TreeLinkNode temp1,temp2;
        q1.offer(root);
        while(!q1.isEmpty()){
        	temp1=q1.poll();
        	if(temp1.left!=null)q2.offer(temp1.left);
        	if(temp1.right!=null)q2.offer(temp1.right);
        	while(!q1.isEmpty()){
        		temp2=q1.poll();
        		if(temp2.left!=null)q2.offer(temp2.left);
        		if(temp2.right!=null)q2.offer(temp2.right);
        		temp1.next=temp2;
        		temp1=temp2;
        	}
        	q1=q2;
        	q2=new LinkedList<>();
        }
    }
	public void connect2(TreeLinkNode root){
		if(root==null)return;
		root.left.next=root.right;
		while(root.next!=null){
			root.right.next=root.next.left;
			connect2(root.next);
		}
		connect2(root.left);
		connect2(root.right);
	}

}
