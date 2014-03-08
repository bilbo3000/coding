#include <iostream> 
#include <cmath> 
#include <fstream>
#include <stdlib.h> 

#define  MAX  100

using namespace std; 

void Quicksort(int a[], int left, int right); 

int Partition(int a[], int left, int right);  

int Swap(int &a, int &b); 

void PrintArray(int a[], int size); 

// Test driver 
int main() {
    int arr[MAX]; 
    
    string inputFilePath("data.txt");
    ifstream inputFileStream(inputFilePath.c_str());
    string line; 
    int i = 0; 
    
    while (getline(inputFileStream, line)) {
        arr[i] = atoi(line.c_str()); 
        i++; 
    }
    
    inputFileStream.close();  
    
    Quicksort(arr, 0, i - 1);
    
    PrintArray(arr, i - 1);  
    
    return 0; 
}

// Quick sort 
void Quicksort(int a[], int left, int right) {
    if ((right - left) > 0) {
        int i = Partition(a, left, right);
        Quicksort(a, left, i - 1); 
        Quicksort(a, i + 1, right);  
    }
}

// Partition the array 
int Partition(int a[], int left, int right) {
    int i = left - 1;  // [left..i] <= pivot
    int j = left;  // Walker to examine each element 
    int pivot = a[right];  // Use last element as pivot 
    
    while (j < right) {  // Examine each element 
        if (a[j] <= pivot) {
            i = i + 1; 
            swap(a[i], a[j]); 
        }
        
        j = j + 1; 
    } 
    
    swap(a[i + 1], a[right]);
    
    return i + 1;  
}

// Swap the given two elements 
int Swap(int &a, int &b) {
    int temp = a; 
    a = b; 
    b = temp; 
}

// Print the array 
void PrintArray(int a[], int size) {
    for (int i = 0; i < size; i++) {
        cout << a[i] << " "; 
    }
    
    cout << endl; 
} 
