class Solution {

    // total length - total odds  + 1 odd
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        int odds = 0;
        for (int v = 0; v < s.length(); v++) {
            odds += (++count[s.charAt(v)] & 1) == 1 ? 1 : -1;
        }
        return s.length() - odds + (odds > 0 ? 1 : 0);
    }
}
