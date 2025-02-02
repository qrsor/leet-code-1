package pl.qrsor.neetcode.search2dmatrix;

public class Solution {

    record Dimensions(int row, int column) {}

    public static class Matrix {
        private final int rowCount;
        private final int columnCount;
        private final int[][] matrix;

        Matrix(int[][] matrix) {
            this.matrix = matrix;
            this.rowCount = matrix.length;
            this.columnCount = matrix[0].length;
        }

        Dimensions toDimensions(int index) {
            var row = index / columnCount;
            var column = index - row * columnCount;
            return new Dimensions(row, column);
        };

        int toIndex(Dimensions dimensions) {
            return dimensions.row * columnCount + dimensions.column;
        }

        int get(int index) {
            var dimensions = toDimensions(index);
            return matrix[dimensions.row][dimensions.column];
        }

        int size() {
            return toIndex(new Dimensions(rowCount - 1, columnCount - 1));
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        var wrappedMatrix = new Matrix(matrix);

        if (target < wrappedMatrix.get(0) || target > wrappedMatrix.get(wrappedMatrix.size())) {
            return false;
        }

        var leftIndex = 0;
        var rightIndex = wrappedMatrix.size();


        while (leftIndex <= rightIndex) {
            int indexToCheck = (rightIndex + leftIndex) / 2;
            var numberToCheck = wrappedMatrix.get(indexToCheck);
            if (target > numberToCheck) {
                leftIndex = indexToCheck + 1;
            } else if (target < numberToCheck) {
                rightIndex = indexToCheck - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
