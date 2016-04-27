/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {//1ms Recursive
        List<LinkedList<Integer>> res = new ArrayList<>();

        helper(res,root,0);

        List<List<Integer>> finalRes = new ArrayList<>();
        finalRes.addAll(res);
        return finalRes;
    }

    public void helper(List<LinkedList<Integer>> res, TreeNode root, int level){
        if(root == null)
            return;
        if(res.size() <= level)
            res.add(new LinkedList<>());

        if((level + 1) % 2 != 0)
            res.get(level).add(root.val);
        else
            res.get(level).addFirst(root.val);

        helper(res,root.left,level + 1);
        helper(res,root.right,level + 1);     
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {//2ms BFS
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
    
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        while(!q.isEmpty()){
            LinkedList<Integer> path = new LinkedList<>();
            int levelNums = q.size();
    
            for(int i = 0; i < levelNums; i++){
                root = q.poll();
                if(level % 2 != 0){
                    path.add(root.val);
                }else{
                    path.addFirst(root.val);
                }
    
                if(root.left != null)
                    q.offer(root.left);
                if(root.right != null)
                    q.offer(root.right);
            }
            res.add(path);
            level++;
        }
    
        return res;
    }
}
