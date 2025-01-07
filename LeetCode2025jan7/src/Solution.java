import java.util.*;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;
        int INF = Integer.MAX_VALUE / 2;

        // Step 1: Initialize the cost matrix
        int[][] minCost = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(minCost[i], INF);
            minCost[i][i] = 0; // No cost to convert a character to itself
        }

        // Step 2: Fill in the cost matrix based on the input
        for (int i = 0; i < m; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            minCost[from][to] = Math.min(minCost[from][to], cost[i]);
        }

        // Step 3: Use Floyd-Warshall to compute shortest paths
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (minCost[i][k] < INF && minCost[k][j] < INF) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }

        // Step 4: Calculate the minimum cost to transform source to target
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            char sChar = source.charAt(i);
            char tChar = target.charAt(i);

            if (sChar == tChar) continue; // No cost if characters are already the same

            int from = sChar - 'a';
            int to = tChar - 'a';

            if (minCost[from][to] == INF) {
                // Transformation is not possible
                return -1;
            }

            totalCost += minCost[from][to];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String source1 = "abcd";
        String target1 = "acbe";
        char[] original1 = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed1 = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost1 = {2, 5, 5, 1, 2, 20};
        System.out.println(solution.minimumCost(source1, target1, original1, changed1, cost1)); // Output: 28

        // Example 2
        String source2 = "aaaa";
        String target2 = "bbbb";
        char[] original2 = {'a', 'c'};
        char[] changed2 = {'c', 'b'};
        int[] cost2 = {1, 2};
        System.out.println(solution.minimumCost(source2, target2, original2, changed2, cost2)); // Output: 12

        // Example 3
        String source3 = "abcd";
        String target3 = "abce";
        char[] original3 = {'a'};
        char[] changed3 = {'e'};
        int[] cost3 = {10000};
        System.out.println(solution.minimumCost(source3, target3, original3, changed3, cost3)); // Output: -1
    }
}
