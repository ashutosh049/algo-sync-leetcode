class Solution {
    public boolean canPermutePalindrome(String s) {
        
        Set<Character> charSet = new HashSet<>();
        
        for(char c: s.toCharArray()){
            if(charSet.contains(c)){
                charSet.remove(c);
            }else{
                charSet.add(c);
            }
        }
        
        return charSet.size() < 2;
        
    }
}