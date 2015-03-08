/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length. 
*/
public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0)
            return 0;
        int start = 0, end = A.length - 1;
        while (start < end){
            while (start < end && A[start] != elem) ++start;
            while (start < end && A[end] == elem) --end;
            A[start] = A[end];
            --end;
        }
        return start + ((A[start] != elem) ? 1 : 0);
    }
}
