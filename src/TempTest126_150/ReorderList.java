package TempTest126_150;

public class ReorderList {

	public static void main(String args[]){
		ListNode head=new ListNode(1);
		ListNode p=head;
		p.next=new ListNode(2);
		p=p.next;
		p.next=new ListNode(3);
		p=p.next;
		p.next=new ListNode(4);
		p=p.next;
		p.next=new ListNode(5);
		p=p.next;
		reorderList(head);
		System.out.println("end");
	}
	public static void reorderList(ListNode head) {
        ListNode fast,slow;
        fast=slow=head;
        if(head==null || head.next==null || head.next.next==null)return ;       //0,1,2��Ԫ��ֱ�ӷ���
        while(fast!=null){      //�ҵ��м�λ��slow
            if(fast.next==null)break;
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode Head=new ListNode(-1);     //����
        //ͷ�巨��������
        ListNode p=slow.next;       //����
        slow.next=null;
        ListNode q;
        while(p!=null){
            q=p;
            p=p.next;
            q.next=Head.next;
            Head.next=q;
        }
        p=Head.next;
        while(p!=null){
            q=p;
            p=p.next;
            q.next=head.next;
            head.next=q;
            head=head.next.next;
        }
    }
	
}
