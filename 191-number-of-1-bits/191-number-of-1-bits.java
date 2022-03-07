public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //return bruteForce(n);
        //return divisionMethod(n);
        return bitwiseOp(n);
    }

    private int bruteForce(int n) {
        String binaryStr = Integer.toBinaryString(n);
        int count = 0;

        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }

    private int divisionMethod(int n) {
        int count = 0;

        // n > 0 will not work in case of negetive binary numbers
        // Use i: 0 to 31
        while (n > 0) {
            int rem = n % 2;

            if (rem == 1) {
                count++;
            }

            n = n / 2;
        }

        return count;
    }

    private int bitwiseOp(int n) {
        int count = 0;
        int len = 32;

        while (len-- >= 1) {
            if ((n & 1) == 1) {
                count++;
            }

            n = n >> 1;
        }

        return count;
    }
}
