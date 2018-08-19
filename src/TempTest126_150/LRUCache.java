package TempTest126_150;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	
	public static void main(String args[]){
		
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
//		cache.get(1);       // returns 1
		System.out.println(cache.get(1));
		cache.put(3, 3);    // evicts key 2
//		cache.get(2);       // returns -1 (not found)
		System.out.println(cache.get(2));
		cache.put(4, 4);    // evicts key 1
//		cache.get(1);       // returns -1 (not found)
		System.out.println(cache.get(1));
//		cache.get(3);       // returns 3
		System.out.println(cache.get(3));
//		cache.get(4);       // returns 4
		System.out.println(cache.get(4));
		
	}
	
	
	int cap;        //����
    HashMap<Integer, Integer> map;      //�����洢��ֵ��
    LinkedList<Integer> list;     //keyֵ��ʹ���������

    public LRUCache(int capacity) {
        cap=capacity;
        list=new LinkedList<>();
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            list.remove((Object)key);   //����ʹ�����
            list.add(key);
            return map.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){       //�����Ѵ��ڵļ�
            list.remove((Object)key);       //����ʹ�����
            list.add(key);
            map.put(key,value);
        }else{
            if(map.size()==cap){        //�Ѿ�����
                map.remove(list.removeFirst());     //����ʹ�����ɾ�����ʹ�õ�
            }
            map.put(key,value);
            list.add(key);      //����ʹ�����
        }
        
    }

}
