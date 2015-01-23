/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want. 

*/

/*
递归解法
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        List<List<String>> letter = new ArrayList<List<String>>();
        StringBuilder stringBuilder = new StringBuilder();
        letter.add(new ArrayList<String>());
        letter.add(new ArrayList<String>());
        letter.add(new ArrayList<String>(Arrays.asList("a", "b", "c")));
        letter.add(new ArrayList<String>(Arrays.asList("d", "e", "f")));
        letter.add(new ArrayList<String>(Arrays.asList("g", "h", "i")));
        letter.add(new ArrayList<String>(Arrays.asList("j", "k", "l")));
        letter.add(new ArrayList<String>(Arrays.asList("m", "n", "o")));
        letter.add(new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
        letter.add(new ArrayList<String>(Arrays.asList("t", "u", "v")));
        letter.add(new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));
        StringBuilder digit = new StringBuilder();
        for (int i = 0; i < digits.length(); ++i){
            if (digits.charAt(i) > '1')
                digit.append(digits.charAt(i));
        }
        combinations(digit.toString(), stringBuilder, result, letter, 0);
        return result;
    }

    public void combinations(String digits,StringBuilder stringBuilder, List<String> result, List<List<String>> letter, int index){
        if (index == digits.length()){
            result.add(stringBuilder.toString());
        } else {
            int row = (int)(digits.charAt(index) - '0');
            for (String string : letter.get(row)){
                stringBuilder.append(string);
                combinations(digits, stringBuilder, result, letter, index+1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
    }
}
