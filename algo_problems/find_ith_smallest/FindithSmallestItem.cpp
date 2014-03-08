#include <iostream> 

using namespace std; 

void Swap(int &a, int &b); 
int Select(int a[], int left, int right, int i); 
int Partition(int a[], int left, int right); 

int Select(int a[], int left, int right, int i) {
    if (left == right) return a[left]; 
           
    int pivotIndex = Partition(a, left, right);  
    
    if ((pivotIndex - left + 1) == i) {  // Pivot is the ith smallest element
        return a[pivotIndex]; 
    }
    else if((pivotIndex - left + 1) > i) {
        return Select(a, left, pivotIndex - 1, i); 
    }
    else {
        return Select(a, pivotIndex + 1, right, i - pivotIndex - 1); 
    }
}

int Partition(int a[], int left, int right) {
    if (left == right) {
        return left; 
    }
    else {
        int pivot = a[right];  // Get the pivot
        int i = left - 1;  // i points to last element of first section
        
        for (int j = left; j < right; j++) {
            if (a[j] < pivot) {
                i++;
                Swap(a[i], a[j]); 
            }
        }
        
        Swap(a[i + 1], a[right]); 
        
        return i + 1; 
    }
}

void Swap(int &a, int &b) {
    int temp = a; 
    a = b; 
    b = temp; 
} 

// Test driver 
int main() {
    int a[] = {10, 5, 15, 20, 0, 25, 50, 25}; 
    cout << "1st: " << Select(a, 0, 7, 1) << endl << endl;
    cout << "8th: " << Select(a, 0, 7, 8) << endl << endl; 
    cout << "4th: " << Select(a, 0, 7, 4) << endl << endl; 
}
