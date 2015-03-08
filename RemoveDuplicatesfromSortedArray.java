/*
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2]. 
*/
public class Solution {
    public int removeDuplicates1(int[] A) {
        if (A.length == 0)
            return 0;
        int indexOld = 0, indexNew = 0;
        int length = A.length;
        for (;indexOld < length; ++indexOld){
            if (A[indexNew] != A[indexOld])
                A[++indexNew] = A[indexOld];
        }
        return indexNew + 1;
    }
    
    public int removeDuplicates2(int[] A) {
        int length = A.length;
        int count = 0;
        for(int i = 1; i < length; i++){
            if(A[i] == A[i-1]) count++;
            else A[i-count] = A[i];
        }
        return length-count;
    }
}
