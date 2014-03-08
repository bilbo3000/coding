public class Consumer extends Thread {
    public void run() {
        CriticalSection cs = CriticalSection.GetInstance(); 
        int i = 0;
        
        while (i < 10) {
            try{
                cs.s2.acquire(); 
                cs.s1.acquire(); 
                System.out.println(cs.Consume()); 
                cs.s1.release();  
            
                Thread.sleep(500); 
            }
            catch (InterruptedException e) {
                System.exit(1); 
            }
            i++; 
        }
    }
}
