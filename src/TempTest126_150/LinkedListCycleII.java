package TempTest126_150;

public class LinkedListCycleII {

	public static void main(String args[]){
		
	}
	public ListNode detectCycle(ListNode head) {
        if(head==null)return head;
        if(head.next==null)return null;
        ListNode fast,slow;
        fast=slow=head;
        while(fast!=null){
            slow=slow.next;
            if(fast.next==null)break;
            fast=fast.next.next;
            if(fast==slow){				//slow走了x，fast走了2x
                while(head!=slow){		//fast和slow一起走，再走x步也会在改点相会，最早相会的点就是环的起始点
                    head=head.next;
                    slow=slow.next;
                }
                return head;
            }
        }
        return null;
    }
}
