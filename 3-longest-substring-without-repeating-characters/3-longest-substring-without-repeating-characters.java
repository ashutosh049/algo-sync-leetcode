class Solution {

    public int lengthOfLongestSubstring(String str) {
        int len = str.length();
        int maxLen = 0, wStart = 0, wEnd = 0;
        Map<Character, Integer> indexMap = new HashMap<>();

        for (; wEnd < len; wEnd++) {
            char rChar = str.charAt(wEnd);

            Integer rCharPrevIndex = indexMap.get(rChar);

            if (rCharPrevIndex != null) {
                wStart = Math.max(wStart, rCharPrevIndex + 1);
            }

            indexMap.put(rChar, wEnd);
            maxLen = Math.max(maxLen, wEnd - wStart + 1);
        }

        return maxLen;
    }
}
