public class Producer extends Thread {
    public void run() {
        CriticalSection cs = CriticalSection.GetInstance(); 
        
        int i = 0; 
        while (i < 10) {
            try {
                cs.s1.acquire(); 
                cs.Produce('x'); 
                cs.s1.release(); 
                cs.s2.release(); 
            
                Thread.sleep(1000); 
            }
            catch (InterruptedException e) {
                System.exit(1);  
            }
            
            i++; 
        }
    }
}
