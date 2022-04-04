class Solution {

    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;

        if (n <= 0) return 0;

        boolean[][] dp = new boolean[n][n];

        // Base case: single letter substrings
        for (int i = 0; i < n; ++i, ++ans) dp[i][i] = true;

        // Base case: double letter substrings
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            ans += (dp[i][i + 1] ? 1 : 0);
        }

        // All other cases: substrings of length 3 to n
        for (int len = 3; len <= n; ++len) for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
            dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            ans += (dp[i][j] ? 1 : 0);
        }
        
        //printBooleanMatrixArray(dp);

        return ans;
    }

    private void printBooleanMatrixArray(boolean[][] matrixArray) {
        System.out.println("[");
        for (int i = 0; i < matrixArray.length; i++) {
            System.out.print("\t[");
            boolean[] innerArray = matrixArray[i];
            for (int j = 0; j < innerArray.length; j++) {
                System.out.print(innerArray[j] ? 1 : 0);
                if (j < innerArray.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < matrixArray.length - 1) {
                System.out.println(",");
            }
        }
        System.out.println("\n]");
    }
}
