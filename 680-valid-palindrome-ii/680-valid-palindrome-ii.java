class Solution {

    public boolean validPalindrome(String s) {
        int len = s.length();
        boolean isPalidrome = true;

        int left = 0;
        int right = len - 1;

        while (left < right) {
            
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            if (leftChar == rightChar) {
                left++;
                right--;
            } else{
                boolean leftSkipped =isPalidrome(s, left+1, right);
                boolean rightSkipped =isPalidrome(s, left, right-1);
                return (leftSkipped || rightSkipped);
            }
          
        }

        return isPalidrome;
    }

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
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar == rightChar) {
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
