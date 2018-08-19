package TempTest1_25;

public class MergeKSortedLists {
	public static void main(String args[]){
		
	}
	public static ListNode solution(ListNode[] lists){
		ListNode Head = new ListNode(-1);		//头结点
		int num=0;
		ListNode [] p = new ListNode[lists.length];
		for(int i=0;i<lists.length;i++){		//遍历每一个指针
			if(lists[i]!=null)
				p[num++] = lists[i];
		}if(num==0) return Head.next;
        else if(num==1) return p[0];
		subsol(Head,p,num);
		return Head.next;
	}
	public static void subsol(ListNode q, ListNode[] p, int num){	//num表示不为空的链表个数
		if(num==1){
			q.next=p[0];
			return;
		}
		int min=p[0].val;
		int minindex=0;
		for(int i=1;i<num;i++){			//找最小节点
			if(p[i].val<min){
				min=p[i].val;
				minindex=i;
			}
		}
		q.next = new ListNode(min);
		p[minindex]=p[minindex].next;
		if(p[minindex]==null){
			if(minindex!=num){		//不是最后一个链表，则把最后一个链表往前诺
				p[minindex]=p[num-1];
			}
			num--;
		}
		subsol(q.next,p,num);
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length==0)return null;
		return helper(lists,0,lists.length-1);
	}
	public static ListNode helper(ListNode[] lists, int low, int high){
		if(low<high){
			int mid=(low+high)/2;
			return mergeTwoLists(helper(lists,low,mid),helper(lists,mid+1,high));
		}
		return lists[low];
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
	public static ListNode solution(ListNode l1,ListNode l2){
		ListNode Head,p1,p2,q;
		Head = new ListNode(0);
		q = Head;		//合并链表当前位置
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
}
