package br.com.jogorogerio.jumper.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;

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

    public static Paint getScoreColor() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        paint.setTextSize(100);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(10,5,5,0xFF000000);
        return paint;
    }
}
