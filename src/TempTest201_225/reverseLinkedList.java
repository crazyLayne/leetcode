package TempTest201_225;

import dataStructure.ListNode;

public class reverseLinkedList {
	public static void main(String args[]){
		ListNode head=new ListNode(1);
		ListNode reHead=reverseList(head);
		while(reHead!=null)
			System.out.print(reHead.val+"\t");
	}
	//链表可以迭代或递归地反转.(头插法)
	public static ListNode reverseList(ListNode head){
		ListNode Head=new ListNode(-1);
		if(head==null)return head;
		ListNode rem=head;		//待插部分
		while(rem!=null){
			head=rem;			//待插部分的第一个节点
			rem=rem.next;
			head.next=Head.next;
			Head.next=head;
		}
		return Head.next;
	}
	//递归
	public static ListNode reverseList2(ListNode head){
		ListNode Head=new ListNode(-1);
		if(head==null)return head;
		reverse(Head, head);
		return Head.next;
	}
	public static void reverse(ListNode Head, ListNode now){
		if(now!=null){
			ListNode rem;
			rem=now.next;
			now.next=Head.next;
			Head.next=now;
			reverse(Head, rem);
		}
	}

}
