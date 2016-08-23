package br.com.jogorogerio.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.jogorogerio.jumper.R;
import br.com.jogorogerio.jumper.graphic.CustomColors;
import br.com.jogorogerio.jumper.graphic.Screen;

/**
 * Created by Rogerio on 16/08/2016.
 */
public class Bird {

    public static final float x = 100;
    public static final int RADIUS = 50;
    public static final Paint red = CustomColors.getBirdColor();
    private Screen screen;
    private float height;
    private Bitmap bird;
    public Bird(Screen screen, Context context) {
        height = 100;
        this.screen = screen;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird);
        bird = Bitmap.createScaledBitmap(bp, RADIUS * 2, RADIUS * 2, false);
    }

    public void drawOnCanvas(Canvas canvas) {
        //canvas.drawCircle(x, height, RADIUS, red);
        canvas.drawBitmap(bird, x - RADIUS, height - RADIUS, null);
    }

    public void fall() {
        boolean hitGround = height + RADIUS > screen.getHeight();
        if(!hitGround) {
            this.height += 15;
        }
    }

    public void jump() {
        if(height - RADIUS > 0)
            this.height -= 150;
    }

    public float getHeight() {
        return this.height;
    }
}
