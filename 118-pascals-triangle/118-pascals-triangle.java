class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 1) {
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            res.add(currRow);
            return res;
        } else {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            res.add(firstRow);
            
            for (int i = 1; i < numRows; i++) {
                List<Integer> currRow = new ArrayList<>();

                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        currRow.add(1);
                    } else {
                        int val1 = res.get(i - 1).get(j - 1);
                        int val2 = res.get(i - 1).get(j);
                        currRow.add(val1 + val2);
                    }
                }

                res.add(currRow);
            }
        }

        return res;
    }
}
