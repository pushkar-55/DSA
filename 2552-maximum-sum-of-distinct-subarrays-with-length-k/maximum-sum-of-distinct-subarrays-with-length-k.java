class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        long sum = 0;
        long max = 0;

        for (int i = 0; i < nums.length; i++) {

            while (set.contains(nums[i])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            set.add(nums[i]);
            sum += nums[i];

            if (set.size() == k) {
                max = Math.max(max, sum);

                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return max;
    }
}