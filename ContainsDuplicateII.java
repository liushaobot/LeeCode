/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that 
nums[i] = nums[j] and the difference between i and j is at most k.
*/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {//HashMap
        if (nums == null || nums.length <= 1) return false;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                if (i-map.get(nums[i]) <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
            else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    
    
    public class Arr {
        int data;
        int index;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {//Sort
        Arr[] arr = new Arr[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            arr[i] = new Arr();
            arr[i].data = nums[i];
            arr[i].index = i;
        }
        Arrays.sort(arr, new Comparator<Arr>() {
            @Override
            public int compare(Arr o1, Arr o2) {
                return o1.data - o2.data;
            }
        });

        for (int i = 0; i < arr.length-1; ++i) {
            if (arr[i].data == arr[i+1].data &&
                    Math.abs(arr[i].index - arr[i+1].index) <= k)
                return true;
        }
        return false;
    }

}
