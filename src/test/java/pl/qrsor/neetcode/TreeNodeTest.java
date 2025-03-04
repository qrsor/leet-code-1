package pl.qrsor.neetcode;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TreeNodeTest {
    public static Stream<Arguments> shouldCreateBinaryTreeFromValuesInput() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("shouldCreateBinaryTreeFromValuesInput")
    void shouldCreateBinaryTreeFromValues(List<Integer> input) {
        //when
        var result = TreeNode.fromIntegers(input.getFirst(), input.subList(1, input.size()).stream().mapToInt(Integer::intValue).toArray());

        //then
        assertThat(result.toValList()).containsExactlyElementsOf(input);
    }

    @Test
    void shouldCreateSingleNodeTree() {
        //when
        var result = TreeNode.fromIntegers(999);

        //then
        assertThat(result.toValList()).containsExactly(999);
    }

    @Test
    void shouldConvertTreeToValueListGivenTreeWithoutLeftNode() {
        //given
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        //when
        var result = root.toValList();

        //then
        assertThat(result).containsExactly(1, null, 2);
    }

    @Test
    void shouldConvertTreeToValueListGivenTreeWithoutRightNode() {
        //given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        //when
        var result = root.toValList();

        //then
        assertThat(result).containsExactly(1, 2);
    }

    @Test
    void shouldConvertTreeToValueListGivenTreeWithoutLeafs() {
        //given
        TreeNode root = new TreeNode(1);

        //when
        var result = root.toValList();

        //then
        assertThat(result).containsExactly(1);
    }

    @Test
    void shouldConvertTreeToValueListGivenTreeWithOneLeaf() {
        //given
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        //when
        var result = root.toValList();

        //then
        assertThat(result).containsExactly(1, 2, 3, null, null, null, 7);
    }


}