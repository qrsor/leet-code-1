package pl.qrsor.neetcode.searchinrotatedsortedarray;

public class Solution {
    public int search(int[] nums, int target) {

        var res = -1;
        var l = 0;
        var r = nums.length - 1;

        while (l <= r) {
            var m = (l + r) / 2;

            if (nums[m] == target) {
                res = m;
                break;
            }

            if (nums[l] <= nums[m]) {
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (target < nums[m] || target > nums [r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return res;
    }
}
