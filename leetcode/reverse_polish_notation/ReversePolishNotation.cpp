class Solution {
public:
    int evalRPN(vector<string> &tokens) {
        stack<int> s; 
        
        for (int i = 0; i < tokens.size(); i++) {
            string curr = tokens[i]; 
            
            if (curr == "+" || curr == "-" || curr == "*" || curr == "/") {
                int op2 = s.top(); 
                s.pop(); 
                int op1 = s.top(); 
                s.pop(); 
                
                int temp = 0; 
                if (curr == "+") temp = op1 + op2; 
                if (curr == "-") temp = op1 - op2; 
                if (curr == "*") temp = op1 * op2; 
                if (curr == "/") temp = op1 / op2; 
                
                s.push(temp); 
            }
            else {
                s.push(atoi(curr.c_str())); 
            }
        }
        
        if (s.size() == 0) return 0; 
        else return s.top(); 
    }
};
