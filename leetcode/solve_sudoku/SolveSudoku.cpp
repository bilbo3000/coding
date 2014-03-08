#include <iostream> 
#include <vector> 

using namespace std; 

class Solution {
public:
    bool isValid(vector<vector<char> > &board, int x, int y) {
    	// Check current row
    	bool rowHistory[9] = { false }; 
    	
    	for (int j = 0; j < 9; j++) {
    		if (isdigit(board[x][j])) {
    			if (rowHistory[board[x][j] - '1']) return false; 
    			rowHistory[board[x][j] - '1'] = true; 
    		}
    	}
    	
    	// Check current column 
        bool colHistory[9] = { false }; 
        
        for (int i = 0; i < 9; i++) {
        	if (isdigit(board[i][y])) {
        		if (colHistory[board[i][y] - '1']) return false; 
        		colHistory[board[i][y] - '1'] = true; 
        	}
        }
        
        // Check quadrant
        bool quadHistory[9] = { false }; 
        int quadx = x / 3; 
        int quady = y / 3; 
        
        for (int i = quady * 3; i < quady * 3 + 3; i++) {
        	for (int j = quadx * 3; j < quadx * 3 + 3; j++) {
        		if (isdigit(board[i][j])) {
        			if (quadHistory[board[i][j] - '1']) return false; 
        			quadHistory[board[i][j] - '1'] = true; 
        		}
        	}
        }
        
        return true; 
    }
    
    pair<int, int> findFirstEmpty(vector<vector<char> > &board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    return make_pair(i, j); 
                }
            }
        }
        
        return make_pair(-1, -1); 
    }
    
    bool solveSudoku(vector<vector<char> > &board) {
    	pair<int, int> firstEmpty = findFirstEmpty(board); 
    	
    	if (firstEmpty.first != -1) {
    		int x = firstEmpty.first; 
    		int y = firstEmpty.second; 
    		
    		for (int i = 1; i <= 9; i++) {
    			board[x][y] = i + '0'; 
    			if (isValid(board, x, y) && solveSudoku(board)) {
    				return true; 
    			}
    		}
    		
    		board[x][y] = '.'; 
    		
    		return false; 
    	}
    	
    	// No empty cells --> succeed	
		return true; 
    }
};

int main() {
	Solution sln; 
	vector<vector<char> > board; 
	//["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..",
	// "...8.3.2.","........6","...2759.."]
	
	/*
	for (int i = 0; i < 9; i++) {
		vector<char> temp(9, '.'); 
		board.push_back(temp); 
	}
	*/
	char temp0[] = {'.', '.', '9', '7', '4', '8', '.', '.', '.' }; 
	vector<char> v0 (temp0, temp0 + sizeof(temp0) / sizeof(char)); 
	board.push_back(v0); 
	
	char temp1[] = {'7', '.', '.', '.', '.', '.', '.', '.', '.' };
	vector<char> v1 (temp1, temp1 + sizeof(temp1) / sizeof(char)); 
	board.push_back(v1); 
	char temp2[] = {'.', '2', '.', '1', '.', '9', '.', '.', '.' };
	vector<char> v2 (temp2, temp2 + sizeof(temp2) / sizeof(char)); 
	board.push_back(v2); 
	
	char temp3[] = {'.', '.', '7', '.', '.', '.', '2', '4', '.' };
	vector<char> v3 (temp3, temp3 + sizeof(temp3) / sizeof(char)); 
	board.push_back(v3); 
	
	char temp4[] = {'.', '6', '4', '.', '1', '.', '5', '9', '.' };
	vector<char> v4 (temp4, temp4 + sizeof(temp4) / sizeof(char)); 
	board.push_back(v4); 
	
	char temp5[] = {'.', '9', '8', '.', '.', '.', '3', '.', '.' };
	vector<char> v5 (temp5, temp5 + sizeof(temp5) / sizeof(char)); 
	board.push_back(v5);
	 
	char temp6[] = {'.', '.', '.', '8', '.', '3', '.', '2', '.' };
	vector<char> v6 (temp6, temp6 + sizeof(temp6) / sizeof(char)); 
	board.push_back(v6); 
	
	char temp7[] = {'.', '.', '.', '.', '.', '.', '.', '.', '6' };
	vector<char> v7 (temp7, temp7 + sizeof(temp7) / sizeof(char)); 
	board.push_back(v7); 
	
	char temp8[] = {'.', '.', '.', '2', '7', '5', '9', '.', '.' };
	vector<char> v8 (temp8, temp8 + sizeof(temp8) / sizeof(char)); 
	board.push_back(v8); 
	
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cout << board[i][j] << " "; 
		}
		cout << endl; 
	}
	
	sln.solveSudoku(board); 
	
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cout << board[i][j] << " "; 
		}
		cout << endl; 
	}
}
