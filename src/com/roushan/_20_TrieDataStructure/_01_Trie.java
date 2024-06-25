package com.roushan._20_TrieDataStructure;

// TrieNode class definition
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // Array to hold children nodes for each character (a-z)
    boolean isEnd; // Flag to mark the end of a word

    // Constructor to initialize a TrieNode
    public TrieNode() {
        this.isEnd = false;
        for (int i = 0; i < 26; i++) {
            this.children[i] = null;
        }
    }
}

// Trie class definition
class Trie {
    private final TrieNode root; // Root of the Trie

    // Constructor to initialize the Trie
    public Trie() {
        root = new TrieNode();
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) { // Iterate over each character in the word
            int index = word.charAt(i) - 'a'; // Calculate the index (0-25) for each character
            if (node.children[index] == null) { // If the child node for this character doesn't exist
                node.children[index] = new TrieNode(); // Create a new TrieNode
            }
            node = node.children[index]; // Move to the child node
        }
        node.isEnd = true; // Mark the end of the word
    }
    // Time complexity: O(m), where m is the length of the word

    // Method to search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) { // Iterate over each character in the word
            int index = word.charAt(i) - 'a'; // Calculate the index for each character
            if (node.children[index] == null) { // If the child node for this character doesn't exist
                return false; // Word is not in the Trie
            }
            node = node.children[index]; // Move to the child node
        }
        return node.isEnd; // Return true if it's the end of the word
    }
    // Time complexity: O(m), where m is the length of the word

    // Method to check if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root; // Start from the root node
        for (int i = 0; i < prefix.length(); i++) { // Iterate over each character in the prefix
            int index = prefix.charAt(i) - 'a'; // Calculate the index for each character
            if (node.children[index] == null) { // If the child node for this character doesn't exist
                return false; // No word in the Trie starts with the given prefix
            }
            node = node.children[index]; // Move to the child node
        }
        return true; // If all characters in the prefix are found, return true
    }
    // Time complexity: O(m), where m is the length of the prefix

    // Method to delete a word from the Trie
    public void delete(String key) {
        delete(root, key, 0); // Start the recursive deletion from the root node
    }
    // Time complexity: O(m), where m is the length of the word

    // Recursive method to delete a word from the Trie
    private TrieNode delete(TrieNode root, String key, int i) {
        if (root == null) { // If the current node is null
            return null;
        }
        if (i == key.length()) { // If we have reached the end of the key
            root.isEnd = false; // Unmark the end of the word
            if (isEmpty(root)) { // If the current node has no children
                return null; // Delete the current node
            }
            return root; // Return the current node
        }
        int index = key.charAt(i) - 'a'; // Calculate the index for the current character
        root.children[index] = delete(root.children[index], key, i + 1); // Recursively delete the child node
        if (isEmpty(root) && !root.isEnd) { // If the current node has no children and is not the end of another word
            return null; // Delete the current node
        }
        return root; // Return the current node
    }

    // Helper method to check if a node has no children
    private boolean isEmpty(TrieNode root) {
        for (int i = 0; i < 26; i++) { // Check each child of the node
            if (root.children[i] != null) { // If any child is not null
                return false; // Node is not empty
            }
        }
        return true; // Node is empty
    }

    // Method to print all words in the Trie in lexicographical order
    public void printWords() {
        printWords(root, ""); // Start from the root node with an empty prefix
    }

    // Recursive method to print all words in the Trie
    private void printWords(TrieNode node, String prefix) {
        if (node.isEnd) { // If the current node is the end of a word
            System.out.print(prefix+" "); // Print the current prefix
        }
        for (int i = 0; i < 26; i++) { // Iterate over all possible children (a-z)
            if (node.children[i] != null) { // If the child node exists
                printWords(node.children[i], prefix + (char) (i + 'a')); // Recursively print words from the child node with the updated prefix
            }
        }
    }
    // Time complexity: O(n), where n is the total number of nodes in the Trie
}

public class _01_Trie {
    // Main method for testing
    public static void main(String[] args) {
        Trie trie = new Trie(); // Create a Trie object
        trie.insert("bad");
        trie.insert("bat");
        trie.insert("geek");
        trie.insert("cat");
        trie.insert("zoo");
        trie.insert("geeks");
        trie.insert("cut");

        // Print all words in the Trie in lexicographical order
        System.out.println("Words in Trie in lexicographical order:");
        trie.printWords();
        System.out.println();

        // Search for words in the Trie
        System.out.println(trie.search("bat"));
        System.out.println(trie.search("geeky"));
        System.out.println(trie.search("cut"));
        System.out.println();

        // Check if any word starts with the given prefix
        System.out.println(trie.startsWith("gee"));
        System.out.println(trie.startsWith("ban"));
        System.out.println(trie.startsWith("ba"));
        System.out.println();

        trie.delete("zoo");
        trie.delete("geek");
        System.out.println(trie.search("geek"));
        System.out.println(trie.search("geeks"));
        System.out.println();

        // Print all words in the Trie in lexicographical order
        System.out.println("Words in Trie in lexicographical order:");
        trie.printWords();
    }
}
