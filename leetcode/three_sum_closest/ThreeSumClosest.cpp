#include <iostream> 
#include <vector> 
#include <algorithm> 
#include <climits> 

using namespace std; 

class Solution {
public:
    int threeSumClosest(vector<int> &num, int target) {
        sort(num.begin(), num.end());  
        
        int closestSum = 0; 
        int diff = INT_MAX; 
        
        for (int i = 0; i < num.size() - 2; i++) {
            int j = num.size() - 1; 
            int k = i + 1; 
            
            while (k < j) {
                int sum = num[i] + num[k] + num[j]; 
                int currDiff = abs(sum - target); 
                if (currDiff < diff) {
                    diff = currDiff; 
                    closestSum = sum; 
                }
                
                if (sum == target) {
                    return sum; 
                }
                else if (sum > target) {
                    j--; 
                }
                else {
                    k++; 
                }
            }
        }
        
        return closestSum; 
    }
};

int main() {
	Solution sln; 
	vector<int> num; 
	num.push_back(0);
	num.push_back(1);
	num.push_back(2);
	   
	cout << sln.threeSumClosest(num, 3) << endl; 
}
