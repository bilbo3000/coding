#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <string>

using namespace std;

typedef struct Node {
	int value;
	Node * next;
} Node;


void MergeLinkedList(Node * &a, Node * &b, Node * &n) {
	Node * tail = n;
	while (a != NULL && b != NULL) {
		if (a->value < b->value) {
			if (n == NULL) {
				n = a;
				a = a->next;
				n->next = NULL;
				tail = n;
			}
			else {
				tail->next = a;
				a = a->next;
				tail = tail->next;
				tail->next = NULL;
			}
		}
		else {
			if (n == NULL) {
				n = b;
				b = b->next;
				n->next = NULL;
				tail = n;
			}
			else {
				tail->next = b;
				b = b->next;
				tail = tail->next;
				tail->next = NULL;
			}
		}
	}

	if (a == NULL) {
		if (n == NULL){
			n = b;
		}
		else {
			tail->next = b;
		}
	}
	else {
		if (n == NULL) {
			n = a;
		}
		else {
			tail->next = a;
		}
	}

}

void MergeSortLinkedList(Node * &n) {
	if (n == NULL || n->next == NULL) {
		return;
	}

	Node * a = n;
	Node * b = n->next;

	while(b != NULL) {
		b = b->next;
		if (b != NULL) {
			a = a->next;
			b = b->next;
		}
	}

	b = a->next;
	a->next = NULL;
	a = n;
	n = NULL;

	MergeSortLinkedList(a);
	MergeSortLinkedList(b);

	MergeLinkedList(a, b, n);
}

// Test driver
int main() {
	string inputPath("data.txt");
	ifstream inputStream(inputPath.c_str());
	string line;
	Node * head = NULL;
	Node * tail = NULL;
	while(getline(inputStream, line)) {
		Node * newNode = new Node();
		newNode->value = atoi(line.c_str());
		newNode->next = NULL;

		if (head == NULL) {
			head = newNode;
			tail = head;
		}
		else {
			tail->next = newNode;
			tail = tail->next;
		}
	}

	MergeSortLinkedList(head);

	while(head != NULL && head->next != NULL) {
		cout << head->value << " ";
		head = head->next;
	}
	return 0;
}
