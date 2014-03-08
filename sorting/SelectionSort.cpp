#include<iostream> 
#include<fstream> 
#include<string> 
#include<stdlib.h>
#include <cmath> 

#define  MAX  100 

using namespace std; 

void SelectionSort(int a[], int size);
void Swap(int &a, int &b); 
void PrintArray(int a[], int size); 
int BinarySearch(int a[], int left, int right, int x); 

int main(){
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
    
    SelectionSort(arr, i); 
    
    PrintArray(arr, i); 
    
    cout << BinarySearch(arr, 0, i - 1, 5) << endl;
    cout << BinarySearch(arr, 0, i - 1, 65) << endl;
    cout << BinarySearch(arr, 0, i - 1, 16) << endl; 
    cout << BinarySearch(arr, 0, i - 1, 100) << endl;   
    
    return 0; 
} 

void SelectionSort(int a[], int size) {
    for(int i = 0; i < size - 1; i++) {
        int min = a[i];
        int minIndex = i; 
         
        // Find min in the unsorted array
        for (int j = i; j < size; j++) { 
            if (a[j] < min) {
                min = a[j]; 
                minIndex = j; 
            }
        }
        
        swap(a[i], a[minIndex]); 
    }
} 

void Swap(int &a, int &b) {
    int temp = a; 
    a = b; 
    b = temp; 
} 

void PrintArray(int a[], int size) {
    for (int i = 0; i < size; i++) {
        cout << a[i] << " "; 
    }
    
    cout << endl; 
}

int BinarySearch(int a[], int left, int right, int x) {
    if (right >= left) {
        int index = floor((left + right) / 2); 
        if (a[index] == x) {  // Find
            return index; 
        } 
        else if (a[index] > x) {
            return BinarySearch(a, left, index - 1, x); 
        }
        else {
            return BinarySearch(a, index + 1, right, x); 
        }
    }
    
    return -1; 
}
