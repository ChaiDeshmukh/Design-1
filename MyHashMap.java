package easyProblems;

public class MyHashMap {
	
    Node[] nodes;

    /** Initialize your data structure here. */
    public MyHashMap() {
         nodes = new Node[1000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node cursor = getElement(key);
        if(cursor.next == null)
        {
          Node node = new Node(key, value);
          cursor.next = node;  
        }
        cursor.next.value = value;

            
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node cursor = getElement(key);
        
        if(cursor.next == null)
            return -1;
        
        return cursor.next.value;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node cursor = getElement(key);
        if(cursor.next !=null)
        {
            cursor.next = cursor.next.next; 
        }
    }
    
    public int getIndex(int key)
    {
        return key % 1000;    // hashing function
    }
    
    public Node getElement(int key)
    {
        int index = getIndex(key);
        
        if(nodes[index] == null)
        {
            Node dummy = new Node(-1,-1);
            nodes[index] = dummy;
            return dummy;
        }
        
        //if index is not null then points to the linked list
        Node cursor = nodes[index];
        
        while(cursor.next != null && cursor.next.key !=key)
        {
            cursor = cursor.next;
        }
        return cursor;
    }
    
    
    class Node{
        int key, value;
        Node next;
    
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    
	public static void main(String[] args) {
		
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		hashMap.get(1);            // returns 1
		hashMap.get(3);            // returns -1 (not found)
		hashMap.put(2, 1);          // update the existing value
		hashMap.get(2);            // returns 1 
		hashMap.remove(2);          // remove the mapping for 2
		hashMap.get(2);            // returns -1 (not found) 


	}

}
