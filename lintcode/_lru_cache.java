public class Solution {
    class Node {
        int key; 
        int val; 
        
        Node(int key, int val) {
            this.key = key; 
            this.val = val; 
        }
        
        Node prev; 
        Node next; 
    }
    
    private int cap; 
    private Node head, tail; 
    private Map<Integer, Node> m = new HashMap<>();  

    // @param capacity, an integer
    public Solution(int capacity) {
        this.cap = capacity; 
    }

    // @return an integer
    public int get(int key) {
        if (m.containsKey(key)) {
            Node node = m.get(key);
            
            if (head != node) {
                node.prev.next = node.next; 
                
                if (node.next != null) {
                    node.next.prev = node.prev; 
                } else {
                    tail = node.prev; 
                }
                
                node.prev = null; 
                node.next = head; 
                head.prev = node; 
                head = node;
            }
            
            return node.val; 
        } else {
            return -1; 
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (m.containsKey(key)) {
            Node node = m.get(key);
            node.val = value; 
            
            if (node != head) {
                node.prev.next = node.next; 
                
                if (node.next != null) {
                    node.next.prev = node.prev; 
                } else {
                    tail = node.prev; 
                }
                
                node.prev = null; 
                node.next = head; 
                head.prev = node; 
                head = node; 
            }
        } else {
            if (m.size() < cap) {
                // Less than capacity 
                Node node = new Node(key, value);
                m.put(key, node);
                node.next = head; 
                
                if (head != null) {
                    head.prev = node; 
                } else {
                    tail = node; 
                }
                
                head = node; 
            } else {
                // Invalidate tail 
                if (tail != null) {
                    int tailKey = tail.key; 
                    m.remove(tailKey);
                    tail = tail.prev; 
                    
                    if (tail != null) {
                        tail.next = null; 
                    } else {
                        head = null; 
                    }
                }
                
                // Add new node
                Node node = new Node(key, value);
                m.put(key, node);
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
