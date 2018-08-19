package TempTest126_150;

import java.util.HashMap;

public class CopyListWithRandomPointer {
	public static void main(String args[]){
		
	}
	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode Head=new RandomListNode(0);
        RandomListNode p = Head;
        HashMap<Integer, RandomListNode> t=new HashMap<>();
        int temp;
        while(head!=null){
            p.next=new RandomListNode(head.label);
            p=p.next;
            if(head.random!=null){
                temp=head.random.label;
                if(t.containsKey(temp)){       //已经有了
                    p.random=t.get(temp);           //指向复制后自己的节点
                }else{                          //没有则实例化一个，并加入HashTable
                    RandomListNode tempp=new RandomListNode(temp);
                    p.random=tempp;
                    t.put(temp, tempp);
                }
            }else{
                p.random=null;
            }
            
            head=head.next;
        }
        return Head.next;
    }

}
