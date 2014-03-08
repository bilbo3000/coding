#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    string processLine(vector<string> lineWords, int L) {
        // Process current line 
        int wordCount = lineWords.size();  
        int wordLengthSum = 0; 
        for(int j = 0; j < wordCount; j++) {
            wordLengthSum += lineWords[j].size(); 
        } 
        int spaceCount = L - wordLengthSum; 
        string line = ""; 

        if (wordCount > 1) {
            int spaceInBetween = spaceCount / (wordCount - 1); 
            int extraSpace = spaceCount % (wordCount - 1); 
            
            int j = 0; 
            while(j < lineWords.size() - 1) {
                line += lineWords[j]; 
                for (int k = 0; k < spaceInBetween; k++) {
                    line += " "; 
                }
                
                if (extraSpace > 0) {
                    line += " "; 
                    extraSpace--; 
                }
                
                j++; 
            }
            
            line += lineWords[j];       
        }
        else {
            line += lineWords[0]; 
            for (int j = 0; j < spaceCount; j++) {
                line += " "; 
            }
        }
        
        return line; 
    }
    
    string processLastLine(vector<string> lineWords, int L) {
        int wordCount = lineWords.size();  
        int wordLengthSum = 0; 
        for(int j = 0; j < wordCount; j++) {
            wordLengthSum += lineWords[j].size(); 
        } 
        int spaceCount = L - wordLengthSum; 
        string line = "";
        
        for (int i = 0; i < wordCount; i++) {
            line += lineWords[i]; 
            if (spaceCount > 0) {
                line += " "; 
                spaceCount--; 
            }
        }
        
        while (spaceCount > 0) {
            line += " "; 
            spaceCount--; 
        }
        
        return line; 
    }
     
    vector<string> fullJustify(vector<string> &words, int L) {
        vector<string> result; 
        if (words.size() == 0 || L == 0) {
            result.push_back(""); 
            return result; 
        }
        
        vector<string> lineWords; 
        int lineLength = 0; 
        
        for (int i = 0; i < words.size(); i++) {
            int wordLength = words[i].size(); 
            
            if ((lineLength + wordLength) < L) {
                lineWords.push_back(words[i]);
                lineLength = lineLength + 1 + wordLength; 
            }
            else if ((lineLength + wordLength) == L) {
                lineWords.push_back(words[i]);
                lineLength = lineLength + wordLength;  
            }
            else {  // Current word cannot fit into current line
                // Finish up current line
                result.push_back(processLine(lineWords, L));
                 
                // Start a new line
                lineWords.clear(); 
                lineWords.push_back(words[i]);
                lineLength = wordLength;  
                if (lineLength < L) {
                    lineLength += 1; 
                }
            }
        }
        
        // Handle last line
        result.push_back(processLastLine(lineWords, L)); 
        
        return result; 
    }
};

// Test driver 
int main() {
    Solution sln; 
    vector<string> input; 
    /*
    input.push_back("This"); 
    input.push_back("is");
    input.push_back("an");
    input.push_back("example");
    input.push_back("of");
    input.push_back("text");
    input.push_back("justification.");
    */
    
    /*
    input.push_back("a"); 
    input.push_back("b"); 
    input.push_back("c"); 
    input.push_back("d"); 
    input.push_back("e"); 
    */
    
    /*
    input.push_back("What"); 
    input.push_back("must"); 
    input.push_back("be"); 
    input.push_back("shall"); 
    input.push_back("be."); 
    */
    
    input.push_back("Here"); 
    input.push_back("is"); 
    input.push_back("an"); 
    input.push_back("example"); 
    input.push_back("of"); 
    input.push_back("text"); 
    input.push_back("justification."); 
    
    vector<string> result = sln.fullJustify(input, 14); 
    
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << "|" << endl; 
    }
    return 0; 
}
