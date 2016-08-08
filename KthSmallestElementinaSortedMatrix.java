/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

import java.util.PriorityQueue;

/**
 * Created by shaobo on 2016/8/8.
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        int bound = matrix.length < k ? matrix.length : k;
        for(int j = 0; j < bound; j++)  {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == matrix.length-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}
