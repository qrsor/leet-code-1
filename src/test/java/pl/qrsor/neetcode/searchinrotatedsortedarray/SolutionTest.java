package pl.qrsor.neetcode.searchinrotatedsortedarray;

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
                Arguments.of(new int[]{2, 0, 1}, 0, 1),
                Arguments.of(new int[]{2, 0, 1}, 1, 2),
                Arguments.of(new int[]{2, 0, 1}, 2, 0),
                Arguments.of(new int[]{3, 4, 5, 6, 1, 2}, 1, 4),
                Arguments.of(new int[]{3, 5, 6, 0, 1, 2}, 4, -1),
                Arguments.of(new int[]{3, 5, 6, 0, 1, 2}, 5, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void shouldVerifySearch(int[] nums, int target, int expected) {
        //when
        var result = new Solution().search(nums, target);

        //then
        assertThat(result).isEqualTo(expected);
    }
}