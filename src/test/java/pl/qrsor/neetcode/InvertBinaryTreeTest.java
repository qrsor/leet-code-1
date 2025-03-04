package pl.qrsor.neetcode;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InvertBinaryTreeTest {
    public static Stream<Arguments> shouldInvertTreeInput() {
        return Stream.of(
                Arguments.of(List.of(1), List.of(1)),
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 2)),
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 2)),
                Arguments.of(List.of(1, 2), Stream.of(1, null, 2).toList())
        );
    }

    @ParameterizedTest
    @MethodSource("shouldInvertTreeInput")
    void shouldInvertTree(List<Integer> input, List<Integer> expected) {
        //given
        var root = TreeNode.fromIntegers(input.getFirst(), input.subList(1, input.size()).stream().mapToInt(Integer::intValue).toArray());

        //when
        var result = new InvertBinaryTree().invertTree(root);

        //then
        assertThat(result.toValList()).containsExactlyElementsOf(expected);
    }

    @Test
    void shouldReturnEmptyGivenEmptyTree() {
        //given
        TreeNode root = null;

        //when
        var result = new InvertBinaryTree().invertTree(root);

        //then
        assertThat(result).isNull();
    }
}