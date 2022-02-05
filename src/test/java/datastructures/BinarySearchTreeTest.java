package datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeTest {
    public static BinarySearchTree buildExample() {
        BinarySearchTree tree = new BinarySearchTree();
        List<Integer> values = new ArrayList<>() {
            {
                add(3);
                add(2);
                add(5);
                add(1);
                add(4);
                add(6);
            }
        };
        for (int value : values) {
            tree.insert(value);
        }
        return tree;
    }
    public static BinarySearchTree buildBalancedExample() {
        BinarySearchTree tree = new BinarySearchTree();
        List<Integer> values = new ArrayList<>() {
            {
                add(5);
                add(3);
                add(7);
                add(2);
                add(4);
                add(6);
                add(8);
            }
        };
        for (int value : values) {
            tree.insert(value);
        }
        return tree;
    }
    @Test
    public void testInOrder() {
        var tree = buildExample();
        tree.inOrder();
    }
    @Test
    public void testSearchWhenValueFound() {
        var tree = buildExample();
        int four = 4;
        var node = tree.search(four);
        Assert.assertEquals(four, node.getValue());
    }
    @Test
    public void testSearchWhenValueNotFound() {
        var tree = buildExample();
        int seven = 7;
        var node = tree.search(seven);
        Assert.assertNull(node);
    }
    @Test
    public void testDeleteWhenFound() {
        var tree = buildExample();
        int four = 4;
        var node = tree.search(four);
        Assert.assertEquals(four, node.getValue());
        tree.delete(four);
        node = tree.search(four);
        Assert.assertNull(node);
    }
    @Test
    public void testDeleteOnFoundBalanced() {
        var tree = buildBalancedExample();
        int seven = 7;
        var node = tree.search(seven);
        Assert.assertEquals(node.getValue(), seven);
        tree.delete(7);
        node = tree.search(seven);
        Assert.assertNull(node);
        tree.inOrder();
    }
}
