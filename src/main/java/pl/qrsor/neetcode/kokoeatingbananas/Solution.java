package pl.qrsor.neetcode.kokoeatingbananas;

import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = 1;

        while (l <= r) {

            var k = ((l + r) / 2);

            var eatTime = calculateEatTime(piles, k);
            if (eatTime <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }

    private long calculateEatTime(int[] piles, int k) {
        return Arrays.stream(piles).asLongStream().map(pile -> Math.ceilDiv((long)pile, k)).sum();
    }
}