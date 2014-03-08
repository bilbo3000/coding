public class Consumer extends Thread {
    public void run() {
        CriticalSection cs = CriticalSection.GetInstance(); 
        int i = 0; 
        try {
            while (i < 10) {
                cs.s2.acquire(); 
                cs.s1.acquire(); 
                
                cs.s1.release(); 
                System.out.println(cs.Consume() + "-O-" + cs.Consume()); 
                i++; 
                Thread.sleep(1000); 
            }
        } catch (Exception e) {
            System.exit(1); 
        }
    }
}
