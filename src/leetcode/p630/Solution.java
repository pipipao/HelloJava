package leetcode.p630;

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
    }
}

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int j = k; j < nums.length; j++) {
            sum += nums[j];
            sum -= nums[j - k];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return (double) maxSum/k;
    }
}
