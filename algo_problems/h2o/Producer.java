public class Producer extends Thread {
    public void run() {
        CriticalSection cs = CriticalSection.GetInstance(); 
        int i = 0; 
        
        try {
            while (i < 20) {
                cs.s1.acquire();
                cs.Produce('H'); 
                cs.s1.release(); 
                
                if (i != 0 && (i % 2) != 0) {
                    cs.s2.release(); 
                }
                
                i++; 
                Thread.sleep(1000); 
            }
        } catch (Exception e) {
            System.exit(1); 
        }
    }
}
