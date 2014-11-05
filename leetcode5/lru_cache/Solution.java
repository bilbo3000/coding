public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int x, int y) { key = x; val = y; }
    }

    private int capacity = 0;
    private int size = 0;
    private Map<Integer, Node> m = new HashMap<Integer, Node>();
    private Node head = null;
    private Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
//        Node lala = head;
//
//        while (lala != null) {
//            System.out.print("(" + lala.key + ", " + lala.val + ")");
//            lala = lala.next;
//        }
        if (!m.containsKey(key) || m.get(key) == null) {
            return -1;
        }

        Node node = m.get(key);
        int result = node.val;

        // Update position 
        if (node != head) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }

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

        return result;
    }

    public void set(int key, int value) {
//        Node lala = head;
//
//        while (lala != null) {
//            System.out.print("(" + lala.key + ", " + lala.val + ")");
//            lala = lala.next;
//        }
        if (!m.containsKey(key) || m.get(key) == null) {
            Node node = new Node(key, value);
            m.put(key, node);

            if (size < capacity) {
                size++;

                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    node.next = head;
                    head.prev = node;
                    head = node;
                }
            } else {
                // Kick one out
                if (tail != null && m.containsKey(tail.key)) {
                    m.put(tail.key, null);

                    if (tail.prev != null) {
                        tail.prev.next = null;
                        tail = tail.prev; 
                    } else {
                        head = null;
                        tail = null;
                    }

                    node.next = head;

                    if (head != null) {
                        head.prev = node;
                    }

                    head = node;

                    if (tail == null) {
                        tail = node;
                    }
                }
            }
        } else {  // contains key
            Node temp = m.get(key);
            temp.val = value;

            if (temp != head) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }

                temp.prev = null;
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
        }
    }
}
