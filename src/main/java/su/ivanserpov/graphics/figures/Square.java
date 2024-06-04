package su.ivanserpov.graphics.figures;

import su.ivanserpov.RenderContext;
import su.ivanserpov.graphics.Vector3D;

public class Square extends Entity {

    public Square(Vector3D position, double size, byte texture) {
        this.texture = texture;
        this.vertices = new Vector3D[(int) (size * size)];
        this.center = new Vector3D(position.getX() + size / 2, position.getY() + size / 2, position.getZ() + size / 2);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                vertices[i + j * (int)size] = new Vector3D(position.getX() + i, position.getY() + j, position.getZ());
            }
        }
    }

    @Override
    public void draw(RenderContext context) {
        for (int i = 0; i < vertices.length; i++)
            context.drawLine(texture, vertices[i]);

    }

}
