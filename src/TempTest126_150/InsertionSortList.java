package TempTest126_150;

public class InsertionSortList {
	public static void main(String args[]){
		
	}
	
	public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode Head=new ListNode(-1);
        Head.next=head;
        ListNode p=Head;        //�����������
        ListNode q=head.next;   //�����������
        ListNode temp;
        head.next=null;         //�����������β���ÿ�
        while(q!=null){
            while(p.next.val<=q.val && p.next.next!=null){      //�ҵ���һ����p���ֵ���Ѿ���ͷ��
                p=p.next;
            }
            if(p.next.next==null && p.next.val<=q.val){      //����������е�β����
                temp=q;
                q=q.next;
                p.next.next=temp;
                temp.next=null;
            }else{                          //����p����
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
