package TempTest1_25;


public class RemoveNthNodeFormEndofList {
	public static void main(String args[]){
		
	}
	public static ListNode solution(ListNode head, int n){
		ListNode p,Nth,q;
		q = head;
		while(n>1){
			q = q.next;
			n--;
		}
		ListNode NewHead = new ListNode(-1);
        NewHead.next = head;
        p = NewHead;
		Nth = p.next;
		while(q.next!=null){
			p=p.next;
			Nth=Nth.next;
			q=q.next;
		}
        
        if(p.next==head){       //head»á±»¸²¸Çµô
            p.next = Nth.next;
            return p.next;
        }else{
            p.next = Nth.next;
            return head;
        }
	
	}
}
