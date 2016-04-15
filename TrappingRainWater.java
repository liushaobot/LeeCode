/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
*/
/**
 * Created by shaobo on 2016/4/15.
 */
public class Solution {
    public int trap(int[] height) {//2ms
        if (height.length < 3) return 0;

        int water = 0;
        int l = 0, r = height.length - 1;

        // find the left and right edge which can hold water
        while (l < r && height[l] <= height[l + 1]) ++l;
        while (l < r && height[r] <= height[r - 1]) --r;

        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (left <= right) {
                // add volum until an edge larger than the left edge
                while (l < r && left >= height[++l]) {
                    water += left - height[l];
                }
            } else {
                // add volum until an edge larger than the right volum
                while (l < r && height[--r] <= right) {
                    water += right - height[r];
                }
            }
        }
        return water;
    }
    public int trap2(int[] height) {//2ms
        int left = 0;
        int right = height.length-1;
        int water = 0;
        int maxleft = 0, maxright = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= maxleft)
                    maxleft = height[left];
                else
                    water += maxleft-height[left];
                ++left;
            }
            else{
                if(height[right] >= maxright)
                    maxright = height[right];
                else
                    water += maxright-height[right];
                --right;
            }
        }
        return water;
    }

    public int trap1(int[] height) {//2ms
        if (height == null || height.length <= 2)
            return 0;

        int highest = 0;
        int water = 0;
        //from left to right, only consider the trap's left elevation
        for (int i = 0; i < height.length; ++i) {
            if (height[i] < highest)
                water += highest - height[i];
            else
                highest = height[i];
        }

        int prehighest = highest;
        highest = 0;
        //from right to left, only consider the trap's right elevation, subtract the surplus water
        for (int i = height.length-1; i >= 0; --i) {
            highest = Math.max(highest, height[i]);
            if (highest < prehighest)
                water -= prehighest-highest;
        }

        return water;
    }
}
