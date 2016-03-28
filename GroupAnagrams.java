/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/

/**
 * Created by shaobo on 2016/3/28.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);
            List<String> list = hashMap.get(sorted);
            if (list == null) {
                list = new ArrayList<String>();
            }
            list.add(str);
            hashMap.put(sorted, list);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> list : hashMap.values()) {
            Collections.sort(list);
            result.add(list);
        }
        hashMap.clear();

        return result;
    }
}
