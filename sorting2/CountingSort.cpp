#include <iostream> 
#include <fstream> 
#include <string> 
#include <stdlib.h>

#define MAX 100

using namespace std; 

void CountingSort(int a[], int size) {
    int ca[MAX];
    
    for (int i = 0; i < MAX; i++) {
        ca[i] = 0; 
    }
    
    for (int i = 0; i < size; i++) {
        ca[a[i]]++; 
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
        int index = ca[a[i]] - 1; 
        ca[a[i]]--; 
        out[index] = a[i]; 
    }
    
    // a = out wont work!!!
    for (int i = 0; i < size; i++) {
        a[i] = out[i]; 
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
    
    CountingSort(a, i);
    
    for (int j = 0; j < i; j++) {
        cout << a[j] << " "; 
    } 
    
    cout << endl; 
    return 0; 
}
