package TempTest51_75;

public class RotateList {
	public static void main(String args[]){
		
	}
	public static ListNode solution(ListNode head, int k){
		ListNode Head = new ListNode(-1);
		Head.next=head;
        if(head==null)return Head.next;
		ListNode p,q;
		p=q=Head;
        int count=0;
		while(k>0){
			q=q.next;
			k--;
            count++;
            if(q.next==null){
                q=Head;
                k=k%count;
            }
		}
		while(q.next!=null){
			p=p.next;
			q=q.next;
		}
        if(Head==p)return Head.next;
		q.next=Head.next;
		Head.next=p.next;
		p.next=null;
		return Head.next;
	}
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val=x;}
	}
}
