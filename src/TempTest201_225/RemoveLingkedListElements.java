package TempTest201_225;

import java.util.HashSet;

import dataStructure.ListNode;

public class RemoveLingkedListElements {
	public static void main(String args[]){
		
	}
	public static ListNode removeElments(ListNode head, int val){
		ListNode Head=new ListNode(-1);
		Head.next=head;
		ListNode p=Head;
		while(p.next!=null){
			if(p.next.val==val){
				p.next=p.next.next;
			}else{
				p=p.next;
			}
		}
		return Head.next;
	}

}
