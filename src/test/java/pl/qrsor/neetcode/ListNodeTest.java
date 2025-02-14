package pl.qrsor.neetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ListNodeTest {


    public static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(0, List.of(0)),
                Arguments.of(9, List.of(9)),
                Arguments.of(12, List.of(2,1)),
                Arguments.of(876543210, List.of(0,1,2,3,4,5,6,7,8))
        );
    }

    @ParameterizedTest
    @MethodSource("input")
    void shouldProductListFromInteger(int input, List<Integer> expected) {
        //when
        var result = ListNode.fromInteger(input);

        //then
        assertThat(result.toValList()).containsExactlyElementsOf(expected);
    }
}