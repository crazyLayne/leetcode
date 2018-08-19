package TempTest76_100;

public class RemoveDuplicatesfromSortedList {
	public static void main(String args[]){
		
	}
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode p,q;
        p=head;
        q=p;
        while(q.next!=null){
            q=q.next;
            if(p.val!=q.val){
                p.next=q;
                p=q;
            }
        }
        if(p.val==q.val)
            p.next=null;
        return head;
    }
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

}
