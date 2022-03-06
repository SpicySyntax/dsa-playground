package datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class TrieTest {
    @Test
    public void testTrieLoad() {
        Collection<String> words = List.of(
                "car", "careful", "care", "cat", "be", "bear", "as", "a"
        );


        Trie trie = Trie.buildTrie(words);

        for (var word : words) {
            Assert.assertTrue(Trie.containsWord(trie, word));
        }

        Assert.assertFalse(Trie.containsWord(trie, "this_word_not_in_the_trie"));


    }
}
