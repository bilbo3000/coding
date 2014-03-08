#include <iostream> 

using namespace std; 

bool HasInfluencer(int **mat, int x, int y){ 
    if (x == 0 || y == 0) {
        return false; 
    }
    
    for (int i = 0; i < x; i++) {
        bool rowSat = true; 
        bool colSat = true; 
        
        for (int m = 0; m < y; m++) {
            if (i != m && mat[i][m] != 1) {
                rowSat = false; 
                break;  
            }
        }
        
        if (rowSat) {
            for (int n = 0; n < y; n++) {
                if (mat[n][i] != 0) {
                    colSat = false; 
                    break; 
                }
            }
        }
        
        if (rowSat && colSat) {
            cout << "Influencer: " << i << endl; 
            return true; 
        }
    }
    
    return false; 
}

// Test driver 
int main() {
    int ** mat = new int*[4];
    
    for (int i = 0; i < 4; i++) {
        mat[i] = new int[4]; 
    } 
    
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            mat[i][j] = 0; 
        }
    }
    
    mat[2][0] = 1; 
    mat[2][1] = 1; 
    mat[2][3] = 1; 
    
    if (HasInfluencer(mat, 4, 4)) {
        cout << 1 << endl; 
    } 
    else {
        cout << 0 << endl; 
    }
    
    return 0; 
}
