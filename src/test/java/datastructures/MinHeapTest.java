package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class MinHeapTest {
    @Test
    public void testGetMin() {
        var vals  = new int[] {
                6, 3, 5, 2, 4, 1, 0, 10, 7, 9, 8
        };
        var minHeap = new MinHeap();
        for (int val : vals) {
            minHeap.add(val);
        }

        Assert.assertEquals(minHeap.getMin(), 0);
    }
    @Test
    public void testRemoveMin() {
        var vals  = new int[] {
                6, 3, 5, 2, 4, 1, 0, 10, 7, 9, 8
        };
        var minHeap = new MinHeap();
        for (int val : vals) {
            minHeap.add(val);
        }

        Assert.assertEquals(minHeap.popMin(), 0);
        Assert.assertEquals(minHeap.popMin(), 1);
        Assert.assertEquals(minHeap.popMin(), 2);
        Assert.assertEquals(minHeap.popMin(), 3);




    }
}
