#include <iostream> 
#include <fstream> 
#include <string> 
#include <stdlib.h> 

#define MAX 100

using namespace std; 
void Swap(int &a, int &b) {
    int temp = a; 
    a = b; 
    b = temp; 
}
 
void Heapify(int a[], int size, int index) {
    if ((index * 2 + 1) < size) { // Has left child
        int maxChildIndex = index * 2 + 1; 
        if ((index * 2 + 2) < size) {
            if (a[index * 2 + 2] > a[maxChildIndex]) {
                maxChildIndex = index * 2 + 2;  // Right child
            }
        }
        
        if (a[maxChildIndex] > a[index]) {
            Swap(a[maxChildIndex], a[index]);
            Heapify(a, size, maxChildIndex);  
        }
    }
}

void ConstructHeap(int a[], int size) {
    int lastParentIndex = (size - 2) / 2; 
    
    for (int i = lastParentIndex; i >=0; i--) {
        Heapify(a, size, i); 
    }
}

void HeapSort(int a[], int size) {
    ConstructHeap(a, size);
    for (int heapSize = size; heapSize > 1; heapSize--) {
        Swap(a[0], a[heapSize - 1]);
        Heapify(a, heapSize - 1, 0);  
    } 
    
    for (int i = 0; i < size; i++) {
        cout << a[i] << " "; 
    }
    
    cout << endl; 
}

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
    
    HeapSort(a, i); 
      
    return 0; 
}
