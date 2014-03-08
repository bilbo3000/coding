#include <iostream> 
#include <fstream>
#include <string>
#include <cmath>
#include <sstream>
#include <cstdlib>

#define MAX 100
using namespace std; 

class PriorityQueue{
private: 
    int count;  // Number of elements in the queue 
    int * heap; // Point to the heap array 
    
public: 
    // Constructor 
    PriorityQueue();
    
    PriorityQueue(int arr[], int cnt); 
    
    // Destructor 
    ~PriorityQueue(); 
    
    // Enqueue
    void Enqueue(int x); 
    
    // Dequeue
    int Dequeue(); 
    
    // Construct queue buttom up
    int * HeapBottomUp(int heap[], int count); 
    
    // Return a pointer points to the head 
    int * GetHeap(); 
    
    // Print heap level by leve; 
    void PrintByLevel(); 
    
    // Swap two elements 
    void Swap(int &a, int &b); 
}; 

PriorityQueue::PriorityQueue() {
    count = 0; 
    heap = new int[MAX]; 
}
PriorityQueue::PriorityQueue(int arr[], int cnt) {
    count = cnt;     
    heap = HeapBottomUp(arr, cnt); 
}

PriorityQueue::~PriorityQueue(){ 
    // No pointer need to be freed
}

void PriorityQueue::Enqueue(int x) {
    heap[count] = x;  // Insert at the first available position 
    int curr = count;  // Point to first available position 
    count++; 
    int parent = floor((curr - 1) / 2);
    bool isHeap = false; 
    
    while (!isHeap && parent >= 0) {
        if (heap[parent] >= heap[curr]) {
            isHeap = true;  
        }
        else {
            swap(heap[curr], heap[parent]); 
            curr = parent; 
            parent = floor((curr - 1) / 2);
        }
    }
}

int PriorityQueue::Dequeue() {
    if (count == 0) {  // Queue is empty
        cout << "Cannot dequeue empty queue" << endl; 
        return -1; 
    }
   
    int result = heap[0]; 
    heap[0] = heap[count - 1];  // Last element 
    heap[count - 1] = 0; 
    count--; 
    int lastIndex = count - 1; 
    bool isHeap = false; 
    int curr = 0; 
    int maxChildIndex = 2 * curr + 1;
    
    while(!isHeap && maxChildIndex <= lastIndex) { 
        if((maxChildIndex < lastIndex) && (heap[maxChildIndex + 1] > heap[maxChildIndex])) {
            maxChildIndex++;  // Find max child
        }
        
        if(heap[curr] >= heap[maxChildIndex]) {
            isHeap = true; 
        }
        else{
            swap(heap[curr], heap[maxChildIndex]); 
            curr = maxChildIndex; 
            maxChildIndex = 2 * curr + 1;
        }
    }
    
    return result; 
}

int * PriorityQueue::HeapBottomUp(int arr[], int count){
    int lastParentIndex = floor((count - 1 - 1) / 2); 
    int lastIndex = count - 1; 
    
    for (int i = lastParentIndex; i >= 0; i--) {
        int currIndex = i; 
        bool isHeap = false; 
        int maxChildIndex = 2 * currIndex + 1; 
        
        while (!isHeap && maxChildIndex <= lastIndex) {
            if ((maxChildIndex < lastIndex) && (arr[maxChildIndex + 1] > arr[maxChildIndex])) {
                maxChildIndex = maxChildIndex + 1;  // Find the maximum child
            }
            
            if (arr[maxChildIndex] > arr[currIndex]) {
                Swap(arr[currIndex], arr[maxChildIndex]); 
                currIndex = maxChildIndex; 
                maxChildIndex = 2 * currIndex + 1; 
            }
            else {
                isHeap = true; 
            }
        }
    }
    
    int * temp = arr; 
    
    return temp; 
}

int * PriorityQueue::GetHeap() {
    return heap; 
}

void PriorityQueue::PrintByLevel() {
    int numToPrint = 1; 
    int alreadyPrinted = 0;  // Count number of elements have been printed at this level 
    
    for (int i = 0; i < count; i++) {
        cout << heap[i] << " "; 
        alreadyPrinted++; 
        
        if (alreadyPrinted == numToPrint) {
            cout << endl; 
            numToPrint = numToPrint << 1;  // Double elements to print on next level
            alreadyPrinted = 0;  // Clear counter 
        }
    }
    
    if(alreadyPrinted != 0 && alreadyPrinted < numToPrint) {
        cout << endl; 
    }
}

void PriorityQueue::Swap(int &a, int &b){
    int temp = a; 
    a = b; 
    b = temp; 
}

// Test driver 
int main(){

    int arr[MAX]; 
    int count = 0; 
    string inputFilePath("data.txt");
    ifstream inputStream(inputFilePath.c_str()); 
    string line; 
    
    while(getline(inputStream, line)) { 
        stringstream(line) >> arr[count]; 
        // arr[count] = atoi(line.c_str()); 
        count++; 
    }
    
    inputStream.close(); 
    
    PriorityQueue pq(arr, count); 
    
    int * heap = pq.GetHeap(); 
    pq.PrintByLevel();
    
    pq.Enqueue(11);  // Enqueue
    pq.PrintByLevel(); 
    
    cout << pq.Dequeue() << endl;  // Dequeue
    
    pq.PrintByLevel();    
    
    return 0; 
}
