#include <iostream> 
#include <fstream> 
#include <stdlib.h> 
#define MAX 100

using namespace std; 

void InsertionSort(int a[], int size) {
    if (size > 1) {
        for (int i = 1; i < size; i++) {
            int temp = a[i]; 
            int j = i - 1; 
            
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j]; 
                j--; 
            }
            
            a[j + 1] = temp; 
        }
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
    
    InsertionSort(a, i);
    
    for (int j = 0; j < i; j++) {
        cout << a[j] << " "; 
    } 
    
    cout << endl; 
    return 0; 
}
