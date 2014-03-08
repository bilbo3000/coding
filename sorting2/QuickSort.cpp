#include <iostream> 
#include <fstream> 
#include <stdlib.h>

#define MAX 100

using namespace std; 

void QuickSort(int a[], int l, int r); 
int Partition(int a[], int l, int r);
void Swap(int &a, int &b);
  
// Quick sort 
void QuickSort(int a[], int l, int r) {
    if (r > l) {
        int p = Partition(a, l, r);
        QuickSort(a, l, p - 1);
        QuickSort(a, p + 1, r);   
    }
}

int Partition(int a[], int l, int r) {
    int pivot = a[r]; 
    int i = -1; 
    
    for (int j = 0; j < r; j++) {
        if (a[j] < pivot) {
            i++; 
            Swap(a[i], a[j]);  
        }
    }
    
    Swap(a[i + 1], a[r]);
    
    return i + 1;  
}

void Swap(int &a, int &b) {
    int temp = a; 
    a = b; 
    b = temp; 
}

// Test driver 
int main () {
    string inputPath("data.txt"); 
    ifstream inputStream(inputPath.c_str());
    string line; 
    int arr[MAX]; 
    int i = 0; 
    
    while(getline(inputStream, line)) {
        arr[i] = atoi(line.c_str()); 
        i++; 
    } 
    
    QuickSort(arr, 0, i); 
    
    for (int j = 0; j < i; j++) {
        cout << arr[j] << " "; 
    }
    
    cout << endl; 
    return 0; 
}
