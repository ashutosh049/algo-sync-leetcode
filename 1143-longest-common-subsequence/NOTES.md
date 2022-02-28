​
int maxLength = dp(0, 0);
System.out.println("seq: "+seq);
return maxLength;
}
​
private int dp(int i, int j) {
if (i == l1 || j == l2) {
return 0;
}
​
if (memo[i][j] == null) {
int maxLength = 0;
​
if (text1.charAt(i) == text2.charAt(j)) {
seq += text1.charAt(i);
maxLength = dp(i + 1, j + 1) + 1;
} else {
maxLength = Math.max(dp(i, j + 1), dp(i + 1, j));
}
​
memo[i][j] = maxLength;
}
​
return memo[i][j];
}
}
​
```
​
​