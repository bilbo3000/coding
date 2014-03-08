#include <iostream> 
#include <cmath>
#include <string> 
#include <fstream> 
#include <stdlib.h> 

#define  MAX  100 

using namespace std; 

void Heapsort(int a[], int size);
void ConstructHeap(int a[], int size); 
void Heapify(int a[], int n, int size); 
void PrintArray(int a[], int size); 
void Swap(int &a, int &b); 

// Test driver 
int main() {
    int arr[MAX]; 
    string inputFilePath("data.txt");
    ifstream inputFileStream(inputFilePath.c_str());
    string line; 
    int i = 0; 
    
    while (getline(inputFileStream, line)) {
        arr[i] = atoi(line.c_str()); 
        i = i + 1; 
    }
    
    inputFileStream.close();   
    
    Heapsort(arr, i);
    
    PrintArray(arr, i);
      
    return 0; 
}

// Heapsort 
void Heapsort(int a[], int size) {
    ConstructHeap(a, size);
    
    while (size > 1) {
        swap(a[0], a[size - 1]);  
        size--; 
        Heapify(a, 0, size);
    } 
}

// Construct the heap 
void ConstructHeap(int a[], int size) {
    int lastParentIndex = floor((size - 1) / 2); 
    
    for (int i = lastParentIndex; i >=0; i--) {
        Heapify(a, i, size); 
    }
}

// Heapify the heap at given node 
void Heapify(int a[], int n, int size) {
    int curr = n; 
    int lastIndex = size - 1; 
    bool isHeap = false; 
    
    while (!isHeap && (2 * curr + 1) <= lastIndex) {  // Has left child 
        int maxChildIndex = 2 * curr + 1; 
        if ((maxChildIndex + 1) <= lastIndex && (a[maxChildIndex] < a[maxChildIndex + 1])) {
            maxChildIndex++; 
        }
        
        if (a[curr] < a[maxChildIndex]) {
            swap(a[curr], a[maxChildIndex]);
            curr = maxChildIndex;  
        }
        else {
            isHeap = true; 
        }
    }
}

// Print out the array 
void PrintArray(int a[], int size) {
    for (int i = 0; i < size; i++) {
        cout << a[i] << " "; 
    }
    
    cout << endl; 
}

// Swap two elements 
void Swap(int &a, int &b) {
    int temp = a; 
    a = b; 
    b = temp; 
} 

