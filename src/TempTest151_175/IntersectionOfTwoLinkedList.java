package TempTest151_175;
import dataStructure.ListNode;;
public class IntersectionOfTwoLinkedList {
	public static void main(String args[]){
		ListNode headA=new ListNode(1);
		ListNode A=headA;
		A.next=new ListNode(3);
		ListNode headB=A;
		System.out.print(solution2(headA, headB).val);
		
	}
	//一趟统计长度，再同一起跑线向后遍历，寻找相同节点
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if(headA==null || headB==null)return null;
		ListNode temp=null;
		ListNode p=headA;
		ListNode q=headB;
		int len1,len2;
		len1=len2=0;
		while(p!=null){
			len1++;
			p=p.next;
		}
		while(q!=null){
			len2++;
			q=q.next;
		}
		if(len1>len2){			//让两个链表同一长度
			while(len1!=len2){
				headA=headA.next;
				len1--;
			}
		}else if(len1<len2){
			while(len1!=len2){
				headB=headB.next;
				len2--;
			}
		}
		while(headA!=null){
			if(headA==headB){
				temp=headA;
				break;
			}
			headA=headA.next;
			headB=headB.next;
		}
		return temp;
	}
	//headA遍历完接headB，headB遍历完接headA,这样两个链表必定同时到达终点，便利过程中判断
	public static ListNode solution2(ListNode headA, ListNode headB){
		if(headA==null  || headB==null)return null;
		ListNode p=headA;
		ListNode q=headB;
		while(true){
			if(p==q)return p;
            p=p.next;
            q=q.next;
			if(p==null && q==null)return null;
			if(p==null)p=headB;
			if(q==null)q=headA;
		}
	}
}
