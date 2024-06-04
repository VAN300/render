package su.ivanserpov;

import su.ivanserpov.graphics.Axis;
import su.ivanserpov.graphics.Vector3D;
import su.ivanserpov.graphics.figures.Cube;
import su.ivanserpov.graphics.figures.Entity;

public class Application {
    private Render render;
    private Entity[] entities;

    public Application() {
        // Width - Terminal width
        // Height - Terminal height
        render = new Render(69, 33);

        entities = new Entity[1];

        entities[0] = new Cube(
                new Vector3D(30, 8, 0),
                16,
                (byte) '#');

        entities[0].rotate(Axis.X, Math.PI / 3);
    }

    public void start() {
        while (true) {
            draw();
            update();
        }
    }

    public void draw() {
        render.begin();
        for (int i = 0; i < entities.length; i++)
            entities[i].draw(render.getRenderContenxt());

        try {
            Thread.sleep((int) 1000 / 30);
        } catch (InterruptedException ignored) {
        }
        render.end();

    }

    public void update() {
        for (int i = 0; i < entities.length; i++) {
            // entities[i].rotate(Axis.X, Math.PI / 40);
            entities[i].rotate(Axis.Y, Math.PI / 40);
            entities[i].rotate(Axis.Z, Math.PI / 40);
        }
    }
}
