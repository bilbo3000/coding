#include <iostream> 
#include <fstream> 
#include <stdlib.h> 

#define DIGITS 2
#define MAX 100

using namespace std; 

void CountingSort(int a[], int digit[], int size) { 
    int ca[MAX]; 
    
    for (int i = 0; i < MAX; i++) {
        ca[i] = 0; 
    }
    
    for (int i = 0; i < size; i++) {
        ca[digit[i]]++; 
    }
    
    int prev = 0; 
    
    for (int i = 0; i < MAX; i++) {
        if (ca[i] != 0) {
            ca[i] = ca[i] + prev; 
            prev = ca[i]; 
        }
    }
    
    int out[size]; 
    for (int i = size - 1; i >= 0; i--) {
        int index = ca[digit[i]] - 1;
        ca[digit[i]]--; 
        out[index] = a[i]; 
    }
    
    for (int i = 0; i < size; i++) {
        a[i] = out[i]; 
    }
}

void RadixSort(int a[], int size) {
    int temp[size]; 
    
    for (int i = 1; i <= DIGITS; i++) {
        for (int j = 0; j < size; j++) {
            int item = a[j]; 
            
            int k = i; 
            while (k > 0) {
                if (item == 0) {
                    temp[j] = 0; 
                }
                else {
                    temp[j] = item % 10; 
                    item = item / 10; 
                }
                
                k--; 
            }
        }
        
        CountingSort(a, temp, size); 
    }
}

// Test driver 
int main() {
    string inputPath = "data.txt";
    ifstream inputStream(inputPath.c_str());
    string line; 
    int i = 0; 
    int a[MAX]; 
    
    while(getline(inputStream, line)) {
        a[i] = atoi(line.c_str()); 
        i++; 
    }
    
    RadixSort(a, i);
    
    for (int j = 0; j < i; j++) {
        cout << a[j] << " "; 
    } 
    
    cout << endl; 
    return 0; 
}
