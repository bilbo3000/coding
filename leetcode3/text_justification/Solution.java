public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>(); 
        ArrayList<String> line = new ArrayList<String>(); 
        int currLen = 0; 
        
        for (int i = 0; i < words.length; i++) {
            if (line.size() == 0) {
                line.add(words[i]);
                currLen += words[i].length(); 
            }
            else {
                if (currLen + 1 + words[i].length() <= L) {
                    line.add(words[i]); 
                    currLen += 1 + words[i].length(); 
                }
                else {
                    int lineSize = line.size(); 
                    
                    if (lineSize == 1) {
                        String temp = line.get(0); 
                        
                        for (int j = 0; j < L - currLen; j++) {
                            temp += " "; 
                        }
                        
                        result.add(temp); 
                    }
                    else {
                        int extraSpace = L - currLen; 
                        int spaceInBetween = extraSpace / (lineSize - 1); 
                        int remainder = extraSpace % (lineSize - 1); 
                        String temp = line.get(0); 
                        
                        for (int j = 1; j < lineSize; j++) {
                            temp += " "; 
                            
                            for (int k = 0; k < spaceInBetween; k++) {
                                temp += " "; 
                            }
                            
                            if (remainder > 0) {
                                temp += " "; 
                                remainder--; 
                            }
                            
                            temp += line.get(j); 
                        }
                        
                        result.add(temp); 
                    }
                    
                    line.clear(); 
                    line.add(words[i]); 
                    currLen = words[i].length(); 
                }
            }
        }
        
        if (line.size() != 0) {
            String temp = line.get(0);
            
            for (int i = 1; i < line.size(); i++) {
                temp += " " + line.get(i); 
            }
            
            int spaceCnt = L - temp.length(); 
            
            for (int i = 0; i < spaceCnt; i++) {
                temp += " "; 
            }
            
            result.add(temp); 
        }
        
        return result; 
    }
}
