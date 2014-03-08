import java.lang.Math; 

public class BadSubstring{
	public long howMany(int length) {
		if (length == 0) return 1; 
		if (length == 1) return 3; 
		
		long[] T = new long[length + 1]; 
		T[0] = 0; 
		T[1] = 0; 
		
		for (int i = 2; i <= length; i++) {
			long p = (long) Math.pow(3, i - 2); 
			T[i] = T[i - 1] * 3 + p - T[i - 2]; 
		}
		
		long total = (long) Math.pow(3, length); 
		return total - T[length]; 
	}
}
