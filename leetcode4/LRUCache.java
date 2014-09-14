public class LRUCache {
    private class Node {
        int key; 
        int val;
        Node prev; 
        Node next; 
        Node(int key, int val) {
            this.key = key; 
            this.val = val; 
        }
    }
    
    private int capacity; 
    private int size; 
    private Map<Integer, Node> m = new HashMap<Integer, Node>(); 
    private Node head = null; 
    private Node tail = null; 
    
    public LRUCache(int capacity) {
        this.capacity = capacity; 
    }
    
    public int get(int key) {
        // Does not exists
        if (!m.containsKey(key) || m.get(key) == null) {
            return -1; 
        }
        
        // Exists, return its value and promotes to head 
        Node node = m.get(key); 
        int result = node.val; 
        
        if (node != head) {
            if (node == tail) {
                tail = node.prev; 
            }
            
            if (node.next != null) {
                node.next.prev = node.prev; 
            }
            
            if (node.prev != null) {
                node.prev.next = node.next; 
            }
            
            node.prev = null; 
            node.next = head; 
            head.prev = node; 
            head = node; 
        }
        
        return result; 
    }
    
    public void set(int key, int value) {
        // Key exists 
        if (m.containsKey(key) && m.get(key) != null) {
            Node node = m.get(key);
            node.val = value; 
            
            if (node != head) {
                if (node == tail) {
                    tail = node.prev; 
                }
                
                if (node.next != null) {
                    node.next.prev = node.prev; 
                }
                
                if (node.prev != null) {
                    node.prev.next = node.next; 
                }
                
                node.prev = null; 
                node.next = head; 
                head.prev = node; 
                head = node; 
            }
        } else {  // Key does not exist
            Node node = new Node(key, value); 
            
            // Full 
            if (size == capacity) {
                if (tail != null) {
                    int tailKey = tail.key; 
                    m.put(tailKey, null); 
                    tail = tail.prev; 
                    
                    if (tail == null) {
                        head = null; 
                    } else {
                        tail.next = null; 
                    }
                    
                    if (head == null) {
                        head = node; 
                        tail = node; 
                    } else {
                        node.next = head; 
                        head.prev = node; 
                        head = node; 
                    }
                    
                    m.put(key, node); 
                }
            } else {  // Not full
                if (head == null) {  // Insert first node
                    head = node; 
                    tail = node; 
                } else {
                    node.next = head; 
                    head.prev = node; 
                    head = node; 
                }
                
                m.put(key, node);
                size++; 
            }
        }
    }
}
