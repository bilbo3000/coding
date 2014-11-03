import java.util.*; 
import java.lang.*; 

public class Time {
	public String whatTime(int seconds) {
		int h = 0; 
		int m = 0; 
		int s = 0; 
		
		while (seconds >= 3600) {
			h++; 
			seconds -= 3600; 
		}
		
		while (seconds >= 60) {
			m++; 
			seconds -= 60; 
		}
		
		while (seconds > 0) {
			s++; 
			seconds--; 
		}
		
		return Integer.toString(h) + ":" + Integer.toString(m) + ":" + Integer.toString(s); 
	}
}
