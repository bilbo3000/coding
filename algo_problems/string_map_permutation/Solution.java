import java.util.*;
public class Solution {
	private String s = ""; 
	private Map<Character, ArrayList<Character>> m = new HashMap<Character, ArrayList<Character>>(); 
	private ArrayList<String> result = new ArrayList<String>();

	ArrayList<String> mapPerm(String s, Map<Character, ArrayList<Character>> m) {
		this.s = s; 
		this.m = m; 
		helper("", 0); 
		
		return result; 
	}
	
	private void helper(String curr, int index) {
		if (index == s.length()) {
			result.add(curr);
			return; 
		}
		
		char key = s.charAt(index); 
		ArrayList<Character> l = m.get(key); 
		
		for (Character c : l) {
			helper(curr + c, index + 1); 
		}
	}
}
