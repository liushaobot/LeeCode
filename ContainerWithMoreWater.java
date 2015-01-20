/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are
drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms 
a container, such that the container contains the most water.
Note: You may not slant the container.
贪心算法旨在尽可能找到两条距离较远且高度较高的线作为边。从两端开始扫描，当左边的线较短时，只有右移左边的线才可能找到更优的解决方案
；同理，当右边的线较短时，只有左移右边的线才可能找到更优的方案。
*/
public class Solution {
    public int maxArea1(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end){
            int area = (end - start) * Math.min(height[start], height[end]);
            if (area > max)
                max = area;
            if (height[start] <= height[end])
                ++start;
            else
                --end;
        }
        return max;
    }
    
    public int maxArea2(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end){
            int area = (end - start) * Math.min(height[start], height[end]);
            if (area > max)
                max = area;
            if (height[start] <= height[end]){
                int tmp = height[start];
                ++start;
                while (start < end && height[start] <= tmp)
                    ++start;
            }
            else {
                int tmp = height[end];
                --end;
                while (start < end && height[end] <= tmp)
                    --end;
            }
        }
        return max;
    }
}
