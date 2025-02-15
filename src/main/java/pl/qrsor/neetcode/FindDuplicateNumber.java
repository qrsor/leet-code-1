package pl.qrsor.neetcode;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        var fast = nums[0];
        var slow = nums[0];

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        var slow2 = nums[0];
        while (slow != slow2) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }

        return slow;
    }

}
