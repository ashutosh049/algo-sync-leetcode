### using Arrays.sort()
​
TC: `O(s log s)` , assuming, length of `s` and `t` are same
​
```jaav
class Solution {
public boolean isAnagram(String s, String t) {
if(s.length() != t.length()){
return false;
}
char[] sSorted = s.toCharArray();//O(s)
char[] tSorted = t.toCharArray();//O(t)
Arrays.sort(sSorted);//(slogs)
Arrays.sort(tSorted);//(tlogt)
boolean isAnagram = true;
//O(s)
for(int i=0; i < s.length(); i++){
if(sSorted[i] != tSorted[i]){
isAnagram = false;
break;
}
}
return isAnagram;
}
}
```