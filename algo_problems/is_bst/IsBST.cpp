#include <iostream> 

using namespace std; 

typedef struct Node {
	int val; 
	Node * left; 
	Node * right; 
	Node() : val(0), left(NULL), right(NULL) {}
	Node(int n) : val(n), left(NULL), right(NULL) {}
} Node; 

bool IsBST(Node * node) {
	if (node == NULL) {
		return false; 
	}
	
	if (node->left == NULL && node->right == NULL) {
		return true; 
	}
	
	if ((node->left != NULL && node->left->val > node->val) || 
		(node->right != NULL && node->right->val < node->val)) {
		return false; 
	} 
	
	return true && IsBST(node->left) && IsBST(node->right); 
}

// Test driver 
int main() {
	Node * root = new Node(4);
	root->left = new Node(5);
	root->right = new Node(6); 
	root->left->left = new Node(1);
	root->left->right = new Node(3); 
	root->right->left = new Node(5); 
	root->right->right = new Node(7); 
	
	if (IsBST(root)) {
		cout << 1 << endl; 
	}  
	else {
		cout << 0 << endl; 
	}
	
	return 0; 
}