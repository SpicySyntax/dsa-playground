package datastructures;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int[] items = new int[capacity];
    private int size = 0;
    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        bubbleUp(size);
        this.size++;
    }
    public void ensureCapacity() {
        if (size == capacity) {
            this.capacity = this.capacity * 2;
            this.items = Arrays.copyOf(this.items, this.capacity);
        }
    }
    public static int getParent(int index) {
        if (index == 0) return -1;
        return (int)Math.ceil((index + 0.0) /2) - 1;
    }
    public static int getLeftChild(int index) {
        return index * 2 + 1;
    }
    public static int getRightChild(int index) {
        return index * 2 + 2;
    }
    public void swap(int index1, int index2) {
        int tmp = items[index1];
        items[index1] = items[index2];
        items[index2] = tmp;
    }
    public void bubbleUp(int index) {
        if (index <= 0) return;
        int parent = getParent(index);
        if (parent < 0) return;

        if (items[index] < items[parent]) {
            swap(index, parent);
            bubbleUp(parent);
        }
    }
    public void bubbleDown(int index) {
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);
        if (leftChild > size) return;
        if (rightChild > size) {
            if (items[index] > items[leftChild]) {
                swap(index, leftChild);
                bubbleDown(leftChild);
            }
        } else if (items[leftChild] < items[rightChild]) {
            if (items[index] > items[leftChild]) {
                swap(index, leftChild);
                bubbleDown(leftChild);
            }
        } else {
            if (items[index] > items[rightChild]) {
                swap(index, rightChild);
                bubbleDown(rightChild);
            }
        }
    }
    public int delete(int index) {
        int item = items[index];
        items[index] = items[size - 1];
        items[size - 1] = 0;
        size--;
        bubbleDown(index);
        return item;
    }
    public int getMin() {
        return items[0];
    }
    public int popMin() {
        return delete(0);
    }
}
