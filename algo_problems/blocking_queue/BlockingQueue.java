public class BlockingQueue {
    public static final int max = 3; 
    private int[] arr = new int[max]; 
    private int front;   // Always points to first element
    private int back;    // Always points to last element
    private int size;    // Number of elements in the queue
    
    BlockingQueue() {
        front = -1; 
        back = -1; 
        for (int i = 0; i < max; i++) {
            arr[i] = -1; 
        }
    }
    
    public synchronized void Enqueue(int x) {
        if (back == -1) {  // Insert first element 
            back++; 
            front++; 
            arr[back] = x; 
            size++; 
            return; 
        }
        
        if (size == 0) {  // Queue is empty
            arr[front] = x; 
            back = (back + 1) % max; 
            size++; 
            return; 
        }
        
        if (size == max) {  // Queue is full
            System.out.println("Enqueue failed. Queue is full.");  
            return; 
        }
        
        back = (back + 1) % max; 
        arr[back] = x;
        size++; 
        
        return; 
    }
    
    public synchronized int Dequeue() {
        if (size == 0) {
            System.out.println("Dequeue failed. Queue is empty."); 
            return -1; 
        }
        
        int result = arr[front]; 
        front = (front + 1) % max; 
        size--; 
        return result; 
    }
    
    public static void main(String args[]) {
        BlockingQueue q = new BlockingQueue(); 
        q.Enqueue(1);
        q.Enqueue(2);
        q.Enqueue(3);   
        q.Dequeue(); 
        q.Dequeue(); 
        q.Enqueue(4); 
        System.out.println(q.Dequeue());  
        System.out.println(q.Dequeue());  
    }
}
