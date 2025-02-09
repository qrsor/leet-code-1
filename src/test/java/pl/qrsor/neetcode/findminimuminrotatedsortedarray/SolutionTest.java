package pl.qrsor.neetcode.findminimuminrotatedsortedarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    public static Stream<Arguments> findMinArgument() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 6, 1, 2}, 1),
                Arguments.of(new int[]{4, 5, 0, 1, 2, 3}, 0),
                Arguments.of(new int[]{4, 5, 6, 7}, 4),
                Arguments.of(new int[]{6, 0, 1, 2, 3, 4, 5}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("findMinArgument")
    public void shouldFindMinInRotatedArray(int[] nums, int expected) {
        //when
        var result = new Solution().findMin(nums);

        //then
        assertThat(result).isEqualTo(expected);
    }
}