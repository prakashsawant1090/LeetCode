class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for(int x:nums) ans = ans ^ x;

        return ans;
    }
}