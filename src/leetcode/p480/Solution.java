package leetcode.p480;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        DualHeap tool = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            tool.insert(nums[i]);
        }
        res[0] = tool.getMedia();
        for (int i = k; i < nums.length; i++) {

            tool.insert(nums[i]);
            tool.delete(nums[i - k]);
            res[i - k + 1] = tool.getMedia();
        }
        return res;

    }
}

class DualHeap {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> big;
    private Map<Integer, Integer> delayDelete;
    private int k;
    private int smallSize;
    private int bigSize;

    public DualHeap(int k) {
        this.small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        this.big = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        this.k = k;
        this.bigSize = 0;
        this.smallSize = 0;
        delayDelete = new HashMap<>();
    }
//if the arg is Integer i, it can't pass
    public void insert(int i) {
        if (smallSize == 0 || i <= small.peek()) {
            small.offer(i);
            smallSize++;
        } else {
            big.offer(i);
            bigSize++;
        }
        balance();
    }

    public void delete(int i) {
        delayDelete.put(i, delayDelete.getOrDefault(i, 0) + 1);
        if (i <= small.peek()) {
            smallSize--;
            if (i == small.peek()) {
                prune(small);
            }
        } else {
            bigSize--;
            if (i == big.peek()) {
                prune(big);
            }
        }
        balance();
    }

    public double getMedia() {
        //check whether k is odd
        return (k & 1) == 1 ? small.peek() : (((double) big.peek() + small.peek())) / 2;
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayDelete.containsKey(num)) {
                delayDelete.put(num, delayDelete.get(num) - 1);
                if (delayDelete.get(num) == 0) {
                    delayDelete.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }

    private void balance() {
        if (smallSize > bigSize + 1) {
            big.offer(small.poll());
            smallSize--;
            bigSize++;
            prune(small);
        } else if (smallSize < bigSize) {
            small.offer(big.poll());
            smallSize++;
            bigSize--;
            prune(big);
        }
    }
}