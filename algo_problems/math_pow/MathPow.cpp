#include <iostream> 
#include <cmath>

using namespace std; 

double MyPow(double base, int exp) {
    if (base == 0 && exp == 0) {
        cout << "Undefined" << endl; 
        return 0;  
    }
    
    if (base == 0) {
        return 0; 
    }
    
    if (exp == 0) {
        return 1; 
    }
    
    bool isExpNeg = exp < 0 ? true : false; 
    int absExp = abs(exp); 
    double result = base;
    
    while (absExp > 1) {
        result *= base; 
        absExp -= 1; 
    } 
    
    return isExpNeg ? (1.0 / result) : result; 
} 

// Test driver 
int main() {
    cout << MyPow(5, 0) << endl; 
    cout << MyPow(2, 3) << endl;
    cout << MyPow(0.5, 2) << endl; 
    cout << MyPow(0.5, -2) << endl;
    cout << MyPow(0, -3) << endl;
    MyPow(0, 0);     
    
    return 0; 
}
