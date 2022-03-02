class Solution {

    public int maxSubArray(int[] nums) {
        //return bruteForce(nums);
        //return maxSumSliding(nums);
        //return maxSumKadane(nums);
        //return maxSumKadane_1(nums);
        return maxSumKadane_2(nums);
    }

    private int bruteForce(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int windowSum = 0;
                for (int k = i; k <= j; k++) {
                    windowSum += arr[k];
                }
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        return maxSum;
    }

    private static int maxSumSliding(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int windowSum = 0;
            for (int j = i; j < arr.length; j++) {
                windowSum += arr[j];
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        return maxSum;
    }

    private int maxSumKadane(int[] arr) {
        int maxSum = arr[0];
        int curSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curSum = Math.max(arr[i], curSum + arr[i]);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    private int maxSumKadane_1(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            curSum = Math.max(curSum, arr[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
    
    private int maxSumKadane_2(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            maxSum = Math.max(maxSum, curSum);
            if(curSum < 0){
                curSum = 0;
            }
        }
        return maxSum;
    }    
}
