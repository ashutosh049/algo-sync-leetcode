class Solution {
    Integer[][] memo;
    int l1;
    int l2;
    String text1;
    String text2;
    String longestCommonSubsequenceString;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.l1 = text1.length();
        this.l2 = text2.length();
        this.memo = new Integer[l1 + 1][l2 + 1]; // default, require to fill all with -1 or some dummy values
        this.longestCommonSubsequenceString = "";

        int res = 0;

        //  badic checks
        // 1. emtpy check
        if (l1 == 0 || l2 == 0) {
            return res;
        }
        // 2. single char check
        if (l1 == 1) {
            return text2.indexOf(text1.charAt(0)) != -1 ? 1 : 0;
        } else if (l2 == 1) {
            return text1.indexOf(text2.charAt(0)) != -1 ? 1 : 0;
        }
        // else do full check: dp

        res = dp(0, 0);
        //System.out.println("longest string: " + longestCommonSubsequenceString+ " , length: " + res);
        return res;
    }

    //
    private int dp(int i, int j) {
        //if i have ans for i and j or i & j are at end.
        if (i >= l1 || j >= l2) {
            return 0;
        }

        if (memo[i][j] == null) {
            int length = 0;

            if (text1.charAt(i) == text2.charAt(j)) {
                longestCommonSubsequenceString += text1.charAt(i);
                length = 1 + dp(i + 1, j + 1);
            } else {
                length = Math.max(dp(i, j + 1), dp(i + 1, j));
            }

            memo[i][j] = length;
        }

        return memo[i][j];
    }
}
