#include <iostream> 
#include <stack> 

using namespace std; 

void LongestIncreasingSequence(int a[], int size) {
    // T[i]: length of LIS ending with element a[i]
    int T[size]; 
    
    // D[i]: the index of the element immediately before a[i] in LIS
    int D[size]; 
    
    T[0] = 1; 
    D[0] = -1; 
    
    for (int i = 1; i < size; i++) {
        int maxLength = 0; 
        int prevIndex = -1; 
        
        for (int j = 0; j < i; j++) {
            if ((a[j] < a[i]) && (T[j] > maxLength)) {
                maxLength = T[j]; 
                prevIndex = j; 
            }
        }
        
        T[i] = maxLength + 1; 
        D[i] = prevIndex; 
    }
    
    int lis = 0; 
    int lisIndex = 0; 
    
    for (int i = 0; i < size; i++) {
        cout << T[i] << "," << D[i] << " "; 
        if (T[i] > lis) {
            lis = T[i]; 
            lisIndex = i; 
        }
    }
    
    cout << "Length of longest increase sequence: " << lis << endl; 
    cout << "Last element of LIS index: " << lisIndex << endl; 
    
    stack<int> s; 
    while(lisIndex >= 0) {
        s.push(a[lisIndex]); 
        lisIndex = D[lisIndex]; 
    }
    cout << s.size() << endl; 
    while (s.size() != 0) {
        int item = s.top(); 
        s.pop(); 
        cout << item << " "; 
    }
    
    cout << endl; 
}

// Test driver 
int main() {
    int a[] = {2, 4, 3, 5, 1, 7, 6, 9, 8}; 
    
    LongestIncreasingSequence(a, 9);
     
    return 0; 
}
