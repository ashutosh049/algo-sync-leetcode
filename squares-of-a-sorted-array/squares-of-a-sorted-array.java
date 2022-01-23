class Solution {
    // Total TC : O(n) * O(n log n)= O(n log n)
    public int[] sortedSquares(int[] nums) {
        
        // linear scan to suare the nums: O(n)
        for(int i=0; i< nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        // sort: O(n log n)
        Arrays.sort(nums);
        
        return nums;
        
    }
    
//   private int partition(int array[], int low, int high) {
    
//     int pivot = array[high];
    
//     int i = (low - 1);

//     for (int j = low; j < high; j++) {
//       if (array[j] <= pivot) {

//         i++;

//         int temp = array[i];
//         array[i] = array[j];
//         array[j] = temp;
//       }

//     }

//     int temp = array[i + 1];
//     array[i + 1] = array[high];
//     array[high] = temp;

//     return (i + 1);
//   }

  // private void quickSort(int array[], int low, int high) {
  //   if (low < high) {
  //     int pi = partition(array, low, high);
  //     quickSort(array, low, pi - 1);
  //     quickSort(array, pi + 1, high);
  //   }
  // }
        
}