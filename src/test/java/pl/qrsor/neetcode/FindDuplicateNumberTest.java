package pl.qrsor.neetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindDuplicateNumberTest {
    public static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{1, 2, 2}, 2),
                Arguments.of(new int[]{3, 1, 2, 3}, 3),
                Arguments.of(new int[]{3, 1, 3, 4, 2}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    public void shouldFindDuplicate(int[] input, int expected) {
        //when
        var result = new FindDuplicateNumber().findDuplicate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }
}