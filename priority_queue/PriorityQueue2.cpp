#include <iostream> 
#include <queue> 
#include <vector> 

using namespace std; 

class Record {
public: 
	int val; 
	Record(int val) {
		this->val = val; 
	}

	void setVal(int val) {
		this->val = val; 
	}
}; 

class MyCompare {
public: 
	bool operator()(const Record *a, const Record *b){
		return a->val < b->val; 
	}
};

int main() {
	priority_queue<Record *, vector<Record *>, MyCompare> pq; 
	Record * r1 = new Record(1);
	Record * r3 = new Record(3); 
	Record * r2 = new Record(2); 
	

	pq.push(r1);
	pq.push(r3);
	pq.push(r2); 
	
	cout << pq.top()->val << endl;  
	
	r1->val = 4; 
	
	cout << pq.top()->val << endl;  
	
	return 0;  
}