package pl.qrsor.neetcode;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaximumDepthOfBinaryTreeTest {

    public static Stream<Arguments> binaryTreeSource() {
        return Stream.of(
                Arguments.of(TreeNode.fromIntegers(asList(1, null, 2, null, null, 3)), 3),
                Arguments.of(TreeNode.fromIntegers(List.of(1)), 1),
                Arguments.of(TreeNode.fromIntegers(IntStream.range(1, 255).boxed().toList()), 8)

        );
    }

    @ParameterizedTest
    @MethodSource("binaryTreeSource")
    public void shouldCalculateBinaryTreeDepth(TreeNode root, int expected) {
        //when
        var result = new MaximumDepthOfBinaryTree().maxDepth(root);

        //then
        assertThat(result).isEqualTo(expected);
    }
}