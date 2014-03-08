#include <iostream> 

using namespace std; 

template <class T>
class Vector {
private: 
    T * arr; 
    int size;  // Number of elements in the array
    int space;  // Total allocated space 

public: 
    // Constructor 
    Vector(); 
    
    // Destructor 
    ~Vector(); 
    
    // Insert
    void Insert(T x, int index);
    
    // Delete
    void Delete(int index); 
    
    // operator[] overloading 
    T operator[](int i);  
    
    // Print the vector 
    void PrintVector(); 
}; 

template <class T>
Vector<T>::Vector() {
    size = 0; 
    space = 0;  
}

template <class T>
Vector<T>::~Vector() {
    if (size != 0) {
        delete [] arr; 
    }
    
    size = 0; 
    space = 0; 
}

template <class T>
void Vector<T>::Insert(T x, int index) {
    if (index > size) {
        cout << "Index out of bound when Insert: " << x << endl; 
        return; 
    }
    
    if (space == 0) {  // Insert into empty vector with no space
        cout << "Insert into empty vector: " << x << endl; 
        space = 1;  // Allocate one space  
        arr = new T[space]; 
        arr[0] = x; 
        size = 1; 
    }
    else if (size == space) {  // Vector is full
        cout << "Insert full vector, double its size: " << x << endl; 
        space = space * 2;  // Double the space
        T * temp = arr; 
        arr = new T[space]; 
        
        for(int i = 0; i < index; i++) {  // Copy over first part 
            arr[i] = temp[i]; 
        }
        
        arr[index] = x;   // Insert element 
        
        for (int j = index; j < size; j++) {  // Copy over second part 
            arr[j + 1] = temp[j]; 
        }  
        
        size++; 
        
        delete [] temp;  // Delete old array 
    }
    else {  // There is still empty spot left 
        for (int i = size - 1; i >= index; i--){
            arr[i + 1] = arr[i]; 
        }
        
        arr[index] = x; 
        size++; 
        
        cout << "Insert successfully: " << x << endl; 
    }
} 

template <class T>
void Vector<T>::Delete(int index) {
    if (index >= size) {
        cout << "Index out of bound when delete" << endl; 
        return; 
    }
    
    for (int i = index; i < size - 1; i++) {
        arr[i] = arr[i+1]; 
    }
    
    arr[size - 1] = 0; 
    size--; 
}

template <class T>
T Vector<T>::operator[](int index) {
    if (index > size - 1) {
        cout << "Index out of bound when access" << endl; 
        return 0; 
    }
    
    return arr[index]; 
}

template <class T>
void Vector<T>::PrintVector() {
    for (int i = 0; i < size; i++) {
        cout << arr[i] << endl; 
    }
}

// Test driver 
int main() {
    Vector<char> v;
    v.Insert('b', 5);  // Index out of bound
    v.Insert('b', 0);  // Insert into empty
    v.Insert('a', 0);  // Insert into full
    v.Insert('c', 0); 
    v.Insert('h', 1);  // Insert in the middle
    v.Insert('z', 4); // Insert at the end 
    v.PrintVector(); 
     
    v.Delete(5); 
    v.Delete(1); 
    v.PrintVector(); 
    
    cout << v[2] << endl; 
    return 0; 
}

