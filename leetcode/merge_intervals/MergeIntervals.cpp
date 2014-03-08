#include <iostream> 
#include <vector> 

using namespace std; 

struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

class Solution {
public:
    vector<Interval> merge(vector<Interval> &intervals) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (intervals.size() <= 1) {
            return intervals; 
        }
        
        for (int i = 1; i < intervals.size(); i++) {
            int j = i - 1; 
            Interval temp = intervals[i]; 
            while (j >= 0 && intervals[j].start > temp.start) {
                intervals[j + 1] = intervals[j]; 
                j--; 
            }
            
            intervals[j + 1]  = temp; 
        }
        
        int i = 0; 
        while (i < intervals.size() - 1) {
            if (intervals[i].end >= intervals[i + 1].start) {
                intervals[i].start = min(intervals[i].start, intervals[i + 1].start);
                intervals[i].end = max(intervals[i].end, intervals[i + 1].end);
                intervals.erase(intervals.begin() + i + 1);
                i--; 
            }
            
            i++; 
        }
        
        return intervals; 
    }
};

// Test driver 
int main() {
    Solution sln; 
    vector<Interval> intervals; 
    Interval temp; 
    
    temp.start = 1; 
    temp.end = 3; 
    intervals.push_back(temp); 
    
    temp.start = 2; 
    temp.end = 6; 
    intervals.push_back(temp);
    
    temp.start = 8; 
    temp.end = 10; 
    intervals.push_back(temp);
    
    temp.start = 15; 
    temp.end = 18; 
    intervals.push_back(temp);
    
    vector<Interval> result = sln.merge(intervals); 
    
    for (int i = 0; i < result.size(); i++) {
        cout << "[" << result[i].start << "," << result[i].end << "]" << " "; 
    }
    
    return 0; 
}
