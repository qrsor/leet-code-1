package pl.qrsor.neetcode.findminimuminrotatedsortedarray;

public class Solution {
    public int findMin(int[] nums) {
        var l = 0;
        var r = nums.length - 1;
        var res = nums[l];

        while (l <= r) {

            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            var mid = (l + r) / 2;
            res = Math.min(res, nums[mid]);

            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return res;
    }
}
