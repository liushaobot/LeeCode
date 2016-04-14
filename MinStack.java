/*
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
*/
class MinStack {
    Stack<Integer> stack=new Stack<>();
    int min=Integer.MAX_VALUE;
    public void push(int x) {
        if(x<=min) {stack.push(min); min=x;}
        stack.push(x);
    }
    public void pop() {
        if(stack.peek()==min){ stack.pop(); min=stack.pop(); }
        else stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    
    private List<Integer> stack = new ArrayList<Integer>();
    private List<Integer> min = new ArrayList<Integer>();
    private List<Integer> nMin = new ArrayList<Integer>();
    public void push(int x) {
        stack.add(x);
        if (min.isEmpty() ||  x < min.get(min.size()-1)){
            min.add(x);
            nMin.add(1);
        } else {
            nMin.set(nMin.size()-1, nMin.get(nMin.size()-1) + 1);
        }
    }

    public void pop() {
        stack.remove(stack.size()-1);
        nMin.set(nMin.size()-1, nMin.get(nMin.size()-1) - 1);
        if (nMin.get(nMin.size()-1) == 0){
            min.remove(min.size()-1);
            nMin.remove(nMin.size()-1);
        }
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return min.get(min.size()-1);
    }
}
