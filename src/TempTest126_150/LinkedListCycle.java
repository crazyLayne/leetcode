package TempTest126_150;

import java.util.HashMap;

public class LinkedListCycle {
	public static void main(String args[]){
		
	}
	public static boolean hasCycle(ListNode head){
		HashMap<ListNode, Integer> map=new HashMap<>();
        while(head.next!=null){
            if(map.containsKey(head)){
                return false;
            }else{
                map.put(head,1);
            }
            head=head.next;
        }
        return true;
	}
	public boolean hasCycle1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) return true;
        }
        
        return false;
        
    }

}
