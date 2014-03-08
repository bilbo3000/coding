#include <iostream> 
#include <fstream> 
#include <stdlib.h> 

#define MAX 100

using namespace std; 

void SelectionSort(int a[], int size) {
    for (int i = 0; i < size - 1; i++) {
        int minIndex = i; 
        for (int j = i + 1; j < size; j++) {
            if (a[j] < a[minIndex]) {
                minIndex = j; 
            }
        }
        
        int temp = a[i]; 
        a[i] = a[minIndex]; 
        a[minIndex] = temp; 
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
    
    SelectionSort(a, i);
    
    for (int j = 0; j < i; j++) {
        cout << a[j] << " "; 
    } 
    
    cout << endl; 
    return 0; 
}
