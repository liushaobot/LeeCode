/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

/**
 * Created by shaobo on 2016/7/25.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) { // 1ms
        int from = gas.length-1;
        int to = 0;
        int remainder = gas[from] - cost[from];
        while (from > to) {
            if (remainder >= 0) {
                remainder += (gas[to] - cost[to]);
                ++to;
            } else {
                --from;
                remainder += (gas[from] - cost[from]);
            }
        }

        return (remainder >= 0) ? from : -1;
    }
    public int canCompleteCircuit1(int[] gas, int[] cost) { //By myself 1ms
        int length = gas.length;

        for (int i = 0; i < 2*length; ++i) {
            if (gas[i % length] >= cost[i % length]) {
                int current = i+1;
                int remainder = gas[i % length] - cost[i % length];
                while (current % length != i) {
                    remainder += (gas[current % length] - cost[current % length]);
                    if (remainder < 0)
                        break;
                    ++current;
                }
                if (remainder >= 0)
                    return current % length;
                else
                    i = current;
            }
        }

        return -1;
    }
}
