package br.com.jogorogerio.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.jogorogerio.jumper.graphic.CustomColors;

/**
 * Created by Rogerio on 16/08/2016.
 */
public class Bird {

    public static final float x = 100;
    public static final float radius = 50;
    public static final Paint red = CustomColors.getBirdColor();
    private float height;
    public Bird() {
        height = 100;
    }

    public void drawOnCanvas(Canvas canvas) {
        canvas.drawCircle(x, height, radius, red);
    }

    public void fall() {
        this.height += 5;
    }

    public void jump() {
        this.height -= 150;
    }
}
