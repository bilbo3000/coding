#include <iostream> 

using namespace std; 

void EditDistance(string p, string t) {
    int sizep = p.size(); 
    int sizet = t.size(); 
    
    // T[i][j]: cost of convert first jth text to first ith pattern
    int T[sizep + 1][sizet + 1]; 
    
    // O[i][j]: last operation of converting first jth text to first ith pattern
    char O[sizep + 1][sizet + 2]; 
    
    // Initialization 
    T[0][0] = 0; 
    O[0][0] = 'N'; 
    
    for (int i = 1; i < sizep + 1; i++) {
        T[i][0] = T[i - 1][0] + 1; 
        O[i][0] = 'I'; 
    }
    
    for (int j = 1; j < sizet + 1; j++) {
        T[0][j] = T[0][j - 1] + 1; 
        O[0][j] = 'D'; 
    }
    
    for (int i = 1; i < sizep + 1; i++) {
        for (int j = 1; j < sizet + 1; j++) {
            // DO NOT mess up index with th!!!
            if (p[i - 1] == t[j - 1]) {
                T[i][j] = T[i - 1][j - 1];  // No operation needed
                O[i][j] = 'N'; 
            }
            else {
                int subCost = T[i - 1][j - 1] + 1; 
                int insertCost = T[i - 1][j] + 1;
                int deleteCost = T[i][j - 1] + 1; 
                
                int minCost = subCost; 
                char operation = 'S';
                
                if (insertCost < minCost) {
                    minCost = insertCost; 
                    operation = 'I'; 
                }  
                
                if (deleteCost < minCost) {
                    minCost = deleteCost; 
                    operation = 'D'; 
                }
                
                T[i][j] = minCost; 
                O[i][j] = operation; 
            }
        }
    }
    
    cout << "Edit distance: " << T[sizep][sizet] << endl; 
    
    int m = sizep; 
    int n = sizet; 
    
    while (m >= 0 && n >= 0) {
        cout << O[m][n] << " ";
        
        if (O[m][n] == 'I') {
            cout << p[m - 1] << ","; 
            m--; 
        }
        else if(O[m][n] == 'D') {
            cout << t[n - 1] << ","; 
            n--; 
        }
        else if (O[m][n] == 'S'){
            cout << p[m - 1] << ","; 
            m--; 
            n--; 
        } 
        else{
            m--; 
            n--; 
        }
    }
}

// Test driver 
int main() {
    string p = "hello"; 
    string t = "ohwlalow"; 
    
    EditDistance(p, t);
     
}
