/**
 * Find the largest number as string by arranging an array of elements. 
 * The idea was to implement a comparator to sort the input array as strings. That works because for 
 * two numbers, the relative position will be fixed. Given the same stuff before, after and in between, 
 * the larger relative order will always be larger. That's why the comparator works. 
 * Don't forget to skip all the leading zeros in the final result. 
 * Reference: http://www.programcreek.com/2014/02/leetcode-largest-number-java/
 */ 
public class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>(); 
        
        for (int item : nums) {
            list.add(String.valueOf(item));
        }
        
        Collections.sort(list, new Comparator<String>(){
            @Override 
            public int compare(String s1, String s2) {
                long n1 = Long.parseLong(s1 + s2);
                long n2 = Long.parseLong(s2 + s1);
                
                if (n1 < n2) {
                    return 1; 
                } else if (n1 > n2) {
                    return -1; 
                } else {
                    return 0; 
                }
            }
        });
        
        StringBuilder sb = new StringBuilder(); 
        
        for (String item : list) {
            sb.append(item);
        }
        
        int i = 0; 
        
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++; 
        }
        
        if (i == sb.length()) {
            return "0";
        }
        
        return sb.substring(i); 
    }
}
