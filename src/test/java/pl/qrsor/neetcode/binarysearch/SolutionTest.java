package pl.qrsor.neetcode.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    public static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[]{0}, 1, -1),
                Arguments.of(new int[]{0, 1}, 0, 0),
                Arguments.of(new int[]{0, 1}, 1, 1),
                Arguments.of(new int[]{-100, -50, 0, 50, 100}, -50, 1),
                Arguments.of(new int[]{-100, -50, 0, 20, 40, 100}, 20, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void shouldMatchExpectedResults(int[] nums, int target, int expected) {
        //when
        var result = new Solution().search(nums, target);

        //then
        assertEquals(expected, result);
    }
}