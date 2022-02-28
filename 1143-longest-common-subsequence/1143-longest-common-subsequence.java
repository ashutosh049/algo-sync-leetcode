class Solution {
    private String text1;
    private String text2;
    private int l1;
    private int l2;
    private Integer[][] memo;
    private String seq;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.l1 = text1.length();
        this.l2 = text2.length();
        this.memo = new Integer[l1 + 1][l2 + 1];
        this.seq = "";
        
        if (l1 == 0 || l2 == 0) {
            return 0;
        }
        if (l1 == 1) {
            return (text2.contains(text1)) ? 1 : 0;
        } else if (l2 == 1) {
            return (text1.contains(text2)) ? 1 : 0;
        }

        int maxLength = dp(0, 0);
        System.out.println("seq: "+seq);
        return maxLength;
    }

    private int dp(int i, int j) {
        if (i == l1 || j == l2) {
            return 0;
        }

        if (memo[i][j] == null) {
            int maxLength = 0;

            if (text1.charAt(i) == text2.charAt(j)) {
                seq += text1.charAt(i);
                maxLength = dp(i + 1, j + 1) + 1;
            } else {
                maxLength = Math.max(dp(i, j + 1), dp(i + 1, j));
            }

            memo[i][j] = maxLength;
        }

        return memo[i][j];
    }
}
