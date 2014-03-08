public class Driver {
    public static void main(String args[]) {
        Consumer c = new Consumer(); 
        Producer p = new Producer(); 
        
        c.start(); 
        p.start(); 
    }
}
