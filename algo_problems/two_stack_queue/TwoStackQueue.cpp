#include <iostream> 
#include <stack> 

using namespace std; 

class TwoStackQueue {
private: 
    stack<int> s1; 
    stack<int> s2; 
    
public: 
    void Enqueue(int x); 
    int Dequeue(); 
    void Print(); 
}; 

void TwoStackQueue::Enqueue(int x) {
    s1.push(x); 
}

int TwoStackQueue::Dequeue() {
    if (s1.size() == 0) {
        return -1; 
    } 
    
    while (s1.size() != 0) {
        s2.push(s1.top()); 
        s1.pop(); 
    }
    
    int result = s2.top(); 
    s2.pop(); 
    
    while (s2.size() != 0) {
        s1.push(s2.top());
        s2.pop();  
    }
    
    return result; 
}

int main() {
    TwoStackQueue q; 
    q.Enqueue(1); 
    q.Enqueue(2); 
    q.Enqueue(3);
    cout << q.Dequeue() << endl; 
    q.Enqueue(4); 
    cout << q.Dequeue() << endl;
    cout << q.Dequeue() << endl;
    cout << q.Dequeue() << endl;
    cout << q.Dequeue() << endl;
    
    return 0; 
}
