#include <iostream>
#include <vector>
#include <map>

using namespace std;

string Transform(int number) {
	if (number <= 0) {
		return "Invalid input";
	}

	vector<pair<string, int> > mapping;
	pair<string, int> p1("I", 1);
	mapping.push_back(p1);
	pair<string, int> p2("V", 5);
	mapping.push_back(p2);
	pair<string, int> p3("X", 10);
	mapping.push_back(p3);
	pair<string, int> p4("L", 50);
	mapping.push_back(p4);
	pair<string, int> p5("C", 100);
	mapping.push_back(p5);
	pair<string, int> p6("D", 500);
	mapping.push_back(p6);
	pair<string, int> p7("M", 1000);
	mapping.push_back(p7);

	string result = "";
	int index = mapping.size() - 1;
	int digit = 0;

	while (index >= 0) {
		cout << "mapping: " << mapping[index].second << endl;
		digit = number / mapping[index].second;
		cout << "digit: " << digit << endl;
		number = number % mapping[index].second;
		cout << "number: " << number << endl;

		if (digit >= 1 && digit <= 3) {
			for (int i = 0; i < digit; i++) {
				result += mapping[index].first;
			}
		}
		else if(digit == 4) {
			result += mapping[index].first;
			result += mapping[index + 1].first;
		}
		else if (digit >= 5 && digit <= 8) {
			result += mapping[index + 1].first;
			for (int i = 0; i < digit - 5; i++) {
				result += mapping[index].first;
			}
		}
		else if(digit == 9) {
			result += mapping[index].first;
			result += mapping[index + 2].first;
		}

		index = index - 2;
	}

	return result;
}

int main () {
	cout << Transform(3999) << endl;
	return 0;
}
