package TempTest1_25;

public class ReverseNodesInKGroup {
	public static void main(String args[]){
		
	}
	public static ListNode solution(ListNode head, int k){
		ListNode Head = new ListNode(0);
		Head.next = head;
		if(head==null || head.next==null)
			return Head.next;
		ListNode now = head;				//指针当前位置
		ListNode rem = head;				//剩余一节链表的头
		ListNode Hrem = head;				//上一节的头，逆转后接下一节
		ListNode[] p = new ListNode[k];
		int count;
		do{
			count = 0;
			rem = now;							//假设不够一趟，剩余从当前开始
			while(now.next!=null && count<k){
				p[count++]=now;
				now=now.next;
			}
			p[count++] = now;
			if(count<k)						//不够一趟逆转
				break;
			Hrem.next = p[k-1];
			for(int i=k-1;i>0;i++)			//开始逆转
				p[i].next=p[i-1];
			if(now.next!=null)				//完整一趟下来还有剩余
				rem = now.next;
			else{							//没有剩余了
				p[0].next=null;
				return Head.next;
			}
			
		}while(now.next!=null);
		if(head==p[count-1]){				//没有一个够逆转的
			return Head.next;
		}
		p[0].next=rem;						//上一个逆转的头接剩余部分
		return Head.next;
	}

}
