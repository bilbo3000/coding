#include <iostream> 

#define  MAX  3  // Assume there are three digits at most for each number 

using namespace std; 

void RadixSort(int a[], int size);
void CountingSort(int a[], int size, int position);  

void RadixSort(int a[], int size) { 
    for (int i = 1; i <= MAX; i++) {
        CountingSort(a, size, i); 
    }
}

void CountingSort(int a[], int size, int position) {
    int temp[size];  // Array to store digits
    
    // Retrieve digits from input array at given position
    for (int i = 0; i < size; i++) { 
        int num = a[i];
        int digit = num % 10; 
        
        for (int j = 1; j < position; j++) {
            num = num / 10;  // Shift number
            digit = num % 10;  // Get last digit
        }
        
        temp[i] = digit; 
    } 
    
    int ca[10];  // Counting array to sort digits at given position
    
    // Initialize counting array 
    for (int i = 0; i < 10; i++) {
        ca[i] = 0; 
    }
    
    // Stable counting sort that digit
    for (int i = 0; i < size; i++) {
        ca[temp[i]]++; 
    }
    
    // Accumulate the index 
    int prev = ca[0]; 
    
    for (int i = 1; i < 10; i++) {
        if (ca[i] != 0) {
            ca[i] += prev; 
            prev = ca[i];
        }  
    }
    
    // Output to output array 
    int b[size];
    
    for (int i = size - 1; i >= 0; i--) {
        if (ca[temp[i]] > 0) {
            int index = ca[temp[i]] - 1; 
            ca[temp[i]]--; 
            b[index] = a[i]; 
        }
    } 
    
    for (int i = 0; i < size; i++) {
        a[i] = b[i]; 
    } 
} 

// Test driver
int main() {
    int a[] = {329, 457, 0, 657, 839, 436, 20, 720, 355}; 
    
    RadixSort(a, 9); 
    
    for (int i = 0; i < 9; i++) {
        cout << a[i] << " "; 
    }
    
    cout << endl; 
    
    return 0; 
}
