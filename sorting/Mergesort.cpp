#include <iostream> 
#include <cmath> 
#include <fstream> 
#include <stdlib.h>

#define  MAX  100

using namespace std;  
    
// Merge sort 
void Mergesort(int a[], int n);

// Merge sort merge
void Merge(int b[], int c[], int a[], int size_b, int size_c, int size); 

// Print Array 
void PrintArray(int a[], int n); 

// Test driver 
int main() {
    int arr[MAX]; 
    int i = 0; 
    
    string inputPath = "data.txt"; 
    ifstream inputFileStream(inputPath.c_str());
    string line; 
    
    while(getline(inputFileStream, line)) {
        arr[i] = atoi(line.c_str()); 
        i++; 
    } 
    
    PrintArray(arr, i); 
    
    Mergesort(arr, i); 
    
    PrintArray(arr, i); 
}

void Mergesort(int a[], int size){
    if (size > 1) {
        int size_b = floor(size / 2); 
        int size_c = size - size_b;  
        
        int b[size_b]; 
        int c[size_c]; 
        
        for (int i = 0; i < size_b; i++) {
            b[i] = a[i]; 
        }
        
        for (int j = 0; j < size_c; j++) {
            c[j] = a[size_b + j]; 
        }
        
        // Merge sort two sub-array
        Mergesort(b, size_b);
        Mergesort(c, size_c); 
        
        // Merge
        Merge(b, c, a, size_b, size_c, size);  
    }
}

void Merge(int b[], int c[], int a[], int size_b, int size_c, int size) {
    int i = 0;   // Current element to be inserted in b
    int j = 0;   // Current element to be inserted in c
    int k = 0;   // First empty spot in a
    
    while (i < size_b && j < size_c) {
        if (b[i] < c[j]) {
            a[k] = b[i]; 
            i++; 
        }
        else {
            a[k] = c[j]; 
            j++; 
        }
        
        k++; 
    }
    
    if (i == size_b) {  // Done with b, copy rest of c
        for (int n = j; n < size_c; n++) {
            a[k] = c[n]; 
            k++; 
        }
    }
    else {  // Done with c, copy rest of b
        for (int m = i; m < size_b; m++) {
            a[k] = b[m]; 
            k++; 
        }
    }
} 

void PrintArray(int a[], int n) {
    for (int i = 0; i < n; i++) {
        cout << a[i] << " "; 
    }
    
    cout << endl; 
}
