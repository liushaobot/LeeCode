/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

Hints:
This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) { // 11ms
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incLinkCounts, adjs, prerequisites);
        return solveByBFS(incLinkCounts, adjs);
    }

    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites){
        int n = incLinkCounts.length;
        while (n-- > 0) adjs.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }

    private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs){
        int[] order = new int[incLinkCounts.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++) {
            if (incLinkCounts[i] == 0) toVisit.offer(i);
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) toVisit.offer(to);
            }
        }
        return visited == incLinkCounts.length ? order : new int[0];
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) { // By myself a little improvement -- 36ms
        int[] res = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                res[index++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (x == prerequisite[1]) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                        res[index++] = prerequisite[0];
                    }
                }
            }
        }
        /////////////////////////////////////
        return (index == numCourses) ? res : new int[0];
        /////////////////////////////////////
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) { //By myself slow -- 71ms
        int[] res = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                res[index++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (x == prerequisite[1]) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                        res[index++] = prerequisite[0];
                    }
                }
            }
        }
        /////////////////////////////////////
        for (int in : inDegree) {
            if (in != 0)
                return new int[0];
        }

        return res;
        /////////////////////////////////////
    }
}