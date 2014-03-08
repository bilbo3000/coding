class Solution {
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        int n = gas.size(); 
        int start = 0; 
        int sum = 0; 
        int total = 0; 
        
        for (int i = 0; i < n; i++) {
            int delta = gas[i] - cost[i]; 
            total += delta; 
            sum += delta; 
            
            // Current segment consumes gas
            // (Won't make from start to i)
            if (sum < 0) {  
                sum = 0;  // Start a new segment
                start = i + 1; // Start a new starting station for this new segment
            }
        }
        
        return total >= 0 ? start : -1; 
    }
};
