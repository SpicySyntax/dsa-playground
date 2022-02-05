package datastructures;

import java.util.List;
import java.util.Stack;

public class BinarySearchTree {
    Node root;
    int count = 0;
    public BinarySearchTree() {

    }
    public BinarySearchTree(int value) {
        root = new Node(value);
    }
    public BinarySearchTree(Node root) {
        this.root = root;
    }
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(value, root);
        }
    }
    private void insert(int value, Node subTree) {
        if (value > subTree.getValue()){
            if (subTree.getRight() == null) {
                var newNode = new Node(value);
                newNode.setParent(subTree);
                subTree.setRight(newNode);
            } else {
                insert(value, subTree.getRight());
            }
        } else {
            if (subTree.getLeft() == null) {
                var newNode = new Node(value);
                newNode.setParent(subTree);
                subTree.setLeft(newNode);
            } else {
                insert(value, subTree.getLeft());
            }
        }
    }
    public void delete(int value) {
        Node node = search(value);
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                // no children
                if (node.getValue() > node.getParent().getValue()) {
                    node.getParent().setRight(null);
                } else {
                    node.getParent().setLeft(null);
                }
            } else if (node.getLeft() == null) {
                // just right child
                if (node.getValue() > node.getParent().getValue()) {
                    node.getParent().setRight(node.getRight());
                } else {
                    node.getParent().setLeft(node.getRight());
                }
            } else if (node.getRight() == null) {
                // just left child
                if (node.getValue() > node.getParent().getValue()) {
                    node.getParent().setRight(node.getLeft());
                } else {
                    node.getParent().setLeft(node.getLeft());
                }
            } else {
                // both children
                if (node.getValue() > node.getParent().getValue()) {
                    node.getParent().setRight(merge(node.getRight(), node.getLeft()));
                } else {
                    node.getParent().setLeft(merge(node.getRight(), node.getLeft()));
                }

            }
        }
    }
    public Node merge(Node mergeInto, Node insertFrom){
        if (mergeInto == null && insertFrom == null){
            return null;
        }
        if (mergeInto == null) {
            return insertFrom;
        }
        if (insertFrom == null) {
            return mergeInto;
        }
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.add(insertFrom);
        while (!nodeStack.empty()) {
            var node = nodeStack.pop();
            if (node.getLeft() != null) {
                nodeStack.add(node.getLeft());
            }
            if (node.getRight() != null) {
                nodeStack.add(node.getRight());
            }
            insert(node.getValue(), mergeInto);
        }
        return mergeInto;
    }
    public Node search(int value) {
        Node current = root;
        while (current != null) {
            if (current.getValue() == value) {
                break;
            } else if (value > current.getValue()) {
                current = current.getRight();

            } else {
                current = current.getLeft();
            }
        }
        return current;
    }

    public void preOrder() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }
    public void inOrder() {
       inOrder(root);
    }
    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.getLeft());
        System.out.println(node.value);
        inOrder(node.getRight());
    }
//    public List<T> postOrder() {
//
//    }
}
