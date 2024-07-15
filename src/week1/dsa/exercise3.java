package week1.dsa;
import java.util.ArrayList;
import java.util.List;
public class exercise3 {


    class TrieNode {
        char c;
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(char c) {
            this.c = c;
            this.children = new TrieNode[26];
            this.isEnd = false;
        }

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode(c);
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.isEnd;
        }

        public List<String> startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return new ArrayList<>();
                }
                node = node.children[c - 'a'];
            }
            List<String> result = new ArrayList<>();
            findWords(node, prefix, result);
            return result;
        }

        private void findWords(TrieNode node, String prefix, List<String> result) {
            if (node.isEnd) {
                result.add(prefix);
            }
            for (TrieNode child : node.children) {
                if (child != null) {
                    findWords(child, prefix + child.c, result);
                }
            }
        }
    }

}
