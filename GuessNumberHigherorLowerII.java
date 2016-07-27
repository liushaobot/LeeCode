/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

Hint:

The best strategy to play the game is to minimize the maximum loss you could possibly face. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
Take a small example (n = 3). What do you end up paying in the worst case?
Check out this article if you're still stuck.
The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming.
As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, instead of the worst-case loss?
*/

/**
 * Created by shaobo on 2016/7/22.
 */
public class Solution {
    public int getMoneyAmount(int n) {
        // all intervals are inclusive
        // uninitialized cells are assured to be zero
        // the zero column and row will be uninitialized
        // the illegal cells will also be uninitialized
        // add 1 to the length just to make the index the same as numbers used
        int[][] dp = new int[n + 1][n + 1]; // dp[i][j] means the min cost in the worst case for numbers (i...j)

        // iterate the lengths of the intervals since the calculations of longer intervals rely on shorter ones
        for (int l = 2; l <= n; l++) {
            // iterate all the intervals with length l, the start of which is i. Hence the interval will be [i, i + (l - 1)]
            for (int i = 1; i <= n - (l - 1); i++) {
                dp[i][i + (l - 1)] = Integer.MAX_VALUE;
                // iterate all the first guesses g
                for (int g = i; g <= i + (l - 1); g++) {
                    int costForThisGuess;
                    // since if g is the last integer, g + 1 does not exist, we have to separate this case
                    // cost for [i, i + (l - 1)]: g (first guess) + max{the cost of left part [i, g - 1], the cost of right part [g + 1, i + (l - 1)]}
                    if (g == n) {
                        costForThisGuess = dp[i][g - 1] + g;
                    } else {
                        costForThisGuess = g + Math.max(dp[i][g - 1], dp[g + 1][i + (l - 1)]);
                    }
                    dp[i][i + (l - 1)] = Math.min(dp[i][i + (l - 1)], costForThisGuess); // keep track of the min cost among all first guesses
                }
            }
        }
        return dp[1][n];
    }

    public int getMoneyAmount(int n) { //a little improvement :)
        int[][] dp = new int[n+1][n+1];
        for(int len=1;len<n;len++){
            for(int i=1;i+len<=n;i++){
                int j=i+len;
                int min = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int tmp = k+Math.max(dp[i][k-1],dp[k+1][j]);
                    min = Math.min(min,tmp);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }
}
