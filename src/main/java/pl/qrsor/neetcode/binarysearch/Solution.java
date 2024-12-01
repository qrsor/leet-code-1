package pl.qrsor.neetcode.binarysearch;

class Solution {
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        var leftIndex = 0;
        var rightIndex = nums.length - 1;


        while (leftIndex <= rightIndex) {
            int indexToCheck = (rightIndex + leftIndex) / 2;
            var numberToCheck = nums[indexToCheck];
            if (target > numberToCheck) {
                leftIndex = indexToCheck + 1;
            } else if (target < numberToCheck) {
                rightIndex = indexToCheck - 1;
            } else {
                return indexToCheck;
            }
        }

        return -1;
    }
}
