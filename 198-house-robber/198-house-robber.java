class Solution {
    int len;
    Integer[] memoArr;
    int[] nums;

    public int rob(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        this.memoArr = new Integer[this.len];

        if (this.len == 1) {
            return nums[0];
        } else if (this.len == 2) {
            return Math.max(nums[1], nums[0]);
        } else {
            memoArr[0] = nums[0];
            memoArr[1] = Math.max(nums[1], nums[0]);
            return func(len - 1);
        }
    }

    Integer func(int i) {
        if (i <= 1) {
            return memoArr[i];
        }

        if (memoArr[i] == null) {
            int prevAns = func(i - 1);
            int prevToPrevAns = func(i - 2);
            memoArr[i] = Math.max(prevAns, prevToPrevAns + nums[i]);
        }

        return memoArr[i];
    }
}
