package pl.qrsor.neetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DiameterOfBinaryTreeTest {
    public static Stream<Arguments> diameterOfBinaryTreeInput() {
        return Stream.of(
                Arguments.of(TreeNode.fromIntegers(IntStream.range(1, 255).boxed().toList()), 14),
                Arguments.of(TreeNode.fromIntegers(IntStream.range(1, 127).boxed().toList()), 12),
                Arguments.of(TreeNode.fromIntegers(List.of(1)), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("diameterOfBinaryTreeInput")
    void shouldCalculateDiameterOfBinaryTree(TreeNode root, int expected) {
        //when
        var result = new DiameterOfBinaryTree().diameterOfBinaryTree(root);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}