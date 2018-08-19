package TempTest126_150;

public class SortList {
	public static void main(String args[]){

		ListNode head=new ListNode(3);
		ListNode p=head;
		p.next=new ListNode(1);
		p=p.next;
		p.next=new ListNode(5);
		p=p.next;
		p.next=new ListNode(9);
		p=p.next;
		p.next=new ListNode(2);
		p=p.next;
		p.next=new ListNode(5);
		p=p.next;
		p.next=new ListNode(8);
		p=p.next;
		p.next=new ListNode(1);
		p=p.next;
		ListNode L=split(head);
	}
	public static ListNode split(ListNode head){
        if(head.next==null)return head;
        ListNode slow=head;
        ListNode fast=head;
        fast=fast.next.next;		//fast先走，保证slow.next能取到一半的head2
    	while(fast!=null){
    		slow=slow.next;
            fast=fast.next;
            if(fast==null)break;
            fast=fast.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        return mergeSort(split(head),split(head2));
    }
	public static ListNode mergeSort(ListNode L1, ListNode L2) {
        if(L1==null)return L2;
        if(L2==null)return L1;
        if(L1.val>L2.val) return mergeSort(L2,L1);         //保证L1的第一个值比较小，将L2插入到L1中
        ListNode p=L1;
        ListNode q=L2;
        ListNode temp;
        while(p.next!=null && q!=null){
            if(p.next.val<=q.val){
                p=p.next;
            }else{
                temp=q.next;
                q.next=p.next;
                p.next=q;
                p=q;
                q=temp;
            }
        }
        if(p.next==null){
            p.next=q;
        }
        return L1;
    }

}
