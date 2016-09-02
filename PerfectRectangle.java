/*
Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).


Example 1:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]

Return true. All 5 rectangles together form an exact cover of a rectangular region.

Example 2:

rectangles = [
  [1,1,2,3],
  [1,3,2,4],
  [3,1,4,2],
  [3,2,4,4]
]

Return false. Because there is a gap between the two rectangular regions.

Example 3:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [3,2,4,4]
]

Return false. Because there is a gap in the top center.

Example 4:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [2,2,4,4]
]

Return false. Because two of the rectangles overlap with each other.
*/

public class Solution {
    Map<String, Integer> map = new HashMap<String, Integer>();
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) return false;
        int lx = Integer.MAX_VALUE, ly = lx, rx = Integer.MIN_VALUE, ry = rx, sum = 0;
        for (int[] rec : rectangles) {
            lx = Math.min(lx, rec[0]);
            ly = Math.min(ly, rec[1]);
            rx = Math.max(rx, rec[2]);
            ry = Math.max(ry, rec[3]);
            sum += (rec[2] - rec[0]) * (rec[3] - rec[1]);
            //bottom-left
            if (overlap(rec[0] + " " + rec[1], 1)) return false;
            //top-left
            if (overlap(rec[0] + " " + rec[3], 2)) return false;
            //bottom-right
            if (overlap(rec[2] + " " + rec[1], 4)) return false;
            //top-right
            if (overlap(rec[2] + " " + rec[3], 8)) return false;
        }
        int count = 0;
        Iterator<Integer> iter = map.values().iterator();
        while (iter.hasNext()) {
            Integer i = iter.next();
            if (i != 15 && i != 12 && i != 10 && i != 9 && i != 6 && i != 5 && i != 3) count++;
        }
        return count == 4 && sum == (rx - lx) * (ry - ly);
    }
    
    private boolean overlap(String corner, Integer type) {
        Integer temp = map.get(corner);
        if (temp == null) temp = type;
        else if ((temp & type) != 0) return true;
        else temp |= type;
        map.put(corner, temp);
        return false;
    }
}
