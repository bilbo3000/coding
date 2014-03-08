public class LRUCache {
    class Node {
        int key; 
        int val; 
        Node prev; 
        Node next; 
        
        Node(int key, int val) {
            this.key = key; 
            this.val = val; 
        }
    }
    
    int cap; 
    Map<Integer, Node> m = new HashMap<Integer, Node>();
    Node head = null; 
    Node tail = null; 
    int cnt; 
    
    public LRUCache(int capacity) {
        this.cap = capacity; 
    }
    
    public int get(int key) {
        if (!m.containsKey(key)) {
            return -1; 
        }
        
        Node node = m.get(key);
        int result = node.val; 
        
        if (node != head) {
            moveToMRU(node); 
        }
        
        return result; 
    }
    
    public void set(int key, int value) {
        if (!m.containsKey(key)) {
            Node node = new Node(key, value);
            m.put(key, node); 
            
            if (head == null) {
                head = node; 
                tail = node; 
            }
            else {
                node.next = head; 
                head.prev = node; 
                head = node; 
            }
            
            cnt++; 
            
            if (cnt > cap) {
                m.remove(tail.key); 
                tail = tail.prev; 
                
                if (tail != null) {
                    tail.next = null; 
                }
                
                cnt--; 
            }
        }
        else {  // Already exist 
            Node node = m.get(key); 
            node.val = value; 
            
            if (node != head) {
                moveToMRU(node); 
            }
        }
    }
    
    private void moveToMRU(Node node) {
        if (node == tail) {
            tail = node.prev; 
        }
        
        node.prev.next = node.next; 
        
        if (node.next != null) {
            node.next.prev = node.prev; 
        }
        
        node.next = head; 
        node.prev = null; 
        head.prev = node; 
        head = node;        
    }
}
