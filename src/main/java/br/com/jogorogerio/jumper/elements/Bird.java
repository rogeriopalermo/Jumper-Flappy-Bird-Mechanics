package br.com.jogorogerio.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.jogorogerio.jumper.graphic.CustomColors;
import br.com.jogorogerio.jumper.graphic.Screen;

/**
 * Created by Rogerio on 16/08/2016.
 */
public class Bird {

    public static final float x = 100;
    public static final float radius = 50;
    public static final Paint red = CustomColors.getBirdColor();
    private Screen screen;
    private float height;
    public Bird(Screen screen) {
        height = 100;
        this.screen = screen;
    }

    public void drawOnCanvas(Canvas canvas) {
        canvas.drawCircle(x, height, radius, red);
    }

    public void fall() {
        boolean hitGround = height + radius > screen.getHeight();
        if(!hitGround) {
            this.height += 5;
        }
    }

    public void jump() {
        if(height - radius > 0)
            this.height -= 150;
    }
}
