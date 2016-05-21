#Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

[Link to leetcode](https://leetcode.com/problems/implement-trie-prefix-tree/) 

[Link to code solutions](TrieNode.java)

-------------------------------------

##Solution (Using HashMap)

In the TrieNode class, we need a `boolean` propery called `isWord` to check if the current
node is the end of the word. 
In the constructor, initalize `isWord` to `false` and **every** TrieNode has a HashMap called *children*
because each charcater (a-z) has 26 differernt combinations (ex, aa, ab, ac, ad, ae,..., etc). 

Each charcater key in children maps to a new TrieNode.

````Java
class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    HashMap<Character, TrieNode> children;
    public TrieNode() {
        // initially set it to false and create its children
        this.isWord = false;
        this.children = new HashMap<Character, TrieNode>();
    }
}
````

### Insert
Check each character in the given word, if the current tree **DOES NOT** contain
the character, add a new child node. 

````Java
  if (!temp.children.containsKey(c)) {
      temp.children.put(c, new TrieNode());
  }
````
Most importanly, after iterating through the entire character array, 
it also means that we have successfully added the word in the tree.
Therefore, we have to set the property `isWord` to `ture`.


### Search
Traverse the tree to search the word by checking if each node's children contains the charcater.
````Java
  if (!temp.children.containsKey(c)) {
      return false;
  }
````
If one of the node's children does not follow, then the word is not in the tree.
Although sometimes the word is in the tree, it *_DOES NOT_* mean that it will return true
because the word could be some other words' prefix.
In this case, we will have to check if the node's propery `isWord` is set to `true`.

(ex. trie.search("pre"), there's only "prepare" in the tree, so it will not hit the if statement,
but it will return false since pre is not a word)


### startsWith
Looking for prefix is like an easier version of the search function.
As long as the word appears in the tree, we will return ture.
