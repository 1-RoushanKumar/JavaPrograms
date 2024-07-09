package com.roushan._20_TrieDataStructure;

// TrieNode2 class definition
class TrieNode2 {
    TrieNode2[] child = new TrieNode2[26]; // Array to hold children nodes for each character (a-z)
    int countEndWith = 0; // Count of words ending at this node
    int countPrefix = 0; // Count of words having this prefix
}

// Trie2 class definition
class Trie2 {
    TrieNode2 root = new TrieNode2(); // Root of the Trie

    // Method to insert a word into the Trie
    public void insert(String key) {
        TrieNode2 curr = root; // Start from the root node
        for (int i = 0; i < key.length(); i++) { // Iterate over each character in the word
            int index = key.charAt(i) - 'a'; // Calculate the index (0-25) for each character
            if (curr.child[index] == null) { // If the child node for this character doesn't exist
                curr.child[index] = new TrieNode2(); // Create a new TrieNode2
            }
            curr.child[index].countPrefix++; // Increment the countPrefix
            curr = curr.child[index]; // Move to the child node
        }
        curr.countEndWith++; // Increment the countEndWith at the end of the word
    }
    // Time complexity: O(m), where m is the length of the word

    // Method to count words in the Trie equal to the given key
    public int countWordsEqualTo(String key) {
        TrieNode2 curr = root; // Start from the root node
        for (int i = 0; i < key.length(); i++) { // Iterate over each character in the word
            int index = key.charAt(i) - 'a'; // Calculate the index for each character
            if (curr.child[index] == null) { // If the child node for this character doesn't exist
                return 0; // Word is not in the Trie
            }
            curr = curr.child[index]; // Move to the child node
        }
        return curr.countEndWith; // Return the countEndWith for the word
    }
    // Time complexity: O(m), where m is the length of the word

    // Method to count words in the Trie starting with the given prefix
    public int countWordsStartingWith(String prefix) {
        TrieNode2 curr = root; // Start from the root node
        for (int i = 0; i < prefix.length(); i++) { // Iterate over each character in the prefix
            int index = prefix.charAt(i) - 'a'; // Calculate the index for each character
            if (curr.child[index] == null) { // If the child node for this character doesn't exist
                return 0; // No word in the Trie starts with the given prefix
            }
            curr = curr.child[index]; // Move to the child node
        }
        return curr.countPrefix; // Return the countPrefix for the prefix
    }
    // Time complexity: O(m), where m is the length of the prefix
}

public class _02_Trie2_0 {
    // Main method for testing
    public static void main(String[] args) {
        Trie2 trie = new Trie2(); // Create a Trie2 object
        trie.insert("apple"); // Insert "apple" into the Trie
        trie.insert("app"); // Insert "app" into the Trie
        trie.insert("apple"); // Insert "apple" again into the Trie

        // Count words equal to the given keys
        System.out.println(trie.countWordsEqualTo("apple")); // 2, since "apple" was inserted twice
        System.out.println(trie.countWordsEqualTo("app")); // 1, since "app" was inserted once

        // Count words starting with the given prefix
        System.out.println(trie.countWordsStartingWith("app")); // 3, since both "apple" and "app" start with "app"
    }
}
