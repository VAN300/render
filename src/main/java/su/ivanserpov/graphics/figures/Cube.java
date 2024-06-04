package su.ivanserpov.graphics.figures;

import su.ivanserpov.RenderContext;
import su.ivanserpov.graphics.Axis;
import su.ivanserpov.graphics.Matrix;
import su.ivanserpov.graphics.Vector3D;

public class Cube extends Entity {
    private Entity[] sqares;

    public Cube(Vector3D position, double size, byte texture) {
        this.texture = texture;
        this.sqares = new Entity[6];
        this.center = new Vector3D(position.getX() + size / 2, position.getY() + size / 2, position.getZ() + size / 2);

        sqares[0] = new Square(
                position,
                size, (byte) '\'');

        sqares[1] = new Square(
                new Vector3D(position.getX(), position.getY(), position.getZ()),
                size, (byte) '/');

        sqares[1].setCenter(center);
        sqares[1].rotate(Axis.Y, Math.PI / 2);

        sqares[2] = new Square(
                new Vector3D(position.getX(), position.getY(), position.getZ()),
                size, (byte) '7');

        sqares[2].setCenter(center);
        sqares[2].rotate(Axis.X, Math.PI / 2);

        sqares[3] = new Square(
                new Vector3D(position.getX(), position.getY(), position.getZ()),
                size, (byte) '$');

        sqares[3].setCenter(center);
        sqares[3].rotate(Axis.X, -Math.PI / 2);

        sqares[4] = new Square(
                new Vector3D(position.getX(), position.getY(), position.getZ()),
                size, (byte) 'm');

        sqares[4].setCenter(center);
        sqares[4].rotate(Axis.Y, -Math.PI / 2);

        sqares[5] = new Square(
                new Vector3D(position.getX(), position.getY(), position.getZ()),
                size, texture);

        sqares[5].setCenter(center);
        sqares[5].rotate(Axis.Z, Math.PI / 2);
    }

    @Override
    public void draw(RenderContext context) {
        for (int i = 0; i < sqares.length; i++) {
            sqares[i].draw(context);
        }
    }

    @Override
    public void rotate(Axis axis, double angel) {
        for (int i = 0; i < sqares.length; i++) {
            sqares[i].rotate(axis, angel);
        }
    }

    @Override
    public void scale(Matrix sMatrix) {
        for (int i = 0; i < sqares.length; i++) {
            sqares[i].scale(sMatrix);
        }
    }

}
