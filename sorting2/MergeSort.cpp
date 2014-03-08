#include <iostream> 
#include <fstream> 
#include <stdlib.h> 

#define MAX 100

using namespace std; 

void MergeSort(int arr[], int size);
void Merge(int a[], int b[], int c[], int sizea, int sizeb, int sizec);

// Merge sort 
void MergeSort(int arr[], int size) {
    if (size > 1) {
        int sizea = size / 2; 
        int sizeb = size - sizea; 
        int a[sizea]; 
        int b[sizeb]; 
        
        for (int i = 0; i < sizea; i++) {
            a[i] = arr[i]; 
        }
        
        for (int j = 0; j < sizeb; j++) {
            b[j] = arr[sizea + j]; 
        }
        
        MergeSort(a, sizea);
        MergeSort(b, sizeb);
        
        Merge(a, b, arr, sizea, sizeb, size);   
    }
}

void Merge(int a[], int b[], int c[], int sizea, int sizeb, int sizec) {
    int i = 0; 
    int j = 0; 
    int k = 0; 
    
    while (i < sizea && j < sizeb && k < sizec) {
        if (a[i] < b[j]) {
            c[k] = a[i]; 
            i++; 
            k++; 
        }
        else {
            c[k] = b[j]; 
            j++; 
            k++; 
        }
    }
    
    if (i == sizea) {  // a is done, copy rest of b
        while (j < sizeb && k < sizec) {
            c[k] = b[j];  
            j++; 
            k++;
        }
    }
    else {  // b is done, copy rest of a
        while (i < sizea && k < sizec) {
            c[k] = a[i]; 
            i++; 
            k++; 
        }
    }
}

// Test driver 
int main() {
    int arr[MAX]; 
    string inputPath("data.txt"); 
    ifstream inputStream(inputPath.c_str());
    string line; 
    int i = 0; 
    
    while (getline(inputStream, line)) {
        arr[i] = atoi(line.c_str()); 
        i++; 
    }
    
    MergeSort(arr, i);
    
    for (int j = 0; j < i; j++) {
        cout << arr[j] << " "; 
    } 
    cout << endl; 
    
    return 0; 
}
