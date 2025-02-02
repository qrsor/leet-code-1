package pl.qrsor.neetcode.search2dmatrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[][]{{0}}, 1, false),
                Arguments.of(new int[][]{{0}}, 0, true),
                Arguments.of(new int[][]{{0}, {10}}, 2, false)
                ,
                Arguments.of(new int[][]{{0, 5}, {10, 34}}, 2, false),
                Arguments.of(new int[][]{{0, 5}, {10, 34}}, 10, true),
                Arguments.of(new int[][]{{0, 2, 5, 6}, {10, 14, 16, 17}}, 4, false),
                Arguments.of(new int[][]{{0, 2, 5, 6}, {10, 14, 16, 17}}, 2, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void shouldMatchExpectedResults(int[][] matrix, int target, boolean expected) {
        //when
        var result = new Solution().searchMatrix(matrix, target);

        //then
        assertEquals(expected, result);
    }

    public static Stream<Arguments> toIndexParameters() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 1, 1),
                Arguments.of(0, 2, 2),
                Arguments.of(0, 3, 3),
                Arguments.of(1, 0, 4),
                Arguments.of(1, 1, 5),
                Arguments.of(1, 2, 6),
                Arguments.of(1, 3, 7),
                Arguments.of(2, 0, 8),
                Arguments.of(2, 1, 9),
                Arguments.of(2, 2, 10),
                Arguments.of(2, 3, 11)
        );
    }

    @ParameterizedTest
    @MethodSource("toIndexParameters")
    void shouldConvertToIndex(int row, int column, int expected) {
        //given
        var matrix = new int[][]{{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};

        //when
        var result = new Solution.Matrix(matrix).toIndex(new Solution.Dimensions(row, column));

        //then
        assertEquals(expected, result);
    }

    public static Stream<Arguments> toDimensionsParameters() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 0, 1),
                Arguments.of(2, 0, 2),
                Arguments.of(3, 0, 3),
                Arguments.of(4, 1, 0),
                Arguments.of(5, 1, 1),
                Arguments.of(6, 1, 2),
                Arguments.of(7, 1, 3),
                Arguments.of(8, 2, 0),
                Arguments.of(9, 2, 1),
                Arguments.of(10, 2, 2),
                Arguments.of(11, 2, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("toDimensionsParameters")
    void shouldConvertToDimensions(int index, int expectedRow, int expectedColumn) {
        //given
        var matrix = new int[][]{{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};

        //when
        var result = new Solution.Matrix(matrix).toDimensions(index);

        //then
        assertEquals(expectedRow, result.row());
        assertEquals(expectedColumn, result.column());
    }
}