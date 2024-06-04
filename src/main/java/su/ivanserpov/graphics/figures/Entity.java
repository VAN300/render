package su.ivanserpov.graphics.figures;

import su.ivanserpov.RenderContext;
import su.ivanserpov.graphics.Axis;
import su.ivanserpov.graphics.Matrix;
import su.ivanserpov.graphics.Vector3D;

public abstract class Entity {

    protected Vector3D[] vertices;
    protected byte texture;
    protected Vector3D center;

    public Vector3D getCenter() {
        return center;
    }

    public void setCenter(Vector3D center) {
        this.center = center;
    }

    public void rotate(Axis axis, double angel) {
        Matrix rotation = null;

        switch (axis) {
            case Axis.X ->
                rotation = Vector3D.getXRotationMatrix(angel);
            case Axis.Y ->
                rotation = Vector3D.getYRotationMatrix(angel);
            case Axis.Z ->
                rotation = Vector3D.getZRotationMatrix(angel);
        }

        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = vertices[i].substractVector(center);
            vertices[i] = vertices[i].multiplyByMatrix(rotation);
            vertices[i] = vertices[i].addVector(center);
        }

    }

    public void scale(Matrix sMatrix) {
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = vertices[i].substractVector(center);
            vertices[i] = vertices[i].multiplyByMatrix(sMatrix);
            vertices[i] = vertices[i].addVector(center);
        }
    }

    public abstract void draw(RenderContext context);

}
