package TempTest1_25;

public class ReverseNodesInKGroup {
	public static void main(String args[]){
		
	}
	public static ListNode solution(ListNode head, int k){
		ListNode Head = new ListNode(0);
		Head.next = head;
		if(head==null || head.next==null)
			return Head.next;
		ListNode now = head;				//ָ�뵱ǰλ��
		ListNode rem = head;				//ʣ��һ�������ͷ
		ListNode Hrem = head;				//��һ�ڵ�ͷ����ת�����һ��
		ListNode[] p = new ListNode[k];
		int count;
		do{
			count = 0;
			rem = now;							//���費��һ�ˣ�ʣ��ӵ�ǰ��ʼ
			while(now.next!=null && count<k){
				p[count++]=now;
				now=now.next;
			}
			p[count++] = now;
			if(count<k)						//����һ����ת
				break;
			Hrem.next = p[k-1];
			for(int i=k-1;i>0;i++)			//��ʼ��ת
				p[i].next=p[i-1];
			if(now.next!=null)				//����һ����������ʣ��
				rem = now.next;
			else{							//û��ʣ����
				p[0].next=null;
				return Head.next;
			}
			
		}while(now.next!=null);
		if(head==p[count-1]){				//û��һ������ת��
			return Head.next;
		}
		p[0].next=rem;						//��һ����ת��ͷ��ʣ�ಿ��
		return Head.next;
	}

}
