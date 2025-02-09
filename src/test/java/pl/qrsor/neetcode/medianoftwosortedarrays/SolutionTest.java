package pl.qrsor.neetcode.medianoftwosortedarrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    public static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6}, 3.5)
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void shouldFindMedian(int[] nums1, int[] nums2, double expected) {
        //given
        var result = new Solution().findMedianSortedArrays(nums1, nums2);

        //then
        assertThat(result).isEqualTo(expected);
    }
}