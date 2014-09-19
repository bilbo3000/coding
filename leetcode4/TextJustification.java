public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>(); 
        List<String> currLine = new ArrayList<String>(); 
        int currLen = 0; 
        
        if (L == 0) {
            result.add("");
            return result; 
        }
        
        for (String word : words) {
            if (currLen == 0) {
                currLine.add(word); 
                currLen = word.length(); 
            } else if (currLen + 1 + word.length() <= L) {
                currLine.add(word); 
                currLen = currLen + 1 + word.length(); 
            } else {  // Cannot fit into current line 
                int numOfSpace = L - currLen;
                int numOfSpaceInBetween = 0;
                int numOfSpaceRemaining = 0; 
                
                if (currLine.size() == 1) {
                    String line = currLine.get(0); 
                    
                    for (int i = 0; i < numOfSpace; i++) {
                        line = line + " "; 
                    }
                    
                    result.add(line); 
                } else {
                    numOfSpaceInBetween = numOfSpace / (currLine.size() - 1);
                    numOfSpaceRemaining = numOfSpace - numOfSpaceInBetween * (currLine.size() - 1);
                    
                    String line = currLine.get(0); 
                    
                    for (int i = 1; i < currLine.size(); i++) {
                        line = line + " "; 
                        
                        for (int j = 0; j < numOfSpaceInBetween; j++) {
                            line = line + " "; 
                        }
                        
                        if (numOfSpaceRemaining > 0) {
                            line = line + " "; 
                            numOfSpaceRemaining--; 
                        }
                        
                        line = line + currLine.get(i); 
                    }
                    
                    result.add(line); 
                }
                
                currLine.clear(); 
                currLine.add(word); 
                currLen = word.length(); 
            }
        }
        
        if (currLine.size() != 0) {
            int numOfSpace = L - currLen; 
            String line = currLine.get(0); 
            
            for (int i = 1; i < currLine.size(); i++) {
                line = line + " " + currLine.get(i); 
            }
            
            for (int i = 0; i < numOfSpace; i++) {
                line += " "; 
            }
            
            result.add(line); 
        }
        
        return result; 
    }
}
