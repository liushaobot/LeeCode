/*
https://leetcode.com/problems/largest-rectangle-in-histogram/

 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
The width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
For example,
Given height = [2,1,5,6,2,3],
return 10. 

如果确定了长方形的左端点L和右端点R，那么最大可能的高度就是min{h[i]|L <= i < R}。
L[i] = (j <= i并且h[j-1] < h[i]的最大的j)
R[i] = (j > i并且h[j] < h[i]的最小的j)
*/

public class Solution {
    public int largestRectangleArea1(int[] height) {
        int length = height.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] stack = new int[length];

        int ans = 0, t = 0;
        //计算L
        for (int i = 0; i < length; ++i){
            while (t > 0 && height[stack[t-1]] >= height[i]) t--;
            L[i] = (t == 0) ? 0 : (stack[t-1] + 1);
            stack[t++] = i;
        }

        //计算R
        t = 0;
        for (int i = length - 1; i >= 0; --i){
            while (t > 0 && height[stack[t-1]] >= height[i]) t--;
            R[i] = (t == 0) ? length : stack[t-1];
            stack[t++] = i;
        }

        for (int i = 0; i < length; ++i){
            ans = Math.max(ans, height[i] * (R[i] - L[i]));
        }
        return ans;
    }
    
    public int largestRectangleArea2(int[] height) {
     //http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
