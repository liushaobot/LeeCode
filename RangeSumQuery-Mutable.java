/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
*/

/**
 * Created by shaobo on 2016/4/5.
 */
public class NumArray {//By myself
    public class SegmentTree{
        int from;
        int to;
        int sum;

        public SegmentTree() {
            from = 0;
            to = 0;
            sum = 0;
        }
    }
    //int[][] segmentTree;
    SegmentTree[] segmentTree;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            segmentTree = new SegmentTree[0];
            return;
        }
        segmentTree = new SegmentTree[nums.length*3];
        for (int i = 0; i < segmentTree.length; ++i) {
            segmentTree[i] = new SegmentTree();
        }
        numArray(nums, segmentTree, 0, nums.length-1, 0);
    }

    public void numArray(int[] nums, SegmentTree[] segmentTree, int from, int to, int index) {
        if (from == to) {
            segmentTree[index].from = from;
            segmentTree[index].to = to;
            segmentTree[index].sum = nums[from];
            return;
        }
        int middle = ((to-from)>>1) + from;
        numArray(nums, segmentTree, from, middle, 2*index+1);
        numArray(nums, segmentTree, middle+1, to, 2*index+2);
        segmentTree[index].from = from;
        segmentTree[index].to = to;
        segmentTree[index].sum = segmentTree[2*index+1].sum + segmentTree[2*index+2].sum;
    }

    void update(int i, int val) {
        if (segmentTree.length == 0) return;
        if (i < segmentTree[0].from || i > segmentTree[0].to) return;
        update(i, val, segmentTree, 0);
    }
    void update(int i, int val, SegmentTree[] segmentTree, int index) {
        if (segmentTree[index].from == segmentTree[index].to && segmentTree[index].from == i) {
            segmentTree[index].sum = val;
            return;
        }
        int middle = ((segmentTree[index].to-segmentTree[index].from)>>1) + segmentTree[index].from;
        if (i <= middle) {
            update(i, val, segmentTree, 2*index+1);
        } else {
            update(i, val, segmentTree, 2*index+2);
        }
        segmentTree[index].sum = segmentTree[2*index+1].sum + segmentTree[2*index+2].sum;
    }

    public int sumRange(int i, int j) {
        if (segmentTree.length == 0)
            return 0;
        return sumRange(i, j, segmentTree, 0);
    }

    public int sumRange(int i, int j, SegmentTree[] segmentTree, int index) {
        if (segmentTree[index].from >= i && segmentTree[index].to <= j)
            return segmentTree[index].sum;
        int middle = ((segmentTree[index].to-segmentTree[index].from)>>1) + segmentTree[index].from;
        if (i >= middle + 1) {
            return sumRange(i, j, segmentTree, 2*index+2);
        } else if (j <= middle) {
            return sumRange(i, j, segmentTree, 2*index+1);
        } else {
            return sumRange(i, middle, segmentTree, 2*index+1) + sumRange(middle+1, j, segmentTree, 2*index+2);
        }
    }
}



// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);