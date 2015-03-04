/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length(); ++i){
            char tmp = stringBuilder.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{')
                stack.push(tmp);
            else {
                if (stack.empty())
                    return false;
                char top = (Character)stack.peek();
                if ((top == '(' && tmp == ')') ||
                        (top == '[' && tmp ==']') ||
                        (top == '{' && tmp == '}'))
                    stack.pop();
                else
                    return false;
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }
}
