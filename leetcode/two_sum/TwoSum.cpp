#include <iostream> 
#include <vector> 
using namespace std; 

class Solution {
public:
    void QuickSort(vector<int> &numbers, int l, int r) {
        if (l < r) {
            int pivot = numbers[r]; 
            int i = l - 1; 
            for (int j = l; j < r; j++) {
                if (numbers[j] < pivot) {
                    i++; 
                    int temp = numbers[i]; 
                    numbers[i] = numbers[j]; 
                    numbers[j] = temp; 
                }
            }
            
            numbers[r] = numbers[i + 1]; 
            numbers[i + 1] = pivot; 
            
            QuickSort(numbers, l, i); 
            QuickSort(numbers, i + 2, r); 
        }
    }
    vector<int> twoSum(vector<int> &numbers, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
		int n = numbers.size(); 
		vector<int> results; 
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (numbers[i] + numbers[j] == target) {
					results.push_back(i + 1);
					results.push_back(j + 1);  
					return results; 
				}
			}
		} 
    }
};

int main() {
	Solution sln; 
	vector<int> input; 
	input.push_back(150);
	input.push_back(24); 
	input.push_back(79); 
	input.push_back(50);
	input.push_back(88);
	input.push_back(345);
	input.push_back(3);    
	vector<int> output = sln.twoSum(input, 200);  

	for(vector<int>::iterator it = input.begin(); it < input.end(); it++) {
		cout << *it << " "; 
	}	
	cout << endl; 

	for(vector<int>::iterator it = output.begin(); it < output.end(); it++) {
		cout << *it << " "; 
	}

	cout << endl; 
	return 0; 
}
