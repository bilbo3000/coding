/**
 * Implement LRU cache. 
 * Use doubly-linked list to simulate the cache. Also use a map to map key to node to avoid 
 * traverse the list to determine whether a key is in the list. 
 */ 
public class LRUCache {
    class Node {
        int key; 
        int val; 
        Node next; 
        Node prev; 
        
        Node(int key, int value) {
            this.key = key; 
            this.val = value; 
        }
    }
    
    private int size = 0; 
    private int cap = 0; 
    private Node head = null; 
    private Node tail = null; 
    private Map<Integer, Node> m = new HashMap<>(); 
    
    public LRUCache(int capacity) {
        this.cap = capacity; 
    }
    
    public int get(int key) {
        if (size == 0) {
            return -1; 
        }
        
        if (!m.containsKey(key) ) {
            return -1; 
        }
        
        Node curr = m.get(key); 
        
        if (curr == head) {
            return head.val; 
        }
        
        if (curr == tail) {
            tail = curr.prev; 
        } else {
            curr.next.prev = curr.prev;
        }
        
        curr.prev.next = curr.next; 
        curr.next = head; 
        head.prev = curr; 
        head = curr; 
        head.prev = null; 
        
        return head.val; 
    }
    
    public void set(int key, int value) {
        if (m.containsKey(key)) {
            Node curr = m.get(key);
            curr.val = value; 
            
            if (curr != head) {
                if (curr == tail) {
                    tail = curr.prev; 
                } else {
                    curr.next.prev = curr.prev;
                }
                
                curr.prev.next = curr.next; 
                curr.next = head; 
                head.prev = curr; 
                head = curr; 
                head.prev = null; 
            }
        } else {
            Node node = new Node(key, value); 
            m.put(key, node); 
            
            if (size < cap) {
                if (head == null) {
                    head = node; 
                    tail = node; 
                    size = 1; 
                } else {
                    node.next = head; 
                    head.prev = node; 
                    head = node; 
                    size++; 
                }
            } else {
                if (tail != null) {
                    m.remove(tail.key);
                    tail = tail.prev; 
                    
                    if (tail != null) {
                        tail.next = null; 
                    } else {
                        head = null; 
                    }
                    
                    node.next = head; 
                    
                    if (head != null) {
                        head.prev = node; 
                    } else {
                        tail = node; 
                    }
                    
                    head = node; 
                }
            }
        }
    }
}
