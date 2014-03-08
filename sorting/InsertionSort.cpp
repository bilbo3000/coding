#include <iostream> 
#include <string> 
#include <fstream> 
#include <stdlib.h>

#define  MAX  100

using namespace std; 

void PrintArray(int a[], int size); 
void InsertionSort(int a[], int size); 
void InsertionSort2(int a[], int size); 
void Swap(int &a, int &b); 

// Test driver 
int main() {
    int arr[MAX]; 
    string inputFilePath("data.txt");
    ifstream inputFileStream(inputFilePath.c_str()); 
    string line; 
    int i = 0; 
    
    while(getline(inputFileStream, line)) {
        arr[i] = atoi(line.c_str()); 
        i++; 
    }
    
    inputFileStream.close(); 
    
    // InsertionSort(arr, i);
    InsertionSort2(arr, i);
    
    PrintArray(arr, i);
      
    return 0; 
}

void InsertionSort(int a[], int size) { 
    if (size > 1) {
        for (int i = 1; i < size; i++) {
            int v = a[i]; 
            int j = i - 1; 
            
            while (j >= 0 && a[j] > v) {
                a[j + 1] = a[j]; 
                j--; 
            }
            
            a[j + 1] = v; 
        }
    }
}

void PrintArray(int a[], int size) {
    for (int i = 0; i < size; i++) {
        cout << a[i] << " "; 
    }
    
    cout << endl; 
}

void Swap(int &a, int &b) {
    int temp = a; 
    a = b; 
    b = temp; 
} 

void InsertionSort2(int a[], int size) {
    if (size > 1) {
        for (int i = 1; i < size; i++) {
            int j = i - 1; 
            
            while (j >= 0 && a[j] > a[j + 1]) {
                swap(a[j], a[j + 1]); 
                j--;  
            }
        }
    }
}
