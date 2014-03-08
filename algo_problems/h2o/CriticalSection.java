import java.util.concurrent.Semaphore; 

public class CriticalSection {
    private static CriticalSection instance = new CriticalSection(); 
    
    private CriticalSection() {}
    
    public static CriticalSection GetInstance() {
        return instance; 
    }
    
    private char[] arr = new char[1000]; 
    private int front = 0; 
    private int back = -1; 
    private int size = 0;
    
    // One thread access critical at a time
    public final Semaphore s1 = new Semaphore(1, true);  
    
    // Consumer has to wait for two 'H'
    // Producer will release s2 only on even tries 
    public final Semaphore s2 = new Semaphore(0, true); 
    
    public void Produce(char x) {
        back++; 
        arr[back] = x;
        size++; 
    }
    
    public char Consume() {
        if (size > 0) {
            char result = arr[front]; 
            front++; 
            size--; 
            return result; 
        }
        else {
            return ' '; 
        }
    }
}
