#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    vector<int> getRow(int rowIndex) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<int> result; 
        result.push_back(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 0; j < result.size() - 1; j++) {
                result[j] = result[j] + result[j + 1]; 
            }
            result.insert(result.begin(), 1); 
        }
        
        return result; 
    }
};

int main() {
	Solution sln; 
	vector<int> result = sln.getRow(6);
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << " "; 
	} 
	
	cout << endl; 
	return 0; 
}
