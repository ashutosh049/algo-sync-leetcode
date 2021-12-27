class Solution {
    // x=100
    // low = 2, high =50 
    
    // 2*2 >= 100
    // 3 >= 9
    // 4 >= 16
    // 5 >= 25
    // 6 >= 36
    public int mySqrt(int x) {
     
       if (x < 2) return x;

        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
          pivot = left + (right - left) / 2;
          num = (long)pivot * pivot;
          if (num > x) right = pivot - 1;
          else if (num < x) left = pivot + 1;
          else return pivot;
        }

        return right;
        
    }
}