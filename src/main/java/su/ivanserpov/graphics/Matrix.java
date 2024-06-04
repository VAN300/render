package su.ivanserpov.graphics;

public class Matrix {
    private double[][] matrixArray;
    private final int r;
    private final int c;

    public Matrix(int r, int c) {
        this.r = r;
        this.c = c;
        this.matrixArray = new double[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrixArray[i][j] = 0;
            }
        }
    }

    public Matrix(double[][] matrixArray) {
        this.r = matrixArray.length;
        this.c = matrixArray[0].length;
        this.matrixArray = matrixArray;
    }

    public int getR() {
        return this.r;
    }

    public int getC() {
        return this.c;
    }

    public double[][] getAsArray2D() {
        return matrixArray;
    }

    public void setElementByRowColumn(int r, int c, double element) {
        this.matrixArray[r][c] = element;
    }

    public double getElementByRowColumn(int r, int c) {
        return this.matrixArray[r][c];
    }

    public Matrix multiplyByNumber(double n) {
        Matrix result = new Matrix(r, c);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                double newElement = getElementByRowColumn(i, j) * n;
                result.setElementByRowColumn(i, j, newElement);
            }
        }

        return result;
    }

    public Matrix multiplyByMatrix(Matrix matrix) {
        Matrix result = new Matrix(getR(), matrix.getC());

        for (int i = 0; i < getR(); i++) {
            for (int j = 0; j < matrix.getC(); j++) {
                double element = 0;

                for (int k = 0; k < matrix.getR(); k++)
                    element += getElementByRowColumn(i, k) * matrix.getElementByRowColumn(k, j);
                result.setElementByRowColumn(i, j, element);
            }
        }

        return result;
    }
}
