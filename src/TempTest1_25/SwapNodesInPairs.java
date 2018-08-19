package TempTest1_25;

public class SwapNodesInPairs {
	public static void main(String args[]){
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		p1.next=p2;
		p2.next=p3;
		p3.next=null;
		ListNode ans = solution(p1);
		while(ans.next!=null){
			System.out.println(ans.val);
			ans=ans.next;
		}
		System.out.println(ans);
	}
	public static ListNode solution(ListNode head){
		ListNode Head = new ListNode(0);
		Head.next = head;
		ListNode p,q,r,temp;
		if(head==null || head.next==null)
			return Head.next;
		p = head;
		q = p.next;
		Head.next = q;
		while(q.next!=null && q.next.next!=null){
			temp = q.next;
			q.next = p;
			p.next = temp.next;
			p = temp;
			q = temp.next;
		}
		if(q.next==null){
			q.next = p;
			p.next = null;
		}else if(q.next.next==null){
			temp = q.next;
			q.next = p;
			p.next = temp;
			temp.next = null;
		}
		return Head.next;
	}

}
