##### Test cases
"A"
"Z"
"AA"
"AZ"
"AZA"
"AZZ"
​
#### Approach 1: Using Alphabet Enum
```
class Solution {
public int titleToNumber(String s) {
int n = s.length();
int pow =  0;
int decVal = 0;
for(int i=n-1; i >= 0; i--){
String c =  String.valueOf(s.charAt(i));
Albhabet albhabet= Albhabet.valueOf(c);
int codePoint = albhabet.codepoint;
decVal += (codePoint * Math.pow(26, pow));
pow++;
}
return decVal;
}
}
​
enum Albhabet{
A('A', 1),
B('B', 2),
C('C', 3),