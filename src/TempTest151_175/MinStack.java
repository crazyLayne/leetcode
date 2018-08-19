package TempTest151_175;

import java.util.ArrayList;
import java.util.List;

class MinStack1 {

    ListNode head1;		//����ջ˳��洢��ͷ�巨
	ListNode head2;		//��ֵ��С��������
	
    public MinStack1() {
    	head1 = new ListNode(-1);
    	head2= new ListNode(-1);
    }
    
    public void push(int x) {
        ListNode node1 = new ListNode(x);
        node1.next = head1.next;
        head1.next=node1;
        
        ListNode node2 = new ListNode(x);
        ListNode p = head2;
        while(p.next!=null && p.next.val<x){
        	p=p.next;
        }
        node2.next = p.next;
        p.next = node2;
    }
    
    public void pop() {
    	int temp = head1.next.val;
        head1.next = head1.next.next;
        
        ListNode p=head2;
        while(p.next!=null && p.next.val != temp){
        	p=p.next;
        }
        if(p.next.next != null) p.next=p.next.next;	//Ŀ�겻�����һ��Ԫ��
        else p.next=null;							//Ŀ�������һ��Ԫ��
    }
    
    public int top() {
        return head1.next.val;
    }
    
    public int getMin() {
        return head2.next.val;
    }
    
}

public class MinStack {
	/** initialize your data structure here. */
	ListNode head1;		//����ջ˳��洢��ͷ�巨
	int min;
    public MinStack() {
    	head1 = new ListNode(-1);
    	min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        ListNode node1 = new ListNode(x);
        node1.next = head1.next;
        head1.next=node1;
        if(x<min)min=x;
    }
    
    public void pop() {
    	int temp = head1.next.val;
    	head1.next = head1.next.next;
    	if(temp==min){
    		ListNode p=head1.next;
    		min = Integer.MAX_VALUE;
    		while(p!=null){
    			if(p.val<min)min=p.val;
    			p=p.next;
    		}
    	}
    }
    
    public int top() {
        return head1.next.val;
    }
    
    public int getMin() {
        return min;
    }
    
}
class ListNode{
	int val;
	ListNode next;
	public ListNode(int val){
		this.val=val;
		next=null;
	}
}

