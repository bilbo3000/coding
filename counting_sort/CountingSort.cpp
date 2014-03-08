#include <iostream> 

#define  MAX  100

using namespace std; 

int * CountingSort(int a[], int size) {
    int ca[MAX];  // Counting array, assume all elements are between 0 and 99
    
    // Initialize counting array 
    for (int i = 0; i < MAX; i++) {
        ca[i] = 0;  
    }
    
    // Counter each element 
    for (int i = 0; i < size; i++) {
        ca[a[i]]++; 
    }
    
    // Calculate index 
    int prevCount = 0; 
    for (int i = 0; i < MAX; i++) {
        if (ca[i] != 0) {
            ca[i] += prevCount; 
            prevCount = ca[i]; 
        }
    }
    
    int * b = new int[size]; // Output array
    for (int i = size - 1; i >= 0; i--) {
        int index = ca[a[i]] - 1; 
        ca[a[i]]--; 
        b[index] = a[i]; 
    }
    
    return b; 
} 

// Test driver
int main() {
    int a[] = {2, 5, 3, 0, 2, 3, 0, 3}; 
    int * b = CountingSort(a, 8); 
    
    for (int i = 0; i < 8; i++) {
        cout << b[i] << " "; 
    }
    
    cout << endl; 
    return 0; 
}
