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
                if(t.containsKey(temp)){       //�Ѿ�����
                    p.random=t.get(temp);           //ָ���ƺ��Լ��Ľڵ�
                }else{                          //û����ʵ����һ����������HashTable
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
