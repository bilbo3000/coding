#include <iostream>
#include <queue> 

using namespace std; 

typedef struct Node {
    int wordCount;  // Number of words end up at this node 
    int prefixCount;   // Number of prefix represented by the key of this node
    Node * next[26];  // Pointers to next level 
} Node; 

class Trie {
private: 
    Node * root; 

public: 
    // Constructor 
    Trie(); 
    
    // Destructor 
    ~Trie();
    
    // Create a new node 
    Node * CreateNode();  
    
    // Add a word to the trie
    void AddWord(Node * n, const char * word); 
    
    // Count the number of appearance of given word
    int CountWord(Node * n, const char * word); 
    
    // Count the number of words have given prefix 
    int CountPrefix(Node * n, const char * word); 
    
    // Destroy the tire start from the given node 
    void Destroy(Node * n); 
    
    // Print trie 
    void PrintTrie(); 
    
    // The the root pointer 
    Node * GetRoot();  
}; 

Trie::Trie() {
    root = new Node(); 
    root->wordCount = 0; 
    root->prefixCount = 0; 
    for (int i = 0; i < 26; i++) {
        root->next[i] = NULL; 
    }
}

Trie::~Trie() {
    Destroy(root); 
}

Node * Trie::CreateNode(){
    Node * n = new Node(); 
    n->wordCount = 0; 
    n->prefixCount = 0; 
    
    for(int i = 0; i < 26; i++) {
        n->next[i] = NULL; 
    }
    
    return n; 
}

void Trie::AddWord(Node * n, const char * word){
    if (n == NULL) {
        return; 
    }
    
    if(word[0] == '\0') {  // Nothing to insert 
        n->wordCount++;  // A new word end up at this node
        n->prefixCount++;  // A new word is also a prefix of itself
        return; 
    }
    
    n->prefixCount++;  // Becomes a prefix of another word
    int index = word[0] - 'a';  // Index of first char of current input string
    word++;  // Point to next char
    
    if(n->next[index] == NULL) {  // Spawn a new branch
        n->next[index] = CreateNode(); 
    }
    
    AddWord(n->next[index], word); 
}

int Trie::CountWord(Node * n, const char * word){
    if (n == NULL){  // Trie is empty or cannot continue
        return 0; 
    }
    
    if (word[0] == '\0') {
        return n->wordCount; 
    }
    
    int index = word[0] - 'a';
    word++;  // Point to next char
    
    return CountWord(n->next[index], word); 
}

int Trie::CountPrefix(Node * n, const char * prefix) {
    if (n == NULL) {  // Trie is NULL or cannot continue 
        return 0; 
    }
    
    if (prefix[0] == '\0') {  // At last node, no need to go further 
        return n->prefixCount; 
    }
    
    int index = prefix[0] - 'a';  
    prefix++;  // Point to next char 
    
    return CountPrefix(n->next[index], prefix); 
} 

void Trie::Destroy(Node * n) {
    if (n == NULL) {  // Nothing to delete 
        return; 
    }
    
    for (int i = 0; i < 26; i++) {
        if (n->next[i] != NULL) {
            Destroy(n->next[i]); 
        }
    }
    
    delete n; 
}

void Trie::PrintTrie(){
    if (root == NULL) {
        cout << "Cannot print empty trie" << endl; 
        return; 
    }
    
    Node * curr; 
    queue<Node *> q; 
    q.push(root); 
    
    while (q.size() != 0) {
        curr = q.front(); 
        q.pop(); 
        
        for (int i = 0; i < 26; i++) {
            if (curr->next[i] != NULL) {
                cout << (char)(i + 'a') << " "; 
                q.push(curr->next[i]); 
            }
        }
    }
}

Node * Trie::GetRoot() {
    return root; 
}


// Test driver 
int main() {
    Trie t; 
    
    Node * root = t.GetRoot(); 
    
    const char * c = "the"; 
    t.AddWord(root, c); 
    
    c = "their"; 
    t.AddWord(root, c);
    
    c = "there";
    t.AddWord(root, c);
    
    c = "was"; 
    t.AddWord(root, c); 
    
    c = "when"; 
    t.AddWord(root, c);    
    
    t.PrintTrie(); 
    
    c= "was"; 
    cout << t.CountWord(root, c) << endl; 
    
    c = "th"; 
    cout << t.CountPrefix(root, c) << endl; 
    
    return 0; 
}


