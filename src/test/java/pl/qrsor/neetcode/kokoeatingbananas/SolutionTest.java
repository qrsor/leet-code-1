package pl.qrsor.neetcode.kokoeatingbananas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static Stream<Arguments> shouldCalculateEatingSpeedArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 3, 2}, 9, 2),
                Arguments.of(new int[]{25, 10, 23, 4}, 4, 25),
                Arguments.of(new int[]{805306368, 805306368, 805306368}, 1000000000, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("shouldCalculateEatingSpeedArguments")
    void shouldCalculateEatingSpeed(int[] piles, int h, int expected) {
        //when
        var result = new Solution().minEatingSpeed(piles, h);

        //then
        assertThat(result).isEqualTo(expected);
    }
}