package Model;

import javax.tools.Tool;
import java.awt.*;

public class Slot {
    private int x,y;
    private int width,height;
    Color color;
    Stroke stroke;

    public Slot(int x, int y) {
        this.x = x;
        this.y = y;
        width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 21;
        height  = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 21;
        color = new Color(255, 0, 0, 100);
    }

    public Color getColor() {
        return color;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
