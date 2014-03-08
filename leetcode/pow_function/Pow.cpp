#include <iostream> 

using namespace std; 

class Solution {
public:
    double pow(double x, int n) { 
    	long long exp = n; 
    	 	
        if (exp == 0) {
            return 1; 
        }
        
        if (exp < 0) {
            x = 1 / x; 
            exp = exp * (-1); 
        }
        
        return powHelper(x, exp); 
    }
    
    double powHelper(double base, long long n) {
        if (n == 0) {
            return 1; 
        }
        
        if (n == 1) {
            return base; 
        }
        
        double divideTwo = powHelper(base, n / 2); 
        double modTwo = powHelper(base, n % 2);
         
        return  divideTwo * divideTwo * modTwo; 
    }
};

int main() {
	Solution sln; 
	cout << sln.pow(0.00001, 2147483647) << endl; 
	return 0; 
}
