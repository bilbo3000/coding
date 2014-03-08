#include <iostream> 
#include <cmath> 

using namespace std; 

void MergeSort(int arr[], int size); 
void Merge(int a[], int b[], int c[], int sizea, int sizeb, int sizec);
void QuickSort(int arr[], int left, int right);
int Partition(int arr[], int left, int right);  
void Swap(int &a, int &b);  

void MergeSort(int arr[], int size) {
    if (size > 1) {
        int sizea = floor(size / 2); 
        int sizeb = size - sizea; 
        
        int a[sizea]; 
        int b[sizeb]; 
        
        for (int i = 0; i < sizea; i++) {
            a[i] = arr[i]; 
        }
        
        for (int i = 0; i < sizeb; i++) {
            b[i] = arr[sizea + i];
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
    
    while (i < sizea && j < sizeb) {
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
    
    if (i == sizea) {  // a is empty, copy rest of b
        for (int m = j; m < sizeb; m++) {
            c[k] = b[m]; 
            k++; 
        }
    }
    else {  // b is empty, copy rest of a
        for (int n = i; n < sizea; n++) {
            c[k] = a[n]; 
            k++; 
        }
    }
}

void QuickSort(int a[], int left, int right) {
    if (left < right) {
        int index = Partition(a, left, right); 
        QuickSort(a, left, index - 1);
        QuickSort(a, index + 1, right);  
    }
}

int Partition(int a[], int left, int right) {
    int pivot = a[right]; 
    int i = left - 1; 
    
    for (int j = left; j < right; j++) {
        if (a[j] < pivot) {
            i++; 
            Swap(a[i], a[j]); 
        }
    }
    
    Swap(a[i + 1], a[right]); 
    
    return i + 1; 
}

void Swap(int &a, int &b) {
    int temp = a; 
    a = b; 
    b = temp; 
}

void Print(int a[], int size) {
    for (int i = 0; i < size; i++) {
        cout << a[i] << " "; 
    }
    
    cout << endl; 
}

void TwoSumSorting(int a[], int size, int x) {
    QuickSort(a, 0, size - 1); 
    // MergeSort(a, size);  
     
    int i = 0; 
    int j = size - 1;  
    
    while (i < j) {
        int sum = a[i] + a[j]; 
        if (sum == x) {
            cout << a[i] << " + " << a[j] << " = " << x << endl; 
            return; 
        }
        else if(sum < x) {
            i++; 
        }
        else {
            j--;  
        }
    }
}

void ThreeSum(int a[], int size) {
    QuickSort(a, 0, size - 1); 
    
    for (int i = size - 1; i >= 0; i++) {  // Check each element
        int left = 0; 
        int right = i - 1; 
        
        while (left < right) {
            int sum = a[left] + a[right]; 
            
            if (sum == a[i]) {
                cout << a[left] << " + " << a[right] << " = " << a[i] << endl; 
                return; 
            }
            else if (sum < a[i]) {
                left++; 
            }
            else {
                right--; 
            }
        }
    }
}

// Test driver
int main() {
    int a[] = {3, 7, 4, 12, 5, 2}; 
    
    cout << "Two sum: "; 
    TwoSumSorting(a, 6, 9); 
    
    cout << "Three sum: "; 
    ThreeSum(a, 6);
     
    return 0; 
}
