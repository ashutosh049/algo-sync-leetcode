class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int len = str.length();
        int wStart = 0;
        int wEnd = 0;
        int maxLength = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (; wEnd < len; wEnd++) {
            char rChar = str.charAt(wEnd);

            freqMap.put(rChar, freqMap.getOrDefault(rChar, 0) + 1);

            // if out map size exceeds K
            while (freqMap.size() > 2) {
                char lChar = str.charAt(wStart++);
                freqMap.put(lChar, freqMap.get(lChar) - 1);
                if (freqMap.get(lChar) == 0) {
                    freqMap.remove(lChar);
                }
            }

            maxLength = Math.max(maxLength, wEnd - wStart + 1);
        }

        return maxLength;
    }
}