package TempTest1_25;

public class MergeTwoSortedLists {
	public static void main(String args[]){
		
	}
	public static ListNode solution(ListNode l1,ListNode l2){
		ListNode Head,p1,p2,q;
		Head = new ListNode(0);
		q = Head;		//�ϲ�����ǰλ��
		p1 = l1;
		p2 = l2;
		while(p1!=null && p2!=null){
			if(p1.val>p2.val){
				q.next = new ListNode(p2.val);
				p2 = p2.next;
			}else{
				q.next = new ListNode(p1.val);
				p1 = p1.next;
			}
			q=q.next;
		}
		if(p1!=null){
			q.next=p1;
		}else if(p2!=null){
			q.next=p2;
		}
		return Head.next;
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
