package br.com.jogorogerio.jumper.graphic;

import android.graphics.Paint;

/**
 * Created by Rogerio on 16/08/2016.
 */
public class CustomColors {
    public static Paint getBirdColor() {

        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        return paint;
    }


    public static Paint getPipeColor() {
        Paint paint = new Paint();
        paint.setColor(0xFF00FF00);
        return paint;
    }
}
