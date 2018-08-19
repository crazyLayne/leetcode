package TempTest126_150;

public class InsertionSortList {
	public static void main(String args[]){
		
	}
	
	public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode Head=new ListNode(-1);
        Head.next=head;
        ListNode p=Head;        //遍历有序队列
        ListNode q=head.next;   //遍历无序队列
        ListNode temp;
        head.next=null;         //将已有序队列尾巴置空
        while(q!=null){
            while(p.next.val<=q.val && p.next.next!=null){      //找到第一个比p大的值或已经到头了
                p=p.next;
            }
            if(p.next.next==null && p.next.val<=q.val){      //接在有序队列的尾巴上
                temp=q;
                q=q.next;
                p.next.next=temp;
                temp.next=null;
            }else{                          //插在p后面
                temp=q;
                q=q.next;
                temp.next=p.next;
                p.next=temp;
            }
            p=Head;
        }
        return Head.next;
    }

}
