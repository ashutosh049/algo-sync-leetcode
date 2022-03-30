class Solution {

    public List<List<String>> groupAnagrams(String[] arr) {
        int len = arr.length;
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> anagramsKeyMap = new HashMap<>();

        if (len == 0) {
            return res;
        }

        for (String s : arr) {
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            String anagramKey = new String(cArr);

            List<String> anagrams = anagramsKeyMap.getOrDefault(anagramKey, new ArrayList<String>());

            anagrams.add(s);
            anagramsKeyMap.put(anagramKey, anagrams);
        }

        for (Map.Entry<String, List<String>> entry : anagramsKeyMap.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
