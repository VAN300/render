package su.ivanserpov;

import java.io.IOException;

public class Render {
    private final RenderContext context;

    public Render(int width, int height) {
        this.context= new RenderContext(width, height);
    }

    public void begin() {
        context.reset();
    }

    public void end() {
        try {
            System.out.write(context.getBuffer());
        } catch (IOException i) {}
    }

    public RenderContext getRenderContenxt() {
        return context;
    }
}