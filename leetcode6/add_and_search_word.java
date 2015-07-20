/**
 * Implement a data structure that supports addWord and searchWord operation.
 * The idea was to use Trie as the underlying data struction. Recall that Trie
 * node does not store value. The edge represents values. For example, if there 
 * is an edge in node.children[0], it represents there is a letter 'a'. 
 * When implementing addWord, just insert the word into the trie. One thing need 
 * to pay attention is that the children need to have an additional 27th slot to 
 * represent the end of word. 
 * When implementing searchWord, just going through the trie recursively. When it finds '.', 
 * just recursively process each element in children list. 
 * The advantage of using Trie is to compress words that have the same prefix.  
 */ 
public class WordDictionary {
    	public class TrieNode {

		TrieNode[] children = new TrieNode[27];
	}

	private TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		if (word.length() == 0) {
			return;
		}

		char[] arr = word.toCharArray();
		TrieNode curr = root;

		for (int i = 0; i < arr.length; i++) {
			int index = (int) (arr[i] - 'a');

			if (curr.children[index] != null) {
				curr = curr.children[index];
			} else {
				curr.children[index] = new TrieNode();
				curr = curr.children[index];
			}
		}

		curr.children[26] = new TrieNode();
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		int len = word.length();

		if (len == 0) {
			return false;
		}

		char[] arr = word.toCharArray();

		return searchHelper(root, arr, 0);
	}

	private boolean searchHelper(TrieNode curr, char[] arr, int index) {
		if (curr == null) {
			return false;
		}

		if (index == arr.length) {
			if (curr.children[26] != null) {
				return true;
			} else {
				return false;
			}
		}

		if (arr[index] == '.') {
			boolean result = false;

			for (int i = 0; i < 27; i++) {
				if (curr.children[i] != null) {
					result |= searchHelper(curr.children[i], arr, index + 1);
				}

				if (result) {
					return true;
				}
			}

			return result;
		} else {
			if (curr.children[(int) (arr[index] - 'a')] == null) {
				return false;
			}

			return searchHelper(curr.children[(int) (arr[index] - 'a')], arr,
					index + 1);
		}
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
