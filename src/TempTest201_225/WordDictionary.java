package TempTest201_225;

import java.util.Hashtable;

class TrieNode{
    boolean isword;
    Hashtable<Character, TrieNode> next;
    public TrieNode(){
    	next=new Hashtable<>();
    }
}

public class WordDictionary {
	
	public static void main(String args[]){
    	WordDictionary wd=new WordDictionary();
    	wd.addWord("bad");
    	wd.addWord("dad");
    	wd.addWord("mad");
    	System.out.println(wd.search("pad"));
    	System.out.println(wd.search("bad"));
    	System.out.println(wd.search(".ad"));
    	System.out.println(wd.search("b.."));
    }
	
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode p=root;
        for(char c:word.toCharArray()){
            if(p.next.containsKey(c)){
            	p=p.next.get(c);
            }else{
            	TrieNode t=new TrieNode();
            	p.next.put(c, t);
            	p=p.next.get(c);
            }
        }
        p.isword=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return subSearch(word, root);
    }
    public boolean subSearch(String subWord, TrieNode t){
    	if(subWord.length()==0)return t.isword;
    	
    	char c=subWord.charAt(0);
    	if(c=='.'){
    		for(TrieNode tt:t.next.values()){
    			if(subSearch(subWord.substring(1), tt) && tt.isword)return true;
    		}
    	}else{
    		if(t.next.containsKey(c))return subSearch(subWord.substring(1), t.next.get(c));
    	}
    	return false;
    } 
}
