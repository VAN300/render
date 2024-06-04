package su.ivanserpov.graphics;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D() {
        this.x = this.y = this.z = 0;
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Vector3D vector3d) {
        this.x = vector3d.getX();
        this.y = vector3d.getY();
        this.z = vector3d.getZ();
    }

    public Vector3D(Matrix matrix) {
        this.x = matrix.getElementByRowColumn(0, 0);
        this.y = matrix.getElementByRowColumn(1, 0);
        this.z = matrix.getElementByRowColumn(2, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Matrix getMatrix() {
        Matrix result = new Matrix(3, 1);
        result.setElementByRowColumn(0, 0, x);
        result.setElementByRowColumn(1, 0, y);
        result.setElementByRowColumn(2, 0, z);

        return result;
    }

    public Vector3D addVector(Vector3D vector3d) {
        double x = this.x + vector3d.getX();
        double y = this.y + vector3d.getY();
        double z = this.z + vector3d.getZ();

        return new Vector3D(x, y, z);
    }

    public Vector3D substractVector(Vector3D vector3d) {
        double x = this.x - vector3d.getX();
        double y = this.y - vector3d.getY();
        double z = this.z - vector3d.getZ();

        return new Vector3D(x, y, z);
    }

    public Vector3D multiply(double n) {
        return new Vector3D(x * n, y * n, z * n);
    }

    public Vector3D divide(double n) {
        return new Vector3D(x / n, y / n, z / n);
    }

    public Vector3D multiplyByMatrix(Matrix matrix) {
        Matrix resultMatrix = matrix.multiplyByMatrix(getMatrix());
        Vector3D vector3d = new Vector3D(resultMatrix);

        return vector3d;
    }

    public static Matrix getScalematrix(double x, double y, double z) {
        double[][] r = new double[3][3];

        r[0][0] = x;
        r[0][1] = 0;
        r[0][2] = 0;

        r[1][0] = 0;
        r[1][1] = y;
        r[1][2] = 0;

        r[2][0] = 0;
        r[2][1] = 0;
        r[2][2] = z;

        return new Matrix(r);
    }

    public static Matrix getXRotationMatrix(double angel) {
        double[][] r = new double[3][3];

        r[0][0] = 1;
        r[0][1] = 0;
        r[0][2] = 0;

        r[1][0] = 0;
        r[1][1] = Math.cos(angel);
        r[1][2] = -Math.sin(angel);

        r[2][0] = 0;
        r[2][1] = Math.sin(angel);
        r[2][2] = Math.cos(angel);

        return new Matrix(r);
    }

    public static Matrix getYRotationMatrix(double angel) {
        double[][] r = new double[3][3];

        r[0][0] = Math.cos(angel);
        r[0][1] = 0;
        r[0][2] = Math.sin(angel);

        r[1][0] = 0;
        r[1][1] = 1;
        r[1][2] = 0;

        r[2][0] = -Math.sin(angel);
        r[2][1] = 0;
        r[2][2] = Math.cos(angel);

        return new Matrix(r);
    }

    public static Matrix getZRotationMatrix(double angel) {
        double[][] r = new double[3][3];

        r[0][0] = Math.cos(angel);
        r[0][1] = -Math.sin(angel);
        r[0][2] = 0;

        r[1][0] = Math.sin(angel);
        r[1][1] = Math.cos(angel);
        r[1][2] = 0;

        r[2][0] = 0;
        r[2][1] = 0;
        r[2][2] = 1;

        return new Matrix(r);
    }


    @Override
    public String toString() {
        return String.format("(x=%s, y=%s, z=%s)", x, y, z);
    }
}