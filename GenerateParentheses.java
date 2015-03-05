/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" 
有两个集合，各有n个'('、')'，从中取元素，但保证任何时候取得'('的个数要比')'的个数大。
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0)
            return result;
        String parenthesis = new String();
        int left = n, right = n;
        recursive(result, parenthesis, left, right);
        return result;
    }
    public void recursive(List<String> result, String parenthesis, int left, int right){
        if (left == 0 && right == 0)
            result.add(parenthesis);
        else {
            if (left > 0)
                recursive(result, parenthesis + "(", left - 1, right);
            if (right > left)
                recursive(result, parenthesis + ")", left, right - 1);
        }
    }
}

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder parenthesis = new StringBuilder();
        recursive(result, parenthesis, -1, 0, n);
        return result;
    }

    public void recursive(List<String> result, StringBuilder parenthesis, int index, int cnt, int n){
        if (cnt == n && index == -1)
            result.add(new String(parenthesis));
        else {
            if (cnt < n){
                parenthesis.append('(');
                int inx = parenthesis.length()-1;
                recursive(result, parenthesis, inx, cnt+1, n);
                parenthesis.deleteCharAt(inx);
            }
            if (index > -1){
                parenthesis.append(')');
                index -= 1;
                int tcnt = 0;
                while (index > -1 && !(tcnt == 0 && parenthesis.charAt(index) == '(')){
                    if (parenthesis.charAt(index) == ')')
                        ++tcnt;
                    else
                        --tcnt;
                    --index;
                }
                recursive(result, parenthesis, index, cnt, n);
                int inx = parenthesis.length() - 1;
                parenthesis.deleteCharAt(inx);
            }
        }
    }
}
