class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        
        if(l2 >= l1){
            
            StringBuilder sb = new StringBuilder();
            int i=0;
            
            String s1Sorted = sortString(s1);
            
            for(; i< l1; i++){
                sb.append(s2.charAt(i));
            }
            
            if(s1Sorted.equals(sortString(sb.toString()))){
                return true;
            }
            
            for(; i<l2; i++){
                sb.deleteCharAt(0);
                sb.append(s2.charAt(i));
                if(s1Sorted.equals(sortString(sb.toString()))){
                    return true;
                }   
            }
            
        }
        
        return false;
        
    }
    
    private String sortString(final String str){
        
        char[] cArr = str.toCharArray();
        Arrays.sort(cArr);
        return new String(cArr);
    }
}