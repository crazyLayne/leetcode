package TempTest1_25;

public class AddTwoNumbers {
	public static void main(String args[]){
		
	}
	
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
		ListNode dummyhead = new ListNode(0);
		ListNode p=l1,q=l2;
		int sum,num1=0,num2=0;
		while(p!=null){
			num1=num1*10+p.val;
			p=p.next;
		}
		while(q!=null){
			num2=num2*10+q.val;
			q=q.next;
		}
		sum=num1+num2;
		while(sum!=0){
			dummyhead.next = new ListNode(sum%10);
			sum=sum/10;
		}
		return dummyhead.next;
	}

}
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val=val;
		this.next=null;
	}
}