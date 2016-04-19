/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> lists = new ArrayList<String>();

        if (s == null || s.length() <= 10)
            return lists;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < s.length()-9; ++i) {
            String subString = s.substring(i, i+10);
            if (hashMap.containsKey(subString)) {
                int cnt = hashMap.get(subString);
                hashMap.put(subString, cnt+1);
            } else {
                hashMap.put(subString, 1);
            }
        }
        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() > 1) {
                lists.add(entry.getKey());
            }
        }

        return lists;
    }
}
