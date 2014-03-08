import java.util.HashMap; 
import java.util.Set; 

public class NestedHashMap {  
    public void PrintHashMap(HashMap hashMap) {
        Set<String> keySet = hashMap.keySet(); 
        String[] keyArray = keySet.toArray(new String[0]); 
        
        for (int i = 0; i < keyArray.length; i++) {
            System.out.println(keyArray[i]); 
            if (hashMap.get(keyArray[i]) != null) {
                PrintHashMap((HashMap)hashMap.get(keyArray[i])); 
            }
        }
    }
    
    public static void main(String args[]) {
        HashMap hashMap = new HashMap();
        HashMap tempMap = new HashMap(); 
        
        tempMap.put("aa", null);
        tempMap.put("bb", null); 
        tempMap.put("cc", null); 
        
        hashMap.put("a", null);
        hashMap.put("b", tempMap); 
        hashMap.put("c", null);
        
        NestedHashMap nestedHashMap = new NestedHashMap(); 
        nestedHashMap.PrintHashMap(hashMap);   
    }
}
