import java.util.concurrent.Semaphore; 

public class CriticalSection {
    private static CriticalSection instance = new CriticalSection(); 
    
    private CriticalSection() {}; 
    
    public static CriticalSection GetInstance() {
        return instance; 
    }
    
    private static final int max = 1000; 
    private char [] arr = new char[max]; 
    private int front = 0; 
    private int back = -1;   // Points to the first element
    private int size = 0;   // Points to the last element 
    
    // Make sure one thread access critical section at a time
    public final Semaphore s1 = new Semaphore(1, true);
    
    // Make sure producer access first
    public final Semaphore s2 = new Semaphore(0, true); 
    
    public char Consume() {
        char result = arr[front]; 
        front++; 
        size--;   
        return result;
    }
    
    public void Produce(char x) {
        back++; 
        arr[back] = x; 
        size++; 
    }
}
