/*
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
Reference：http://blog.csdn.net/jdplus/article/details/20283845
*/
public class Solution {
    public void nextPermutation(int[] num) {
        int from = num.length - 1;
        while (from != 0 && num[from-1] >= num[from])
            --from;
        if (from == 0)
            reverse(num, 0, num.length-1);
        else {
            int index = from -1;
            int to = num.length - 1;
            while (num[to] <= num[index]) --to;
            swap(num, index, to);
            reverse(num, from, num.length -1);
        }
    }

    public void reverse(int[] num, int from, int to){
        while (from < to){
            swap(num, from, to);
            ++from;
            --to;
        }
    }

    public void swap(int[] num, int from, int to){
        int tmp = num[from];
        num[from] = num[to];
        num[to] = tmp;
    }
}
