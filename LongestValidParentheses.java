/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
Dynamic Programming(动态规划)
*/
public class Solution {
    public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<Integer>();
    int max=0;
    int from = -1;
    char[] S = s.toCharArray();
    for(int j=0;j<s.length();j++){
        if(S[j]=='(') stack.push(j);            
        else {//S[j] == ')'
            if (stack.isEmpty()) from=j;//from指向最右边未匹配的')'
            else{
                stack.pop();
                if(stack.isEmpty()) max=Math.max(max,j-from);
                else max=Math.max(max,j-stack.peek());
               }
            }
        }
    return max;
    }
}
