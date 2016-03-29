/**
 * Created by shaobo on 2016/3/29.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length-1);
    }

    public int findKthLargest(int[] nums, int k, int from, int to) {
        int From = from, To = to;
        int pivot = nums[from];
        while (from < to) {
            while (from < to && nums[to] <= pivot) --to;
            nums[from] = nums[to];
            while (from < to && nums[from] >= pivot) ++from;
            nums[to] = nums[from];
        }
        nums[from] = pivot;
        if (from == k-1)
            return nums[from];
        else if (from > k-1)
            return findKthLargest(nums, k, From, from-1);
        else
            return findKthLargest(nums, k, from+1, To);
    }
    public int findKthLargest1(int[] nums, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; ++i) {
            heap[i] = nums[i];
        }
        buildHeap(heap);

        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                shiftDown(heap, 0);
            }
        }

        return heap[0];
    }

    public void buildHeap(int[] heap) {
        for (int index = (heap.length-1)>>1; index >= 0; --index) {
            shiftDown(heap, index);
        }
    }

    public void shiftDown(int[] heap, int node) {
        while ((2*node+1 < heap.length) || (2*node+2 < heap.length)) {
            if (2*node+2 < heap.length) {
                if (heap[node] > heap[2*node+1] || heap[node] >heap[2*node+2]) {
                    if (heap[2*node+1] < heap[2*node+2]) {
                        swap(heap, node, 2 * node + 1);
                        node = 2*node+1;
                    }
                    else {
                        swap(heap, node, 2 * node + 2);
                        node = 2*node+2;
                    }
                } else
                    break;
            } else {
                if (heap[node] > heap[2*node+1]) {
                    swap(heap, node, 2*node+1);
                    node = 2*node+1;
                } else
                    break;
            }
        }
    }

    public void swap(int[] heap, int from, int to) {
        if (from == to) return;
        int tmp = heap[from];
        heap[from] = heap[to];
        heap[to] = tmp;
    }
}
