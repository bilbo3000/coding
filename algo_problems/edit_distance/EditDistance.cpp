#include <iostream> 

using namespace std; 

int min(int a, int b, int c) {
	int min = a; 
	if (b < min) {
		min = b; 
	}
	
	if (c < min) {
		min = c; 
	}
	
	return min; 
}

int EditDistance(string pattern, string text) {
	if (pattern.size() == 0 || text.size() == 0) {
		return 0; 
	}
	
	int T[pattern.size()][text.size()];   // T[i][j]: edit distance ending at text[j] and pattern[i]
	if (pattern[0] == text[0]) {
		T[0][0] = 0; 
	}
	else {
		T[0][0] = 1; 
	}
	
	for (int i = 1; i < text.size(); i++) {
		T[0][i] = T[0][i - 1] + 1; 
	}
	
	for (int i = 1; i < pattern.size(); i++) {
		T[i][0] = T[i - 1][0] + 1; 
	}
	
	for (int i = 1; i < pattern.size(); i++) {
		for (int j = 1; j < text.size(); j++) {
			if (pattern[i] == text[j]) {
				T[i][j] = T[i - 1][j - 1]; 
			}
			else {
				T[i][j] = min(T[i - 1][j - 1] + 1, T[i - 1][j] + 1, T[i][j - 1] + 1); 
			}
		}
	}
	
	return T[pattern.size() - 1][text.size() - 1]; 
}

int main() {
	cout << EditDistance("cat", "dog") << endl; 
	return 0; 
}