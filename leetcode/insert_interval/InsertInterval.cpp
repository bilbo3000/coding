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
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> overlap; 
        int s = newInterval.start; 
        int e = newInterval.end; 
        
        // Collect a list of overlaps 
        for(int i = 0; i < intervals.size(); i++) {
            if ((intervals[i].start <= e && intervals[i].end >= e) || 
                (intervals[i].start <= s && intervals[i].end >= s) || 
                (intervals[i].start >= s && intervals[i].end <= e)) {
                    overlap.push_back(i); 
                }
        }
        
        if (overlap.size() == 0) {  // No overlap
            int i = 0; 
            while (i < intervals.size()) {
                if (intervals[i].start > e) {
                    break; 
                }
                i++; 
            }
            
            intervals.insert(intervals.begin() + i, newInterval); 

            return intervals; 
        }
        
        int newStart = min(intervals[overlap[0]].start, s); 
        int newEnd = max(intervals[overlap[overlap.size() - 1]].end, e);
        Interval mergeInterval(newStart, newEnd);
        intervals.insert(intervals.begin() + overlap.back() + 1, mergeInterval); 
        
        // Remove overlaps 
        for(int i = overlap.size() - 1; i >= 0; i--) {
            intervals.erase(intervals.begin() + overlap[i]); 
        }
        
        return intervals; 
    }
};

int main() {
    vector<Interval> intervals; 
    /*
    Interval i1(1, 3);
    Interval i2(6, 9); 
    intervals.push_back(i1);
    intervals.push_back(i2);  
    Interval newInterval(2, 5);
    */
    
    /*
    Interval i1(1, 2);
    intervals.push_back(i1); 
    Interval i2(3, 5);
    intervals.push_back(i2); 
    Interval i3(6, 7);
    intervals.push_back(i3); 
    Interval i4(8, 10);
    intervals.push_back(i4); 
    Interval i5(12, 16);
    intervals.push_back(i5); 
    Interval newInterval(4, 9);
    */
    
    
    Interval i1(1, 5); 
    intervals.push_back(i1);
    Interval newInterval(0, 0);  
    
    
    Solution sln; 
    vector<Interval> result = sln.insert(intervals, newInterval);
    
    for (int i = 0; i < result.size(); i++) {
        cout << result[i].start << "," << result[i].end << endl; 
    }   
    return 0; 
}
