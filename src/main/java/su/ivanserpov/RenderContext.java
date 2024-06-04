package su.ivanserpov;

import su.ivanserpov.graphics.Matrix;
import su.ivanserpov.graphics.Vector3D;

public class RenderContext {
    private final int width;
    private final int height;

    private byte[] buffer;

    private final double aspect;
    private final double symbolAspect;

    private Matrix projectionMatrix;

    public Matrix getProjectionMatrix() {
        return projectionMatrix;
    }

    public void setProjectionMatrix(Matrix projectionMatrix) {
        this.projectionMatrix = projectionMatrix;
    }

    public RenderContext(int width, int height) {
        this.width = width;
        this.height = height;

        this.buffer = new byte[width * height];

        this.aspect = (double) width / height;
        this.symbolAspect = 11 / 24;

        double[][] m = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 } };
        this.projectionMatrix = new Matrix(m);
    }

    public void drawLine(byte texture, Vector3D va) {
        va = va.multiplyByMatrix(projectionMatrix);

        int x = (int) Math.round(va.getX());
        int y = (int) Math.round(va.getY());

        if ((x + y * width) < buffer.length & x >= 0 & y >= 0)
            buffer[x + y * width] = texture;
    }

    public void reset() {
        buffer = new byte[width * height];
        for (int i = 0; i < buffer.length; i++)
            buffer[i] = ' ';
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public double getAspect() {
        return aspect;

    }

    public double getSymbolAspect() {
        return symbolAspect;
    }
}
