class Solution {

    public boolean isPalindrome(String s) {
        String str = lowercase(removeNonAlphanumeric(s));

        int len = str.length();

        if (len == 0) {
            return true;
        }

        boolean isPalidrome = true;
        int i = 0;

        while (i <= len / 2) {
            if (str.charAt(i) == str.charAt(len - 1 - i)) {
                i++;
            } else {
                isPalidrome = false;
                break;
            }
        }

        return isPalidrome;
    }

    private String lowercase(final String str) {
        return str.toLowerCase();
    }

    private String removeNonAlphanumeric(final String str) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            int cp = (int) c;
            if ((cp >= 65 && cp <= 90) || (cp >= 97 && cp <= 122) || (cp >= 48 && cp <= 57)) {
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }
}
