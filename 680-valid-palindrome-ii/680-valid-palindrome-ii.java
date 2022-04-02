class Solution {

    public boolean validPalindrome(String s) {
        int len = s.length();
        boolean isPalidrome = true;

        int left = 0;
        int right = len - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Get the first char which is unequal.
                // Skip left char and check for palindrome and similarly, skip right and check
                return (isPalidrome(s, left + 1, right) || isPalidrome(s, left, right - 1));
            }
        }

        return isPalidrome;
    }

    // Classic palidrome check using 2 pointer
    private boolean isPalidrome(String s, int left, int right) {
        int len = s.length();

        if (len == 1) {
            return true;
        }

        if (left > right) {
            return false;
        }

        boolean isPalidrome = true;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                isPalidrome = false;
                break;
            }
        }

        return isPalidrome;
    }
}
