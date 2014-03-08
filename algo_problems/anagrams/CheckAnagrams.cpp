#include <iostream>

using namespace std;
int main() {
	string s1 = "";
	string s2 = "";
	getline(cin, s1);
	getline(cin, s2);

	int ca1[256];
	int ca2[256];

	for (int i = 0; i < 256; i++) {
		ca1[i] = 0;
		ca2[i] = 0;
	}

	// Count chars in s1
	for (int i = 0; i < s1.size(); i++) {
		int index = (int)s1[i];
		ca1[index]++;
	}

	// Count chars in s2
	for (int i = 0; i < s2.size(); i++) {
		int index = (int)s2[i];
		ca2[index]++;
	}

	// Compare
	bool isAnagram = true;
	for (int i = 0; i < 256; i++) {
		if (ca1[i] != ca2[i]) {
			isAnagram = false;
			break;
		}
	}

	if (isAnagram) {
		cout << "Anagrams!" << endl;
	}
	else {
		cout << "Not anagrams!" << endl;
	}

    return 0;
}
