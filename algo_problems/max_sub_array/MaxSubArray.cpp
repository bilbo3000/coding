#include <iostream> 

using namespace std; 

void MaxSubArray(int a[], int n) {
    if (n == 0) {
        return; 
    }
    
    int maxVal = 0; 
    int maxStart = 0; 
    int maxEnd = 0; 
    
    for (int i = 0; i < n; i++) {
        int currSum = 0; 
        for (int j = i; j < n; j++) {
            currSum += a[j]; 
            if (currSum > maxVal) {
                maxVal = currSum; 
                maxStart = i; 
                maxEnd = j; 
            }
        }
    }
    
    cout << "max: " << maxVal << endl; 
    
    while (maxStart <= maxEnd) {
        cout << a[maxStart] << " "; 
        maxStart++; 
    } 
    
    return; 
}

// Test driver 
int main() {
    int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; 
    MaxSubArray(a, 9); 

    return 0; 
}
