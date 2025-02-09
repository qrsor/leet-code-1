package pl.qrsor.neetcode.medianoftwosortedarrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] A, B;
        if (nums1.length < nums2.length) {
            A = nums1;
            B = nums2;
        } else {
            A = nums2;
            B = nums1;
        }

        var total = A.length + B.length;
        var half = (total + 1) / 2;
        var l = 0;
        var r = A.length;

        while (l <= r) {
            var i = (l + r) / 2;
            var j = half - i;

            var Al = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            var Ar = i < A.length ? A[i] : Integer.MAX_VALUE;
            var Bl = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            var Br = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (Al <= Br && Bl <= Ar) {
                if (total % 2 != 0) {
                    return Math.max(Al, Bl);
                }
                return (Math.max(Al, Bl) + Math.min(Ar, Br)) / 2.0;
            } else if (Al > Br) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return -1;
    }
}
