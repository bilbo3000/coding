public class LRUCache {
    class Node {
        int key; 
        int val = 0; 
        Node next = null; 
        Node prev = null; 
        Node(int key, int val) {
            this.key = key; 
            this.val = val; 
        }
    }
    
    private int max = 0;
    private int cnt = 0; 
    private Map<Integer, Node> m = new HashMap<Integer, Node>(); 
    private Node head = null; 
    private Node tail = null; 
    
    public LRUCache(int capacity) {
        this.max = capacity; 
    }
    
    public int get(int key) {
        if (!m.containsKey(key)) return -1; 
        
        Node n = m.get(key); 
        int result = n.val; 
        
        if (n != head) {
            n.prev.next = n.next; 
            
            if (n.next != null) {
                n.next.prev = n.prev; 
            }
            else {  // Move tail 
                tail = n.prev; 
            }
            
            n.prev = null; 
            n.next = head; 
            head.prev = n; 
            head = n; 
        }

        return result; 
    }
    
    public void set(int key, int value) {
        if (m.containsKey(key)) {
            Node n = m.get(key); 
            n.val = value; 
            
            if (n != head) {
                n.prev.next = n.next; 
                
                if (n.next != null) {
                    n.next.prev = n.prev; 
                }
                else {
                    tail = n.prev; 
                }
                
                n.next = head; 
                n.prev = null; 
                head.prev = n; 
                head = n; 
            }
        }
        else {
            Node n = new Node(key, value); 
            m.put(key, n); 
            
            if (head != null) {
                n.next = head; 
                head.prev = n; 
                head = n; 
            }
            else {
                head = n; 
                tail = n; 
            }
                
            cnt++; 
            
            if (cnt > max) {
                if (tail != null) {
                    m.remove(tail.key); 
                    tail = tail.prev; 
                    
                    if (tail != null) {
                        tail.next = null; 
                    }
                    
                    cnt--;
                }
            }
        }
    }
}
