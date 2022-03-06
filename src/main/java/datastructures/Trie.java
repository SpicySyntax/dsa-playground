package datastructures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Trie  {
    public Trie(boolean isWordEnd){
        this.isWordEnd = isWordEnd;
    }
    public boolean isWordEnd = false;
    public Map<Character,Trie> children = new HashMap();
    public static Trie buildTrie(Collection<String> words) {
        Trie root = new Trie(false);
        for (String word : words) {
            insert(root, word);
        }
        return root;
    }
    public static void insert(Trie trie, String word) {
        Trie current = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
                if (i == word.length() - 1) {
                    current.isWordEnd = true;
                }

            } else {
                Trie tmp = new Trie(i == word.length() - 1);
                current.children.put(c, tmp);
                current = tmp;
            }
        }
    }
    public static boolean containsWord(Trie trie, String s) {
        Trie current = trie;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (current.children.containsKey(c)) {
                current = current.children.get(c);

            } else {
                return false;
            }
        }
        return current.isWordEnd;
    }
}
