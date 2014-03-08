#include <iostream> 
#include <cmath> 

using namespace std; 

class Solution {
public:
    int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == 0) {
            return 0; 
        }
        
        long long result = 0; 
        long long dividendAbs = abs((double)dividend);
        long long divisorAbs = abs((double)divisor);  
        
        while (dividendAbs >= divisorAbs) {
            long long temp = divisorAbs; 
            long long cnt = 1; 
            while (dividendAbs >= temp) {
                dividendAbs -= temp; 
                result += cnt; 
                temp = temp << 1; 
                cnt = cnt << 1; 
            }
        }
        
        return ((dividend ^ divisor) >> 31) ? -result : result; 
    }
};

// Test driver 
int main() {
	Solution sln; 
	cout << sln.divide(1, -1) << endl; 
	cout << sln.divide(0, 0) << endl; 
	cout << sln.divide(0, 5) << endl; 
	cout << sln.divide(5, 5) << endl; 
	cout << sln.divide(10, 5) << endl; 
	cout << sln.divide(11, 5) << endl;
	cout << sln.divide(14, 5) << endl;  
	cout << sln.divide(15, 5) << endl; 
	cout << sln.divide(2147483647, 1) << endl; 
	cout << sln.divide(-1010369383, -2147483648) << endl; 
    return 0; 
}
